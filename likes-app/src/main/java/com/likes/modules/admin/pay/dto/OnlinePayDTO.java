package com.likes.modules.admin.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class OnlinePayDTO {

    @ApiModelProperty("订单金额")
    private Integer orderPrice;//	是	Int	订单金额

    @ApiModelProperty("支付类型（OnlineBank-账户转账 ，ScanCode 银行扫码付 ，DirectBank 网银直连 ）")
    private String payType;//	否	String	支付方式：

    @ApiModelProperty("支付类型名称")
    private String payTypeName;



}
