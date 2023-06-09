package com.likes.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.constant.Constants;
import com.likes.common.constant.RedisKeys;
import com.likes.common.constant.SystemTips;
import com.likes.common.enums.LoginUserTypeEnum;
import com.likes.common.enums.StatusCode;
import com.likes.common.enums.SysParameterEnum;
import com.likes.common.model.LoginUser;
import com.likes.common.mybatis.entity.SysParameter;
import com.likes.common.service.sys.SysParamService;
import com.likes.common.util.*;
import com.likes.common.util.redis.RedisBusinessUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author abu
 * @version 1.0
 * @Description
 * @revise
 * @time 2018年6月6日 下午5:15:50
 */
@Component
public class SystemInterceptor extends HandlerInterceptorAdapter {

    protected Logger logger = LogManager.getLogger(getClass());

    @Resource
    private SysParamService sysParamService;

    //请求开始时间
    private long requestStartTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "sign, token, clientType, version");

//        String language = request.getHeader("language");
//        LanguageUtil.setTimeZone(language);

        requestStartTime = System.currentTimeMillis();
        String uri = BaseUtil.getRequestUri(request);
        String acctoken = request.getHeader(Constants.ACCTOKEN_KEY);
        String clientType = request.getHeader(Constants.CLIENT_TYPE_STRING);
        String userIP = request.getHeader(Constants.HEADER_USER_IP);
        String feginSign = request.getHeader(Constants.FEGIN_SIGN);
        String phoneModel = request.getHeader(Constants.CLIENT_PHONE_MODEL);
        logger.info("{} 请求开始 uri:{}, clientType:{}, phoneModel:{}, userIP:{}, params:{}, headers:{}", acctoken, uri, clientType, phoneModel, userIP, BaseUtil.getRequestParameters(request), BaseUtil.getHeaders(request));

        //判断系统是否处于系统维护状态
        if (RedisBusinessUtil.exists(RedisKeys.LIVE_SYSTEM_MAINTENANCE_STATUS)) {
            if (BaseUtil.isNotExistsWhiteIp(acctoken, userIP, request, response)) {
                return false;
            }
        }

        //是否IP限制
        if (RedisBusinessUtil.isIpRestrict(userIP, sysParamService, acctoken)) {
            BaseUtil.writerResponse(response, StatusCode.IP_RESTRICT);
            return false;
        }

        if (!(handler instanceof HandlerMethod)) {
            return false;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.getAnnotation(AllowAccess.class) != null || isWhiteUri(uri)) {
            if(StringUtils.isBlank(acctoken)){
                request.getSession().setAttribute(Constants.APP_LOGIN_INFO, null);
            }
            return super.preHandle(request, response, handler);
        } else if (org.apache.commons.lang3.StringUtils.isNotBlank(feginSign) && Constants.FEGIN_SIGN_VALUE.equals(feginSign) && StringUtils.isEmpty(acctoken)) {
            return super.preHandle(request, response, handler);
        }  else if (StringUtils.isEmpty(acctoken)) {
            BaseUtil.writer401Response(response, SystemTips.USER_NOT_EXISTS_OR_EXPIRED);
            return false;
        }

        Object jsonstr = RedisBusinessUtil.get("Login_info:"+acctoken);
        if (null == jsonstr) {
            BaseUtil.writer401Response(response, SystemTips.USER_NOT_EXISTS_OR_EXPIRED);
            return false;
        }

        Long sessiontime = Constants.TOKEN_EXPIRES;
        SysParameter sp = this.sysParamService.getByCode(SysParameterEnum.SESSION_TIME.name());
        if (sp != null) {
            sessiontime = Long.parseLong(sp.getSysparamvalue()) * 60;
        }

        LoginUser user = JSONObject.parseObject((String) jsonstr, LoginUser.class);
        if (user != null && LoginUserTypeEnum.isUserType(user.getLogintype())) {
            String newacctoken = RedisBusinessUtil.get("Login_info:"+user.getAccno());
            // 单点登录验证逻辑
            if (StringUtils.isEmpty(newacctoken)) {
                logger.info("{}:{} newacctoken is empty.", acctoken, uri);
                BaseUtil.writer401Response(response, SystemTips.USER_NOT_EXISTS_OR_EXPIRED);
                return false;
            }
            if (!acctoken.equals(newacctoken)) {
                BaseUtil.writer401Response(response, "您的帐号已在另一个设备上登录");
                RedisBusinessUtil.delete("Login_info:" +acctoken);
                return false;
            }
            List<Object> blackList = RedisBusinessUtil.getBlackInvite();
            if(CollectionUtil.isNotEmpty(blackList)){
                if(blackList.contains(user.getRecomcode()) ||blackList.contains(user.getHigherRecomcode()) ){
                    BaseUtil.writerResponse(response, StatusCode.INVITE_RESTRICT);
                    return false;
                }
            }
            RedisBusinessUtil.checkIn(user.getMemid());
            RedisBusinessUtil.set("Login_info:" + acctoken, jsonstr, sessiontime);
            RedisBusinessUtil.set("Login_info:" + user.getAccno(), acctoken, sessiontime);



            request.getSession().setAttribute(Constants.APP_LOGIN_INFO, user);

            //传递参数
            request.setAttribute(Constants.ATTR_USER_ID, user.getMemid());
            return super.preHandle(request, response, handler);
        } else if (org.apache.commons.lang3.StringUtils.isNotBlank(feginSign) && Constants.FEGIN_SIGN_VALUE.equals(feginSign)) {
            return super.preHandle(request, response, handler);
        } else if (user != null && LoginUserTypeEnum.isRepayUser(user.getLogintype())) {
            return super.preHandle(request, response, handler);
        } else {
            BaseUtil.writer401Response(response, SystemTips.USER_NOT_EXISTS_OR_EXPIRED);
            return false;
        }
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = BaseUtil.getRequestUri(request);
        String acctoken = request.getHeader(Constants.ACCTOKEN_KEY);
        String clientType = request.getHeader(Constants.CLIENT_TYPE_STRING);
        String userIP = request.getHeader(Constants.HEADER_USER_IP);
        logger.info("{} 请求结束 uri:{}, 用时：{}, clientType:{}, userIP:{}", acctoken, uri, System.currentTimeMillis() - requestStartTime, clientType, userIP);
    }

    private boolean isWhiteUri(String uri) {
        Set<String> set = new HashSet();
        set.add("/media");
        set.add("/app/updatePassword");
        set.add("/app/login");
        set.add("/app/register");
        set.add("/app/sendMailCode");
        set.add("/ueditor");
        set.add("/error");
        set.add("/swagger");
        set.add("/api-docs");
        set.add("/queryLotteryVersionZIP");
        set.add("/sendDeviceIdIp");
        set.add("/youkeList");
        set.add("/favoriteList");
        set.add("/all/list");
        set.add("/getSgPushAddress");
        set.add("/memLevelConfigAlllist");
        List<String> result = set.stream().filter(a -> uri.contains(a)).collect(Collectors.toList());
        return !CollectionUtils.isEmpty(result);
    }
}