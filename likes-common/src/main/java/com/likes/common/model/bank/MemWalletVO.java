package com.likes.common.model.bank;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 银行支付配置返回
 */
@Data
@ApiModel
public class MemWalletVO {

    @ApiModelProperty(value = "银行名称")
    private Long walletId;

    @ApiModelProperty(value = "用户标识")
    private String accno;

    @ApiModelProperty(value = "用户账号")
    private String email;

    @ApiModelProperty(value = "钱包地址")
    private String moneyAddress;

    @ApiModelProperty(value = "状态：0 禁用 1 开启")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+7")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+7")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}