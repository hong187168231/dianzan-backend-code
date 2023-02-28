package com.likes.modules.admin.finance.controller;

import java.util.Map;

import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import com.likes.common.service.finances.IFinancesManagerProductOrderService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@RestController
@RequestMapping("/financesmanagerproductorder")
@Api(tags = "用户购买理财订单明细表")
public class FinancesManagerProductOrderController {
    @Autowired
    private IFinancesManagerProductOrderService financesManagerProductOrderService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startStartTime", value = "理财购买日期开始时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "startEndTime", value = "理财购买日期结束时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "endStartTime", value = "理财结算日期开始时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "endEndTime", value = "理财结算日期结束时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userAcct", value = "会员账号", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "会员ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "financesProductStatus", value = "提款状态0：未提款，1：已提款", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "financesProductId", value = "理财产品ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping
    public PageResult list(@RequestParam Map<String, Object> params) {
        PageBounds
            pageBounds = new PageBounds( MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        return financesManagerProductOrderService.findList(params,pageBounds);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public ResultInfo findUserById(@PathVariable Long id) {
        ResultInfo response = ResultInfo.ok();
        FinancesManagerProductOrder model = financesManagerProductOrderService.getById(id);
        return response.setData(model);
    }

    /**
     * 新增or更新
     */
//    @ApiOperation(value = "保存")
//    @PostMapping
//    public ResultInfo save(@RequestBody FinancesManagerProductOrder financesManagerProductOrder) {
//        financesManagerProductOrderService.saveOrUpdate(financesManagerProductOrder);
//        return ResultInfo.ok();
//    }

    /**
     * 删除
     */
//    @ApiOperation(value = "删除")
//    @DeleteMapping("/{id}")
//    public ResultInfo delete(@PathVariable Long id) {
//        financesManagerProductOrderService.removeById(id);
//        return ResultInfo.ok();
//    }
}
