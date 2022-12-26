package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.PayType;
import tk.mybatis.mapper.common.Mapper;

public interface PayTypeMapper extends Mapper<PayType> {

    int deleteByPrimaryKey(Integer id);


    int insert(PayType record);

    int updateByPrimaryKey(PayType record);
}