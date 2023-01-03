package com.likes.modules.admin.users.controller;


import com.likes.common.BaseController;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.common.ResultInfo;
import com.likes.modules.admin.users.service.AppMemBankService;
import com.likes.modules.admin.users.service.PayBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "添加银行卡", httpMethod = "POST")
    @PostMapping(value = "/add")
    public ResultInfo addBankCard(AddBankCardReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(appMemBankService.addBankCard(req, loginUserAPP));
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


    @ApiOperation(value = "修改银行卡", httpMethod = "POST")
    @PostMapping(value = "/edit")
    public ResultInfo editBankCard(AddBankCardReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            response.setData(appMemBankService.editBankCard(req, loginUserAPP));
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
            log.error("{}.myLevel 失败:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("获取我的等级出错");
            log.error("{}.myLevel 出错:{}", getClass().getName(), e.getMessage(), e);
        }
        log.info("/myLevel耗时{}毫秒", (System.currentTimeMillis() - start));
        return response;
    }

}