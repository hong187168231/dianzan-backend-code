package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.PaymentType;

public interface PaymentTypeMapper {


    int deleteByPrimaryKey(Integer id);


    int insert(PaymentType record);

    int updateByPrimaryKey(PaymentType record);
}