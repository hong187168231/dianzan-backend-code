package com.likes.common.service.finances.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.mybatis.mapper.FinancesManagerProductMapper;
import com.likes.common.service.finances.IFinancesManagerProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveOrUpdate(FinancesManagerProduct financesManagerProduct) {
        if (ObjectUtil.isNotNull(financesManagerProduct.getId())) {
            financesManagerProductMapper.updateByPrimaryKeySelective(financesManagerProduct);
        } else {
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
    public boolean removeById(Long id) {
        return financesManagerProductMapper.deleteByPrimaryKey(id.intValue()) > 0;
    }
}
