package com.likes.common.mybatis.mapper;


import com.likes.common.mybatis.entity.PayMerchant;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PayMerchantMapper extends Mapper<PayMerchant> {

    int deleteByPrimaryKey(Integer id);

    int insert(PayMerchant merchantPaymentChannel);

    int updateByPrimaryKey(PayMerchant merchantPaymentChannel);

}