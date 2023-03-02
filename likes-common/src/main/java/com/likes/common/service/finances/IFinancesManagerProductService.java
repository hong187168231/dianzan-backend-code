package com.likes.common.service.finances;

import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.mybatis.entity.FinancesManagerProduct;

import java.util.List;
import java.util.Map;

/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductService {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult findListPage(Map<String, Object> params, PageBounds pageBounds);

    List<FinancesManagerProduct> findList(Map<String, Object> params);

    void saveOrUpdate(FinancesManagerProduct financesManagerProduct);

    FinancesManagerProduct getById(Long id);

    ResultInfo removeById(Long id);

}

