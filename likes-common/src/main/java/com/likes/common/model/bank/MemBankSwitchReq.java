package com.likes.common.model.bank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MemBankSwitchReq {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty(value = "状态：0-启用 1-禁用")
    private Integer status;
}
