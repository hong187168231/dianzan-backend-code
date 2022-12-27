package com.likes.common.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
public class EntryOrderReq {

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "accno")
    private String accno;

    @ApiModelProperty(value = "订单编号")
    private String orderno;

    @ApiModelProperty(value = "订单状态")
    private String orderstatus;

    @ApiModelProperty(value = "支付方式 NETBANK 网银转账  WECHAT 微信收款  ALIPAY 支付宝支付")
    private String payType;

    @ApiModelProperty(value = "uniqueId")
    private String uniqueId;

    @ApiModelProperty(value = "providerid")
    private String providerid;

    @ApiModelProperty(value = "startDate")
    private String startDate;
    @ApiModelProperty(value = "endDate")
    private String endDate;


}
