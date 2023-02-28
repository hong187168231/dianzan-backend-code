package com.likes.common.mybatis.mapper;

import com.github.pagehelper.Page;
import com.likes.common.model.vo.finance.FinancesManagerProductOrderVo;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.Map;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface FinancesManagerProductOrderMapper extends BaseMapper<FinancesManagerProductOrder> {
    /**
     * 分页查询用户列表
     *
     * @param params
     * @return
     */
    Page<FinancesManagerProductOrderVo> findList(@Param("p") Map<String, Object> params, RowBounds rowBounds);

    Integer countOrder(@Param("p") Map<String, Object> params);
}
