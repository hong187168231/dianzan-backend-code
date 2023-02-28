package com.likes.common.service.finances.impl;

import com.likes.common.model.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.mybatis.mapper.FinancesManagerProductMapper;
import com.likes.common.service.SuperServiceImpl;
import com.likes.common.service.finances.IFinancesManagerProductService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;


/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@Service
public class FinancesManagerProductServiceImpl extends SuperServiceImpl<FinancesManagerProductMapper, FinancesManagerProduct> implements IFinancesManagerProductService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinancesManagerProduct> findListPage(Map<String, Object> params){
        Page<FinancesManagerProduct> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinancesManagerProduct> list  =  baseMapper.findList(page, params);
        return PageResult.<FinancesManagerProduct>builder().data(list).code(0).count(page.getTotal()).build();
    }
    @Override
    public List<FinancesManagerProduct> findList(Map<String, Object> params){
        return baseMapper.findList(params);
    }
}
