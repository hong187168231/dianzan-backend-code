package com.likes.modules.admin.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankSwitchReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.modules.admin.user.service.IMemBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户绑定银行卡信息表 前端控制器
 * </p>
 *
 * @author puff
 * @since 2021-11-06
 */
@Api(tags = "会员银行卡")
@RestController
@Slf4j
@RequestMapping("/mem/bank")
public class MemBankController {

    @Autowired
    private IMemBankService iMemBankService;

    @ApiOperation(value = "分页查询",response = MemBankVO.class)
    @PostMapping(value = "/page")
    public ResultInfo page(MemBankPageReq req, PageBounds pageBounds) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(iMemBankService.queryList(req, pageBounds));
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
    public ResultInfo switchStatus(MemBankSwitchReq req) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(iMemBankService.switchStatus(req));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/createUser失败:{}", e.getMessage());
        }
        log.info("/createUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @ApiOperation(value = "修改会员银行卡")
    @PutMapping(value = "/edit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memBankId", value = "会员银行卡id", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "bankCardNo", value = "银行卡号", required = true, paramType = "query", dataType = "string")
    })
    public ResultInfo edit(@RequestParam("memBankId") Long memBankId, @RequestParam("bankCardNo") String bankCardNo) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(iMemBankService.edit(memBankId, bankCardNo));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/createUser失败:{}", e.getMessage());
        }
        log.info("/createUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


}