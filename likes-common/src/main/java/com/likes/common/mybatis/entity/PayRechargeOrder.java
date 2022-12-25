package com.likes.common.mybatis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


@Data
@Table(name = "`pay_recharge_order`")
public class PayRechargeOrder {
    /**
     * udun 订单id
     */
    @Id
    @Column(name = "`recharge_id`")
    private Long rechargeId;
    /**
     * 会员标识
     */
    @Column(name = "`accno`")
    private String accno;

    /**
     * 金额
     */
    @Column(name = "`amount`")
    private BigDecimal amount;

    /**
     * 交易id
     */
    @Column(name = "`trade_Id`")
    private String tradeId;

    @Column(name = "`order_status`")
    private Integer orderStatus;

    /**
     * 1 成功 2 失败
     */
    @Column(name = "`trade_status`")
    private Integer tradeStatus;

    @Column(name = "`create_user`")
    private String createUser;

    @Column(name = "`update_user`")
    private String updateUser;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;


}
