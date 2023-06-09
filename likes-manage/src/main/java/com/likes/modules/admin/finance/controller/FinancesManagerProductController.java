package com.likes.modules.admin.finance.controller;

import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.BaseController;
import com.likes.common.model.LoginUser;
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
public class FinancesManagerProductController  extends BaseController {
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
    public ResultInfo listPage(@RequestParam Map<String, Object> params) {
        if (ObjectUtil.isEmpty(params)) {
            return ResultInfo.fail("请求参数不能为空");
        }
        if (ObjectUtil.isEmpty(params.get("pageNo"))) {
            return ResultInfo.fail("分页起始位置不能为空");
        }
        if (ObjectUtil.isEmpty(params.get("pageSize"))) {
            return ResultInfo.fail("分页结束位置不能为空");
        }
        PageBounds pageBounds = new PageBounds( MapUtils.getInteger(params, "pageNo"), MapUtils.getInteger(params, "pageSize"));
        params.remove("pageNo");
        params.remove("pageSize");
        return ResultInfo.ok(financesManagerProductService.findListPage(params,pageBounds));
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
        if (ObjectUtil.isEmpty(id)) {
            return ResultInfo.fail("ID不能为空");
        }
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
        if (ObjectUtil.isEmpty(financesManagerProduct)) {
            return ResultInfo.fail("请求参数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getIncomeRate())) {
            return ResultInfo.fail("收益利率%不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getValidDate())) {
            return ResultInfo.fail("有效天数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getProductNameCn())) {
            return ResultInfo.fail("产品中文名称不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getProductNameEn())) {
            return ResultInfo.fail("产品英文名称不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getProductNameVn())) {
            return ResultInfo.fail("产品越南文名称不能为空");
        }
        if (ObjectUtil.isNotNull(financesManagerProduct.getRemark())) {
            if(financesManagerProduct.getRemark().length()>200){
                return ResultInfo.fail("备注长度不能超过100");
            }
        }
        LoginUser loginUser = getLoginAdmin();
        financesManagerProductService.saveOrUpdate(financesManagerProduct,loginUser);
        return ResultInfo.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public ResultInfo delete(@RequestBody FinancesManagerProduct financesManagerProduct) {
        if (ObjectUtil.isEmpty(financesManagerProduct)) {
            return ResultInfo.fail("请求参数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProduct.getId())) {
            return ResultInfo.fail("ID不能为空");
        }
        return financesManagerProductService.removeById(Long.valueOf(financesManagerProduct.getId()));
    }
}
