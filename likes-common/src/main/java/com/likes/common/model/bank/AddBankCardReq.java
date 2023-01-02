package com.likes.common.model.bank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "添加请求参数类")
public class AddBankCardReq {

    @ApiModelProperty(value = "会员银行卡id", required = true)
    @NotNull
    private Long memBankId;

    @ApiModelProperty(value = "银行卡用户名", required = true)
    @NotEmpty
    private String userName;

    @ApiModelProperty(value = "银行id", required = true)
    @NotNull
    private Long bankId;

    @ApiModelProperty(value = "卡号", required = true)
    @NotEmpty
    private String bankCardNo;

}
