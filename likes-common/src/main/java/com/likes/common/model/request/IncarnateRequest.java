package com.likes.common.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncarnateRequest {

    private Long bankaccid;
    private BigDecimal apycamt;
    private String paypassword;
    private String moneyAddress;
    private String coinName;
    private Integer userId;
    private Long memBankId;

    private Integer takeType = 0;

}