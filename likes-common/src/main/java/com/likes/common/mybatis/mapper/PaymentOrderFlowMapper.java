package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.PaymentOrderFlow;
import org.apache.ibatis.annotations.Param;

public interface PaymentOrderFlowMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PaymentOrderFlow record);

    int updateByPrimaryKey(PaymentOrderFlow record);

    PaymentOrderFlow getPaymentOrderFlow(@Param("merchatAcct") String merchatAcct, @Param("payChanCode") String payChanCode, @Param("merOrderNo") String merOrderNo);

}