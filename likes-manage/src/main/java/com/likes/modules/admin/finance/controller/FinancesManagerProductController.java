package com.likes.modules.admin.finance.controller;

import java.util.Map;

import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.service.finances.IFinancesManagerProductService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@RestController
@RequestMapping("/financesmanagerproduct")
@Api(tags = "后端理财产品设置")
public class FinancesManagerProductController {
    @Autowired
    private IFinancesManagerProductService financesManagerProductService;

    /**
     * 列表
     */
    @ApiOperation(value = "分页查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productNameCn", value = "产品中文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameEn", value = "产品英文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameVn", value = "产品越南文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageNo", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/page")
    public PageResult listPage(@RequestParam Map<String, Object> params) {
        PageBounds pageBounds = new PageBounds( MapUtils.getInteger(params, "pageNo"), MapUtils.getInteger(params, "pageSize"));
        params.remove("pageNo");
        params.remove("pageSize");
        return financesManagerProductService.findListPage(params,pageBounds);
    }
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productNameCn", value = "产品中文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameEn", value = "产品英文名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "productNameVn", value = "产品越南文名称", required = false, dataType = "String")
    })
    @GetMapping("/list")
    public ResultInfo list(@RequestParam Map<String, Object> params) {
        ResultInfo response = ResultInfo.ok();
        return response.setData(financesManagerProductService.findList(params));
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public ResultInfo findUserById(@PathVariable Long id) {
        ResultInfo response = ResultInfo.ok();
        FinancesManagerProduct model = financesManagerProductService.getById(id);
        return response.setData(model);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public ResultInfo save(@RequestBody FinancesManagerProduct financesManagerProduct) {
        financesManagerProductService.saveOrUpdate(financesManagerProduct);
        return ResultInfo.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/{id}")
    public ResultInfo delete(@PathVariable Long id) {
        financesManagerProductService.removeById(id);
        return ResultInfo.ok();
    }
}
