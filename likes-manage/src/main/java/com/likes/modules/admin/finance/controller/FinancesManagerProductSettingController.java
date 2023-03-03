package com.likes.modules.admin.finance.controller;

import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.BaseController;
import com.likes.common.model.LoginUser;
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
public class FinancesManagerProductSettingController  extends BaseController {
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
        PageBounds
            pageBounds = new PageBounds( MapUtils.getInteger(params, "pageNo"), MapUtils.getInteger(params, "pageSize"));
        params.remove("pageNo");
        params.remove("pageSize");
        return ResultInfo.ok(financesManagerProductSettingService.findListPage(params,pageBounds));
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
        if (ObjectUtil.isEmpty(id)) {
            return ResultInfo.fail("ID不能为空");
        }
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
        if (ObjectUtil.isEmpty(financesManagerProductSetting)) {
            return ResultInfo.fail("请求参数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getMinAmout())) {
            return ResultInfo.fail("最低存款金额不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getLevelConfigId())) {
            return ResultInfo.fail("vip等级ID不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getLevelConfigLevel())) {
            return ResultInfo.fail("vip等级不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getLevelConfigReq())) {
            return ResultInfo.fail("vip等级序号不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getBuyNumber())) {
            return ResultInfo.fail("限制用户购买次数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getFinancesProductId())) {
            return ResultInfo.fail("理财产品ID不能为空");
        }
        LoginUser loginUser = getLoginAdmin();
        financesManagerProductSettingService.saveOrUpdate(financesManagerProductSetting,loginUser);
        return ResultInfo.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public ResultInfo delete(@RequestBody FinancesManagerProductSetting financesManagerProductSetting) {
        if (ObjectUtil.isEmpty(financesManagerProductSetting)) {
            return ResultInfo.fail("请求参数不能为空");
        }
        if (ObjectUtil.isEmpty(financesManagerProductSetting.getId())) {
            return ResultInfo.fail("ID不能为空");
        }
        financesManagerProductSettingService.removeById(Long.valueOf(financesManagerProductSetting.getId()));
        return ResultInfo.ok();
    }
}
