package com.likes.common.service.finances;

import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.dto.finances.FinancesManagerProductOrderDto;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;

import java.util.Map;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductOrderService {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult findList(Map<String, Object> params, PageBounds pageBounds);

    ResultInfo buyFinances(FinancesManagerProductOrderDto financesManagerProductOrderDto, LoginUser loginUser);

    ResultInfo getFinances(Long id, LoginUser loginUser);

    void saveOrUpdate(FinancesManagerProductOrder financesManagerProductOrder);

    FinancesManagerProductOrder getById(Long id);

}

