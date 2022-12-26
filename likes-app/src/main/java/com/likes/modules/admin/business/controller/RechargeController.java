package com.likes.modules.admin.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.BaseController;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.request.RechargeUsdtRequest;
import com.likes.common.model.request.TraRechargemealRequest;
import com.likes.common.util.LogUtils;
import com.likes.common.util.StringUtils;
import com.likes.common.util.redis.RedisLock;
import com.likes.modules.admin.business.service.RechargeService;
import com.likes.modules.admin.pay.dto.OnlinePayDTO;
import com.likes.modules.admin.business.service.OnlinePayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 充值 线下 / 线上
 */
@RestController
@Api(tags = "线下充值")
@RequestMapping(value = "/recharge")
public class RechargeController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RechargeService rechargeService;
    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private OnlinePayService iOnlinePayService;


    @AllowAccess
    @ApiOperation("获取收款信息")
    @RequestMapping(name = "获取收款信息", value = "/getCoinDeposit", method = RequestMethod.GET)
    public ResultInfo getBankList() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(rechargeService.getCoinDeposit(this.getLoginUserAPP()));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("失败:{}", e.getMessage());
        } catch (Exception e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("getBankList error,req:{}", e);
        }
        logger.info("/getBankList耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation("提交usdt充值")
    @RequestMapping(name = "提交usdt充值", value = "/v3/doPayUsdt", method = RequestMethod.POST)
    public ResultInfo doPayUsdt(@RequestBody RechargeUsdtRequest req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        RedisLock lock = new RedisLock(RedisLock.FINANCE_APP_USDT_APPLY_LOCK, 0, 10 * 1000);
        try {
            if (null == req.getAmount() || StringUtils.isBlank(req.getPayAddress()) || StringUtils.isBlank(req.getTransferAddress())) {
                return ResultInfo.paramsError();
            }
            LoginUser loginUserAPP = getLoginUserAPP();
            String keySuffix = RedisLock.FINANCE_APP_PAY_APPLY + loginUserAPP.getMemid();
            if (redisTemplate.hasKey(keySuffix)) {
                return ResultInfo.error("充值操作频繁，请稍后再试！");
            }
            if (!lock.lock()) {
                return ResultInfo.error("充值操作频繁，请稍后再试！");
            }
            redisTemplate.opsForValue().setIfAbsent(keySuffix, "1", 10, TimeUnit.SECONDS);
            response.setData(rechargeService.doPayUsdt(loginUserAPP, req));
            LogUtils.logUserModifyOperates(getClass().getName() + ".doPayV1", req, loginUserAPP);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("失败:{}", e.getMessage());
        } catch (Exception e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("doAgentPay失败,req:{}", JSONObject.toJSONString(req), e);
        } finally {
            lock.unlock();
        }
        logger.info("/v3/doAgentPay耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


    @RequestMapping(name = "代理充值下单", value = "/v3/doAgentPay", method = RequestMethod.POST)
    public ResultInfo doPayV1(TraRechargemealRequest req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        RedisLock lock = new RedisLock(RedisLock.FINANCE_APP_WITHDRAWAL_APPLY_LOCK, 0, 10 * 1000);
        try {
            if (null == req.getBankid() || StringUtils.isEmpty(req.getPayuser())) {
                return ResultInfo.paramsError();
            }
            LoginUser loginUserAPP = getLoginUserAPP();
            String keySuffix = RedisLock.FINANCE_APP_PAY_APPLY + loginUserAPP.getMemid();
            if (redisTemplate.hasKey(keySuffix)) {
                return ResultInfo.error("充值操作频繁，请稍后再试！");
            }
            if (!lock.lock()) {
                return ResultInfo.error("充值操作频繁，请稍后再试！");
            }
            redisTemplate.opsForValue().setIfAbsent(keySuffix, "1", 10, TimeUnit.SECONDS);
            response.setData(rechargeService.doPayV1(loginUserAPP, req));
            LogUtils.logUserModifyOperates(getClass().getName() + ".doPayV1", req, loginUserAPP);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("失败:{}", e.getMessage());
        } catch (Exception e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
            logger.error("doAgentPay失败,req:{}", JSONObject.toJSONString(req), e);
        } finally {
            lock.unlock();
        }
        logger.info("/v3/doAgentPay耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation("线上支付")
    @AllowAccess
    @RequestMapping(name = "线上支付", value = "/onlinePay", method = RequestMethod.POST)
    public ResultInfo onlinePay(@RequestBody OnlinePayDTO onlinePayDTO) {
        logger.error("获取收款地址前端傳入參數,params:{},", JSONObject.toJSONString(onlinePayDTO));
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(iOnlinePayService.doOnlinePay(onlinePayDTO,loginUserAPP));
        } catch (Exception e) {
            response = ResultInfo.error("获取收款地址失败");
            logger.error("获取收款地址,出错信息:{}", e);
        }
        logger.info("/getCollectUrl耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


}