package com.likes.common.mybatis.mapper.pay;

import com.likes.common.mybatis.entity.pay.PaymentType;

public interface PaymentTypeMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int insert(PaymentType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PaymentType record);
}