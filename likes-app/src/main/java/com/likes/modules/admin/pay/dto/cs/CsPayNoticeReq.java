package com.likes.modules.admin.pay.dto.cs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class CsPayNoticeReq implements Serializable {

    @ApiModelProperty(value = "mcode")
    public String mcode;

    @ApiModelProperty(value = "加密参数")
    public String params;


}