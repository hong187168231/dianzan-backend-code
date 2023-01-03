package com.likes.common.model.bank;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Date;

/**
 * 银行支付配置返回
 */
@Data
@ApiModel
public class MemBankVO {

    @ApiModelProperty(value = "银行名称")
    private Long memBankId;

    @ApiModelProperty(value = "用户标识")
    private String accno;

    @ApiModelProperty(value = "用户账号")
    private String email;

    @ApiModelProperty(value = "银行卡用户名")
    private String userName;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行id")
    private Long bankId;

    @ApiModelProperty(value = "银行卡号")
    private String bankCardNo;

    @ApiModelProperty(value = "支行")
    private String bankBranch;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "状态：0 开启 1 禁用")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}