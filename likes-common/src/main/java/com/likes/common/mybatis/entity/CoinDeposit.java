package com.likes.common.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "`coin_deposit`")
@Data
public class CoinDeposit {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`coin_type`")
    private String coinType;

    @Column(name = "`coin_name`")
    private BigDecimal coinName;

    @Column(name = "`address`")
    private BigDecimal address;

    @Column(name = "`image_url`")
    private BigDecimal imageUrl;

    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`del_status`")
    private Integer delStatus;

    @Column(name = "`create_user`")
    private String createUser;

    @Column(name = "`update_user`")
    private String updateUser;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;


}