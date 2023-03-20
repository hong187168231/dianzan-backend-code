package com.likes.modules.admin.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.bank.*;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.service.pay.PayBankService;
import com.likes.modules.admin.user.service.IMemBankService;
import com.likes.modules.admin.user.service.IMemWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "会员钱包")
@RestController
@Slf4j
@RequestMapping("/mem/wallet")
public class MemWalletController {

    @Autowired
    private IMemWalletService memWalletService;



    @ApiOperation(value = "分页查询",response = MemBankVO.class)
    @GetMapping(value = "/page")
    public ResultInfo page(MemWalletPageReq req, PageBounds pageBounds) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(memWalletService.queryList(req, pageBounds));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.error("{}.userList普通用户,主播管理,系统用户获取出错,params:{},出错信息:{}", getClass().getName(), JSONObject.toJSONString(req), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("普通用户,主播管理,系统用户获取失败");
            log.error("{}.userList普通用户,主播管理,系统用户获取出错,params:{},出错信息:{}", getClass().getName(), JSONObject.toJSONString(req), e.getMessage(), e);
        }
        log.info("/userlist耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation(value = "启用、禁用")
    @PostMapping(value = "/switchStatus")
    public ResultInfo switchStatus(MemWalletSwitchReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(memWalletService.switchStatus(req));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/createUser失败:{}", e.getMessage());
        }
        log.info("/createUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation(value = "修改会员钱包")
    @PostMapping(value = "/edit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "walletId", value = "会员钱包id", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "moneyAddress", value = "钱包地址", required = true, paramType = "query", dataType = "string"),
    })
    public ResultInfo edit(@RequestParam("walletId") Long walletId,
                           @RequestParam("moneyAddress") String moneyAddress) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(memWalletService.edit(walletId, moneyAddress));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/createUser失败:{}", e.getMessage());
        }
        log.info("/createUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


}