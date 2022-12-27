package com.likes.common.model.vo.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CsPayResultVo {

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "支付地址")
    private String url;

}