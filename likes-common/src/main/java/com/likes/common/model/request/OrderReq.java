package com.likes.common.model.request;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderReq {
    //@NotNull
    private String copyno;
    private String orderno;

    private String paywechat;

    private String paytype;

    private BigDecimal vietRealAmount;

    /**
     * 是否成功: true 成功，false 失败
     */
    private Boolean beSucceed;
    /**
     * 原因
     */
    private String reason;



}
