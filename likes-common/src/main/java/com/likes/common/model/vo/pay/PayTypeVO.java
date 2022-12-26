package com.likes.common.model.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class PayTypeVO {

    @ApiModelProperty(value = "通道代码")
    private String merchantCode;

    @ApiModelProperty(value = "支付类型代码")
    private String payTypeCode;

    @ApiModelProperty(value = "支付类型名称")
    private String payTypeName;

}
