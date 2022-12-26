package com.likes.common.mybatis.mapper;


import com.likes.common.mybatis.entity.PayMerchant;
import tk.mybatis.mapper.common.Mapper;

public interface PayMerchantMapper extends Mapper<PayMerchant> {

    int deleteByPrimaryKey(Integer id);

    int insert(PayMerchant merchantPaymentChannel);

    int updateByPrimaryKey(PayMerchant merchantPaymentChannel);

}