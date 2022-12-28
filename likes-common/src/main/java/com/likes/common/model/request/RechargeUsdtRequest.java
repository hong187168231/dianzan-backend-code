package com.likes.common.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


@Data
@ApiModel
public class RechargeUsdtRequest {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("充值金额")
    private BigDecimal amount;
    @ApiModelProperty("付款地址")
    private String payAddress;

    @ApiModelProperty("付款人")
    private String payUserName;

    @ApiModelProperty("收款地址")
    private String transferAddress;
}