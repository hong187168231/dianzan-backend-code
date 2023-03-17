package com.likes.common.model.bank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MemWalletSwitchReq {

    @ApiModelProperty("walletId")
    private Long walletId;

    @ApiModelProperty(value = "状态：0-启用 1-禁用")
    private Integer status;
}