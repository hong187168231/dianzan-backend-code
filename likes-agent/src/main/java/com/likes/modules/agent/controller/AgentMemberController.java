package com.likes.modules.agent.controller;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.BaseController;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.annotation.Syslog;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.dto.AgentData;
import com.likes.common.model.dto.AgentMemberDTO;
import com.likes.common.model.dto.member.FundsResponse;
import com.likes.common.model.req.JackPotReq;
import com.likes.common.model.request.AgentMemberOrderReq;
import com.likes.common.model.request.AgentOrderReq;
import com.likes.common.model.request.FundsRequest;
import com.likes.common.model.request.TeamRequest;
import com.likes.common.model.response.TeamResponse;
import com.likes.common.mybatis.entity.FinanceBalanceAdjustment;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemRelationshipService;
import com.likes.common.util.LogUtils;
import com.likes.common.util.redis.RedisLock;
import com.likes.modules.agent.service.AgentMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


/**
 * @author abu
 * @version 1.0
 * @Description 运营登录
 * @revise
 * @time 2018年6月8日 下午3:25:23
 */
@Api(tags = "代理接口")
@RestController
@RequestMapping(value = "/agent/member")
public class AgentMemberController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AgentMemberService agentMemberService;

    @Resource
    private MemBaseinfoService memBaseinfoService;

    @Resource
    private RedissonClient redissonClient;



    @ApiOperation("下级列表")
    @AllowAccess
    @RequestMapping(name = "下级列表", value = "/subList", method = RequestMethod.POST)
    public ResultInfo<AgentMemberDTO> login(AgentMemberOrderReq req, PageBounds page, HttpServletRequest request) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(agentMemberService.subList(req, page));
        } catch (BusinessException e) {
            logger.error("{}.login 失败:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAccno()), e);
            response.setResultInfo(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("{}.login 出错:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAccno()), e);
            //return ResultInfo.error("登录失败,请稍后重试 ");
            response.setResultInfo("100000001", null);
        }
        logger.info("/app login耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation("数据报表")
    @AllowAccess
    @RequestMapping(name = "数据报表", value = "/dataList", method = RequestMethod.POST)
    public ResultInfo<AgentData> dataList(AgentOrderReq req, PageBounds page, HttpServletRequest request) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(agentMemberService.dataList(req, page));
        } catch (BusinessException e) {
            logger.error("{}.login 失败:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAccno()), e);
            response.setResultInfo(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("{}.login 出错:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAccno()), e);
            //return ResultInfo.error("登录失败,请稍后重试 ");
            response.setResultInfo("100000001", null);
        }
        logger.info("/app login耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation("资金流水")
    @AllowAccess
    @RequestMapping(name = "资金流水", value = "/fundsList", method = RequestMethod.POST)
    public ResultInfo<FundsResponse> fundsList(FundsRequest req, PageBounds page) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(agentMemberService.fundsList(req, page));
        } catch (BusinessException e) {
            logger.error("{}.login 失败:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getUniqueId()), e);
            response.setResultInfo(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("{}.login 出错:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getUniqueId()), e);
            //return ResultInfo.error("登录失败,请稍后重试 ");
            response.setResultInfo("100000001", null);
        }
        logger.info("/app login耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation("团队报表")
    @AllowAccess
    @RequestMapping(name = "团队报表", value = "/teamList", method = RequestMethod.POST)
    public ResultInfo<TeamResponse> teamList(TeamRequest req, PageBounds page, HttpServletRequest request) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(agentMemberService.teamList(req, page));
        } catch (BusinessException e) {
            logger.error("{}.login 失败:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAcclogin()), e);
            response.setResultInfo(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("{}.login 出错:{},params:{}", this.getClass().getName(), e.getMessage(), JSONObject.toJSON(req.getAcclogin()), e);
            //return ResultInfo.error("登录失败,请稍后重试 ");
            response.setResultInfo("100000001", null);
        }
        logger.info("/app login耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation("会员关系树")
    @ResponseBody
    @AllowAccess
    @RequestMapping(name = "会员关系树", value = "agentTree", method = RequestMethod.GET)
    public ResultInfo agentTree(String accno) {
        if (StringUtils.isBlank(accno)) {
            throw new BusinessException("参数为空");
        }
        return ResultInfo.ok(agentMemberService.agentTree(accno));
    }

    @ResponseBody
    @RequestMapping(name = "我的-邀请码", value = "/getRecomcode", method = RequestMethod.GET)
    public ResultInfo getRecomcode() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(agentMemberService.getRecomcode(loginUserAPP));
        } catch (BusinessException e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("{}.getRecomcode 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取邀请码出错");
            logger.error("{}.getRecomcode 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        logger.info("/getRecomcode耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation("增加彩金")
    @PostMapping("/adJackpot")
    public ResultInfo adJackpot(JackPotReq req) {
        RLock lock = null;
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            lock = redissonClient.getReadWriteLock(RedisLock.FINANCE_MANAGE_BALANCE_ADJACKPOT_ + req.getMemberAccno()).writeLock();
            boolean bool = lock.tryLock(0, 60, TimeUnit.SECONDS);
            if (!bool) {
                throw new BusinessException("操作太频繁，请稍后再试！");
            }
            req.setCreateUser(loginUserAPP.getAccno());
            req.setUpdateUser(loginUserAPP.getAccno());
            req.setAgentAccno(loginUserAPP.getAccno());
            req.setType(70);
            agentMemberService.adJackpot(req);
            return ResultInfo.ok();
        } catch (BusinessException e) {
            logger.error("{}/adJackpot,出错信息:{}", getClass().getName(), e.getMessage(), e);
            return ResultInfo.error(e.getMessage());
        } catch (Exception e) {
            logger.error("{}/adJackpot,出错信息:{}", getClass().getName(), e.getMessage(), e);
            return ResultInfo.error();
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }

    @ResponseBody
    @RequestMapping(name = "代理客服链接", value = "/setAgentSer", method = RequestMethod.POST)
    public ResultInfo setAgentSer(String serUrl) {
        logger.error("代理客服链接 传入参数:{}", serUrl);
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(agentMemberService.updateAgentSerurl(loginUserAPP.getAcclogin(),serUrl));
        } catch (BusinessException e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("{}.setAgentSer 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("代理客服链接出错");
            logger.error("{}.setAgentSer 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        logger.info("/setAgentSer耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ResponseBody
    @RequestMapping(name = "查询代理客服链接", value = "/queryAgentSer", method = RequestMethod.GET)
    public ResultInfo queryAgentSer() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(agentMemberService.queryAgentSerurl(loginUserAPP.getAcclogin()));
        } catch (BusinessException e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("{}.queryAgentSer 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("查询代理客服链接出错");
            logger.error("{}.queryAgentSer 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        logger.info("/queryAgentSer耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

}