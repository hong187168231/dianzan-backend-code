package com.likes.modules.admin.coin.controller;


import com.github.pagehelper.PageInfo;
import com.likes.common.BaseController;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.dto.coin.CoinDepositDTO;
import com.likes.common.mybatis.entity.CoinDeposit;
import com.likes.modules.admin.coin.service.CoinDepositService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@Api(tags = "usdt收款管理")
@Slf4j
public class CoinDepositController extends BaseController {
    @Autowired
    private CoinDepositService coinDepositService;


    @ApiOperation("新增收款钱包")
    @PostMapping("/saveCoinDeposit")
    public ResultInfo saveCoinDeposit( @Validated CoinDepositDTO coinDto) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            CoinDeposit coinDeposit = new CoinDeposit();
            BeanUtils.copyProperties(coinDto, coinDeposit);
            Boolean data = coinDepositService.saveCoinDeposit(coinDeposit, loginUser);
            response.setData(data);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/saveCoinDeposit:{}", e.getMessage());
        }
        log.info("/saveCoinDeposit{}毫秒：", (System.currentTimeMillis() - start));
        return response;

    }


    @ApiOperation("修改收款钱包")
    @PostMapping("/modifyCoinDeposit")
    public ResultInfo modifyCoinDeposit( @Validated CoinDepositDTO coinDto) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            CoinDeposit coinDeposit = new CoinDeposit();
            BeanUtils.copyProperties(coinDto, coinDeposit);
            Boolean data = coinDepositService.modifyCoinDeposit(coinDeposit, loginUser);
            response.setData(data);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/modifyCoinDeposit:{}", e.getMessage());
        }
        log.info("/modifyCoinDeposit{}毫秒：", (System.currentTimeMillis() - start));
        return response;

    }


    @ApiOperation("删除钱包")
    @PostMapping("/delCoinDeposit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id主键", required = true),
    })
    public ResultInfo delCoinDeposit(@RequestParam(value = "id") Integer id) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            Boolean data = coinDepositService.delCoinDeposit(id, loginUser);
            response.setData(data);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/delCoinDeposit:{}", e.getMessage());
        }
        log.info("/delCoinDeposit{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation("开启关闭钱包")
    @PostMapping("/editCoinStatus")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id主键", required = true),
            @ApiImplicitParam(name = "status", value = "0关闭 1开启", required = true)
    })
    public ResultInfo editCoinStatus(@RequestParam(value = "id") Integer id,@RequestParam(value = "status") Integer status) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            Boolean data = coinDepositService.editCoinStatus(id, status, loginUser);
            response.setData(data);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/delCoinDeposit:{}", e.getMessage());
        }
        log.info("/delCoinDeposit{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation(value = "查询所有",response = CoinDeposit.class)
    @GetMapping("/coinDepositList")
    public ResultInfo<PageInfo<CoinDeposit>> coinDepositList(PageBounds page) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(coinDepositService.coinDepositList(page));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            log.info("/delCoinDeposit:{}", e.getMessage());
        }
        log.info("/delCoinDeposit{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


}