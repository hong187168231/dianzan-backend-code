package com.likes.common.service.finances;


import com.likes.common.model.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.service.ISuperService;

import java.util.List;
import java.util.Map;

/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductService extends ISuperService<FinancesManagerProduct> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinancesManagerProduct> findListPage(Map<String, Object> params);
    List<FinancesManagerProduct> findList(Map<String, Object> params);
}

