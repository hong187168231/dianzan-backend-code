package com.likes.common.service.finances;


import com.likes.common.model.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductSettingService extends ISuperService<FinancesManagerProductSetting> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinancesManagerProductSetting> findListPage(Map<String, Object> params);
    List<FinancesManagerProductSetting> findList(Map<String, Object> params);
}

