package com.likes.modules.admin.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CsPayDTO {

    @ApiModelProperty("订单金额")
    private Integer amount;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty("支付类型")
    private String payType;
    @ApiModelProperty("支付成功跳转地址")
    private String backUrl;
    @ApiModelProperty("异步通知地址")
    private String notifyUrl;


}
