package com.likes.common.service.finances.impl;

import com.likes.common.model.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.mybatis.mapper.FinancesManagerProductSettingMapper;
import com.likes.common.service.SuperServiceImpl;
import com.likes.common.service.finances.IFinancesManagerProductSettingService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;


/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@Service
public class FinancesManagerProductSettingServiceImpl extends SuperServiceImpl<FinancesManagerProductSettingMapper, FinancesManagerProductSetting> implements IFinancesManagerProductSettingService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinancesManagerProductSetting> findListPage(Map<String, Object> params){
        Page<FinancesManagerProductSetting> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinancesManagerProductSetting> list  =  baseMapper.findList(page, params);
        return PageResult.<FinancesManagerProductSetting>builder().data(list).code(0).count(page.getTotal()).build();
    }
    @Override
    public List<FinancesManagerProductSetting> findList(Map<String, Object> params){
        return baseMapper.findList(params);
    }
}
