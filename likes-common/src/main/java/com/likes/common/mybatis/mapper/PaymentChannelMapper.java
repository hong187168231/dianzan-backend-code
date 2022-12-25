package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.PaymentChannel;

public interface PaymentChannelMapper {


    int deleteByPrimaryKey(Integer id);


    int insert(PaymentChannel record);

    int updateByPrimaryKey(PaymentChannel record);
}