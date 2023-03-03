package com.likes.common.service.finances.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.mybatis.mapper.FinancesManagerProductMapper;
import com.likes.common.service.finances.IFinancesManagerProductService;
import com.likes.common.service.finances.IFinancesManagerProductSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@Service
public class FinancesManagerProductServiceImpl implements IFinancesManagerProductService {

    @Autowired
    private FinancesManagerProductMapper financesManagerProductMapper;

    @Autowired
    private IFinancesManagerProductSettingService iFinancesManagerProductSettingService;

    @Override
    public PageResult findListPage(Map<String, Object> params, PageBounds pageBounds) {
        List<FinancesManagerProduct> list = financesManagerProductMapper.findList(params, pageBounds.toRowBounds());
        return PageResult.getPageResult(pageBounds, list);
    }

    /**
     * 列表
     *
     * @param params
     * @return
     */

    @Override
    public List<FinancesManagerProduct> findList(Map<String, Object> params) {
        return financesManagerProductMapper.findList(params);
    }

    @Override
    public void saveOrUpdate(FinancesManagerProduct financesManagerProduct, LoginUser loginUser) {
        if (ObjectUtil.isNotNull(financesManagerProduct.getId())) {
            financesManagerProduct.setUpdateBy(loginUser.getBdusername());
            financesManagerProductMapper.updateByPrimaryKeySelective(financesManagerProduct);
        } else {
            financesManagerProduct.setCreateBy(loginUser.getBdusername());
            financesManagerProductMapper.insertSelective(financesManagerProduct);
        }
    }

    @Override
    public FinancesManagerProduct getById(Long id) {
        FinancesManagerProduct product = new FinancesManagerProduct();
        product.setId(id.intValue());
        return financesManagerProductMapper.selectOne(product);
    }

    @Override
    public ResultInfo removeById(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("financesProductId",id);
        List<FinancesManagerProductSetting> list = iFinancesManagerProductSettingService.findList(params);
        if(null!=list && list.size()>0){
            return ResultInfo.fail("该产品用户购买理财设置，禁止删除");
        }
        return ResultInfo.ok(financesManagerProductMapper.deleteByPrimaryKey(id.intValue()) > 0);
    }
}
