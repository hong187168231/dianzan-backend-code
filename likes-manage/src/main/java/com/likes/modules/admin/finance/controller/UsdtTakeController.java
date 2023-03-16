package com.likes.modules.admin.finance.controller;

import com.alibaba.excel.EasyExcel;
import com.likes.common.BaseController;
import com.likes.common.annotation.Syslog;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.request.IncarnateOrderReq;
import com.likes.common.model.response.EntryIncarnateOrderExcelResponse;
import com.likes.common.util.JsonUtil;
import com.likes.common.util.LogUtils;
import com.likes.common.util.redis.RedisLock;
import com.likes.modules.admin.finance.service.IncarnateService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 出账
 * 主播
 *
 * @author bjkj
 */
@Controller
@Api(tags = "usdt提现管理")
@RequestMapping(value = "/usdt")
public class UsdtTakeController extends BaseController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Resource
    private IncarnateService incarnateService;

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate redisTemplate;




    //-------------------------------------v2 用户提现--------------------------------------
    @ResponseBody
    @RequestMapping(name = "出帐订单管理", value = "/v2/orderList", method = RequestMethod.GET)
    public ResultInfo orderListV2(IncarnateOrderReq req, PageBounds page) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginAdmin = getLoginAdmin();
            response.setData(incarnateService.incarnateOrderListV2Usdt(req, page, loginAdmin));
            LogUtils.logUserModifyOperates(getClass().getName() + ".orderListV2", req, loginAdmin);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.error("{}/v2/orderList出帐订单管理出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("出帐订单管理失败");
            logger.error("{}/v2/orderList出帐订单管理出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        }
        logger.info("/v2/orderList耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


    @Syslog("出账订单处理,确认转账")
    @ResponseBody
    @RequestMapping(name = "出账订单处理,确认转账", value = "/v2/incarnateConfirm", method = RequestMethod.POST)
    public ResultInfo incarnateConfirmV2(IncarnateOrderReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        RLock lock = null;
        try {
            LoginUser loginAdmin = getLoginAdmin();
            lock = redissonClient.getReadWriteLock(RedisLock.FINANCE_MANAGE_WITHDRAWAL_CONFIRM + "_" + req.getOrderno()).writeLock();
            boolean bool = lock.tryLock(0, 60, TimeUnit.SECONDS);
            if (!bool) {
                throw new BusinessException("操作太频繁，请稍后再试！");
            }
            String keySuffix = RedisLock.FINANCE_APP_WITHDRAWAL_UDUN + req.getOrderno();
            if (redisTemplate.hasKey(keySuffix)) {
                new BusinessException(StatusCode.LIVE_ERROR_501.getCode(), "第三方回调正在处理，请稍后再试！");
            }
            response.setData(incarnateService.incarnateConfirmV2Usdt(req, loginAdmin));
            LogUtils.logUserModifyOperates(getClass().getName() + ".incarnateConfirmV2", req, loginAdmin);
        } catch (BusinessException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.error("{}/v2/incarnateConfirm出账订单处理,确认转账出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            response = ResultInfo.error("出账订单处理,确认转账失败");
            logger.error("{}/v2/incarnateConfirm出账订单处理,确认转账出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        logger.info("/v2/incarnateConfirm耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }



}