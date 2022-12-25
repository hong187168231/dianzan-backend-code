package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.PayRechargeOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface PayRechargeOrderMapper extends Mapper<PayRechargeOrder> {

    @Select("select count(1) from  pay_recharge_order where  order_status = 0 and trade_Id =#{tradeId}")
    Integer countBusinessId(@Param("tradeId") String tradeId);
}
