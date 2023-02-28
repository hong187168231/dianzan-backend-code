package com.likes.modules.admin.finances.controller;

import com.likes.common.BaseController;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import com.likes.common.service.finances.IFinancesManagerProductOrderService;
import com.likes.common.service.finances.IFinancesManagerProductService;
import com.likes.common.model.dto.finances.FinancesManagerProductOrderDto;
import com.likes.common.util.redis.RedisBaseUtil;
import com.likes.common.util.redis.RedisLock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 理财前台
 *
 * @author yixiu
 */
@RestController
@RequestMapping(value = "/finances")
@Api(tags = "前台理财产品")
public class FinancesController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IFinancesManagerProductService financesManagerProductService;
    @Autowired
    private IFinancesManagerProductOrderService financesManagerProductOrderService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 列表
     */
    @ApiOperation(value = "分页理财产品查询列表")
    @ApiImplicitParams(
        {@ApiImplicitParam(name = "productNameCn", value = "产品中文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameEn", value = "产品英文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameVn", value = "产品越南文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")})
    @GetMapping("/product/page")
    public PageResult listProductPage(@RequestParam Map<String, Object> params) {
        PageBounds pageBounds =
            new PageBounds(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        return financesManagerProductService.findListPage(params, pageBounds);
    }

    @ApiOperation(value = "理财产品查询列表")
    @ApiImplicitParams(
        {@ApiImplicitParam(name = "productNameCn", value = "产品中文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameEn", value = "产品英文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameVn", value = "产品越南文名称", required = false, dataType = "String")})
    @GetMapping("/product/list")
    public ResultInfo listProduct(@RequestParam Map<String, Object> params) {
        ResultInfo response = ResultInfo.ok();
        return response.setData(financesManagerProductService.findList(params));
    }

    /**
     * 列表
     */
    @ApiOperation(value = "分页查询当前用户理财订单")
    @ApiImplicitParams({@ApiImplicitParam(name = "startStartTime", value = "理财购买日期开始时间", required = false,
        dataType = "String"),
        @ApiImplicitParam(name = "startEndTime", value = "理财购买日期结束时间", required = false, dataType = "String"),
        @ApiImplicitParam(name = "endStartTime", value = "理财结算日期开始时间", required = false, dataType = "String"),
        @ApiImplicitParam(name = "endEndTime", value = "理财结算日期结束时间", required = false, dataType = "String"),
        @ApiImplicitParam(name = "financesProductStatus", value = "提款状态0：未提款，1：已提款", required = false,
            dataType = "Integer"),
        @ApiImplicitParam(name = "financesProductId", value = "理财产品ID", required = false, dataType = "Long"),
        @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")})
    @GetMapping("/order/page")
    public PageResult listOrder(@RequestParam Map<String, Object> params) {
        LoginUser loginUserAPP = getLoginUserAPP();
        params.put("userId", loginUserAPP.getMemid());
        PageBounds pageBounds =
            new PageBounds(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        return financesManagerProductOrderService.findList(params, pageBounds);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询理财订单")
    @GetMapping("/order/{id}")
    public ResultInfo findUserById(@PathVariable Long id) {
        ResultInfo response = ResultInfo.ok();
        FinancesManagerProductOrder model = financesManagerProductOrderService.getById(id);
        return response.setData(model);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "购买理财")
    @PostMapping("/buyfinances")
    public ResultInfo buyFinances(@RequestBody FinancesManagerProductOrderDto financesManagerProductOrderDto) {
        String keySuffix = "";
        ResultInfo response = ResultInfo.ok();
        RedisLock lock = new RedisLock(RedisLock.FINANCE_APP_BUY_LOCK, 2, 120 * 1000);
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            // 控制频率
            keySuffix = RedisLock.FINANCE_APP_BUY_LOCK + loginUserAPP.getMemid();
            if (redisTemplate.hasKey(keySuffix)) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            boolean haveAuth = redisTemplate.opsForValue().setIfAbsent(keySuffix, "1", 300, TimeUnit.SECONDS);
            if (!haveAuth) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            if (!lock.lock()) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            return financesManagerProductOrderService.buyFinances(financesManagerProductOrderDto, loginUserAPP);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("失败:{}", e.getMessage());
        } catch (Exception e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
        } finally {
            RedisBaseUtil.delete(keySuffix);
            lock.unlock();
        }
        return response;
        
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "购买理财提现")
    @PostMapping("/getfinances")
    public ResultInfo getFinances(@RequestParam Long orderId) {

        String keySuffix = "";
        ResultInfo response = ResultInfo.ok();
        RedisLock lock = new RedisLock(RedisLock.FINANCE_APP_GET_LOCK, 2, 120 * 1000);
        try {
            LoginUser loginUserAPP = getLoginUserAPP();
            // 控制频率
            keySuffix = RedisLock.FINANCE_APP_GET_LOCK + loginUserAPP.getMemid();
            if (redisTemplate.hasKey(keySuffix)) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            boolean haveAuth = redisTemplate.opsForValue().setIfAbsent(keySuffix, "1", 300, TimeUnit.SECONDS);
            if (!haveAuth) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            if (!lock.lock()) {
                return ResultInfo.error(StatusCode.FINANCE_FAILED_1061.getCode(),"操作频繁，请稍后再试！");
            }
            return financesManagerProductOrderService.getFinances(orderId, loginUserAPP);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("失败:{}", e.getMessage());
        } catch (Exception e) {
            response.setResultInfo(StatusCode.OPERATION_FAILED.getCode(), e.getMessage());
        } finally {
            RedisBaseUtil.delete(keySuffix);
            lock.unlock();
        }
        return response;
    }

    //    @RequestMapping(name = "提交充值", value = "/submitRecharge", method = RequestMethod.POST)
    //    public ResultInfo submitRecharge(String coinName, BigDecimal amount, String moneyAddress) {
    //        long start = System.currentTimeMillis();
    //        ResultInfo response = ResultInfo.ok();
    //        try {
    //            LoginUser loginUserAPP = getLoginUserAPP();
    //            response.setData(memWalletService.submitRecharge(coinName, amount, moneyAddress, loginUserAPP));
    //        } catch (BusinessException e) {
    //            response.setResultInfo(e.getCode(), e.getMessage());
    //            logger.error("{}.moneyAddress 失败:{}", getClass().getName(), e.getMessage(), e);
    //        } catch (Exception e) {
    //            response = ResultInfo.error("获取钱包地址出错");
    //            logger.error("{}.moneyAddress 出错:{}", getClass().getName(), e.getMessage(), e);
    //        }
    //        logger.info("/moneyAddress耗时{}毫秒", (System.currentTimeMillis() - start));
    //        return response;
    //    }

}