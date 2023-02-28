package com.likes.common.service.finances;


import com.likes.common.model.LoginUser;
import com.likes.common.model.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.dto.finances.FinancesManagerProductOrderDto;
import com.likes.common.model.vo.finance.FinancesManagerProductOrderVo;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import com.likes.common.service.ISuperService;

import java.util.Map;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductOrderService extends ISuperService<FinancesManagerProductOrder> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<FinancesManagerProductOrderVo> findList(Map<String, Object> params);
    ResultInfo buyFinances(FinancesManagerProductOrderDto financesManagerProductOrderDto, LoginUser loginUser);
    ResultInfo getFinances(Integer id, LoginUser loginUser);
}

