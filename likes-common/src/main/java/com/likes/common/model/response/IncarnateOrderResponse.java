package com.likes.common.model.response;

import com.likes.common.model.dto.order.OrderAuditDO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class IncarnateOrderResponse {


    private String email;
    private String orderid;
    private String orderno;
    private String nickname;
    private Integer accounttype;
    private String accounttypename;
    private String accountno;
    private String accountname;
    private String bankname;
    private String banknamealias;
    private String bankaddress;
    private Long memBankId;
    private String orderstatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    private Date createTime;
    private String accno;
    private String moneyAddress;
    private String bankCardNo;
    private String bankCode;
    private String banName;
    private BigDecimal realamt;
    private Long paysetid;
    private BigDecimal sumamt;
    private String shouxuandxingzheng;
    private Integer isjihe;  //0 有 9 无
    private Long apycid;

    private Date paydate;

    private boolean showThirdButton;

    /**
     * 打码量
     */
    private Double damaliang;

    /**
     * 手续费
     */
    private Double xingzhengfei;
    //稽核
    private Double allhaixudamaliang;
    private Double alljiehefei;
    private List<OrderAuditDO> auditList = new ArrayList<OrderAuditDO>();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    private Date finishTime;
    private String updateUser;
    private String remark;
    private String memLevel;

    private String uniqueId;


}