package com.likes.common.model.request;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class RechargeUsdtRequest {

    private Long id;
    private BigDecimal amount;
    private String payAddress;
    private String transferAddress;
}