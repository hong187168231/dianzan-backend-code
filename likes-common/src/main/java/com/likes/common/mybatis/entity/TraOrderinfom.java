package com.likes.common.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class TraOrderinfom implements Serializable {

    private Long orderid;


    private Long mealid;


    private Long bankid;

    private Long memBankId;


    private Long roomid;


    private Long lotkindid;


    private Long sschistoryid;

    private Long oddsid;


    private Long chekindid;


    private Long tpaysetid;


    private Integer ordertype;

    private String orderno;


    private String accno;


    private String paycode;


    private Date orderdate;

    private Date expiredate;

    private String paytype;

    private BigDecimal oldamt;

    private BigDecimal sumamt;

    private BigDecimal realamt;

    private Integer isinvoice;

    private String orderstatus;

    private String accountstatus;

    private String cancelreason;

    private String payimg;

    private String paywechat;

    private Date paydate;

    private String payuser;

    private String payAddress;

    private String transferAddress;

    private String paynote;

    private String ordernote;

    private Boolean isDelete;


    private String createUser;


    private Date createTime;

    private String updateUser;


    private Date updateTime;


    private String source;


    private Long cleanid;


    private Long buyVip;

    private  Integer takeType;

    private static final long serialVersionUID = 1L;


}