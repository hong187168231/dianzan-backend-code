package com.likes.modules.admin.finance.controller;

import java.util.Map;

import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.service.finances.IFinancesManagerProductSettingService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@RestController
@RequestMapping("/financesmanagerproductsetting")
@Api(tags = "后端用户购买理财设置")
public class FinancesManagerProductSettingController {
    @Autowired
    private IFinancesManagerProductSettingService financesManagerProductSettingService;

    /**
     * 列表
     */
    @ApiOperation(value = "分页查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financesProductId", value = "理财产品ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "levelConfigId", value = "vip等级ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "levelConfigLevel", value = "vip等级", required = false, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/page")
    public PageResult listPage(@RequestParam Map<String, Object> params) {
        PageBounds
            pageBounds = new PageBounds( MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        return financesManagerProductSettingService.findListPage(params,pageBounds);
    }

    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financesProductId", value = "理财产品ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "levelConfigId", value = "vip等级ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "levelConfigLevel", value = "vip等级", required = false, dataType = "String")
    })
    @GetMapping("/list")
    public ResultInfo list(@RequestParam Map<String, Object> params) {
        ResultInfo response = ResultInfo.ok();
        return response.setData(financesManagerProductSettingService.findList(params));
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public ResultInfo findUserById(@PathVariable Long id) {
        ResultInfo response = ResultInfo.ok();
        FinancesManagerProductSetting model = financesManagerProductSettingService.getById(id);
        return response.setData(model);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public ResultInfo save(@RequestBody FinancesManagerProductSetting financesManagerProductSetting) {
        financesManagerProductSettingService.saveOrUpdate(financesManagerProductSetting);
        return ResultInfo.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResultInfo delete(@PathVariable Long id) {
        financesManagerProductSettingService.removeById(id);
        return ResultInfo.ok();
    }
}
