package com.likes.common.mybatis.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.likes.common.model.vo.finance.FinancesManagerProductOrderVo;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财订单明细表
 * 
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Mapper
public interface FinancesManagerProductOrderMapper extends SuperMapper<FinancesManagerProductOrder> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinancesManagerProductOrderVo> findList(Page<FinancesManagerProductOrderVo> page, @Param("p") Map<String, Object> params);
    Integer countOrder(@Param("p") Map<String, Object> params);
}
