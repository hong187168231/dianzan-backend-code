package com.likes.common.service.finances.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.mybatis.mapper.FinancesManagerProductSettingMapper;
import com.likes.common.service.finances.IFinancesManagerProductSettingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@Service
public class FinancesManagerProductSettingServiceImpl implements IFinancesManagerProductSettingService {

    @Autowired
    private FinancesManagerProductSettingMapper financesManagerProductSettingMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult findListPage(Map<String, Object> params, PageBounds pageBounds) {
        Page<FinancesManagerProductSetting> list =
            financesManagerProductSettingMapper.findList(params, pageBounds.toRowBounds());
        return PageResult.getPageResult(pageBounds, list);
    }

    @Override
    public List<FinancesManagerProductSetting> findList(Map<String, Object> params) {
        return financesManagerProductSettingMapper.findList(params);
    }

    @Override
    public void saveOrUpdate(FinancesManagerProductSetting financesManagerProductSetting) {
        if (ObjectUtil.isNotNull(financesManagerProductSetting.getId())) {
            financesManagerProductSettingMapper.updateByPrimaryKeySelective(financesManagerProductSetting);
        } else {
            financesManagerProductSettingMapper.insertSelective(financesManagerProductSetting);
        }
    }

    @Override
    public FinancesManagerProductSetting getById(Long id) {
        return financesManagerProductSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean removeById(Long id) {
        return financesManagerProductSettingMapper.deleteByPrimaryKey(id) > 0;
    }
}
