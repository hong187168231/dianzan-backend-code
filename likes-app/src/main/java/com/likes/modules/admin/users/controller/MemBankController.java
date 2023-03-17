package com.likes.modules.admin.users.controller;


import com.likes.common.BaseController;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.util.redis.RedisLock;
import com.likes.modules.admin.users.service.AppMemBankService;
import com.likes.common.service.pay.PayBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户银行卡 前端控制器
 * </p>
 *
 * @author puff
 * @since 2021-11-17
 */
@Api(tags = "银行卡接口")
@RestController
@Slf4j
@RequestMapping("/member/bank")
public class MemBankController extends BaseController {

    @Autowired
    private AppMemBankService appMemBankService;

    @Autowired
    private PayBankService payBankService;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "添加银行卡", httpMethod = "POST")
    @PostMapping(value = "/add")
    public ResultInfo addBankCard(AddBankCardReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        RedisLock lock = new RedisLock(RedisLock.FINANCE_APP_SUBMITBANK_APPLY_LOCK, 2, 10 * 2000);
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            // 控制频率
            String keySuffix = RedisLock.FINANCE_APP_SUBMITBANK_APPLY_LOCK + loginUserAPP.getMemid();
            if (redisTemplate.hasKey(keySuffix)) {
                return ResultInfo.error("提现操作频繁，请稍后再试！");
            }
            boolean haveAuth = redisTemplate.opsForValue().setIfAbsent(keySuffix, "1", 2, TimeUnit.SECONDS);
            if (!haveAuth) {
                return ResultInfo.error("提现操作频繁，请稍后再试！");
            }
            if (!lock.lock()) {
                return ResultInfo.error("提现操作频繁，请稍后再试！");
            }
            response.setData(appMemBankService.addBankCard(req, loginUserAPP));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.error("{}.myLevel 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取我的等级出错");
            log.error("{}.myLevel 出错:{}", getClass().getName(), e.getMessage(), e);
        }finally {
            lock.unlock();
        }
        log.info("/myLevel耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


//    @ApiOperation(value = "修改银行卡", httpMethod = "POST")
//    @PostMapping(value = "/edit")
//    public ResultInfo editBankCard(AddBankCardReq req) {
//        long start = System.currentTimeMillis();
//        ResultInfo response = ResultInfo.ok();
//        try {
//            LoginUser loginUserAPP = getLoginUserAPP();
//            response.setData(appMemBankService.editBankCard(req, loginUserAPP));
//        } catch (BusinessException e) {
//            response.setResultInfo(e.getCode(), e.getMessage());
//            log.error("{}.myLevel 失败:{}", getClass().getName(), e.getMessage(), e);
//        } catch (Exception e) {
//            response = ResultInfo.error("获取我的等级出错");
//            log.error("{}.myLevel 出错:{}", getClass().getName(), e.getMessage(), e);
//        }
//        log.info("/myLevel耗时{}毫秒", (System.currentTimeMillis() - start));
//        return response;
//    }


    @ApiOperation(value = "查询个人银行卡列表", httpMethod = "GET")
    @GetMapping(value = "/memBankList")
    public ResultInfo memBankList() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(appMemBankService.findPage(loginUserAPP));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.error("{}.myLevel 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取我的等级出错");
            log.error("{}.myLevel 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        log.info("/myLevel耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;

    }

    @ApiOperation(value = "会员可绑定银行列表")
    @GetMapping("/payBankList")
    @AllowAccess
    public ResultInfo payBankList() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(payBankService.bankList());
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.error("{}.payBankList 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取会员可绑定银行列表出错");
            log.error("{}.payBankList 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        log.info("/payBankList耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation(value = "查询会员是否绑定银行卡")
    @GetMapping("/getBindStatus")
    @AllowAccess
    public ResultInfo getBindStatus() {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(appMemBankService.getBindStatus(loginUserAPP));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.error("{}.getBindStatus 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取会员是否绑定银行卡出错");
            log.error("{}.getBindStatus 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        log.info("/getBindStatus{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }


}