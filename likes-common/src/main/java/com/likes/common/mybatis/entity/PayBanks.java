package com.likes.common.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Table(name = "`pay_banks`")
public class PayBanks {
    /**
     * udun 订单id
     */
    @Id
    @Column(name = "`id`")
    private Long id;
    /**
     * 银行ID
     */
    @Column(name = "`bank_id`")
    private String bankId;

    /**
     * 银行名称
     */
    @Column(name = "`bank_name`")
    private BigDecimal bankName;

}