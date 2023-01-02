package com.likes.common.model.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CsPaymentDTO {

    @ApiModelProperty("订单金额")
    private Integer amount;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty("异步通知地址")
    private String notifyUrl;
    @ApiModelProperty("收款银行ID")
    private String bankId;
    @ApiModelProperty("收款账号/卡号")
    private String beneNo;
    @ApiModelProperty("收款人姓名 用户英文实名")
    private String payee;

}
