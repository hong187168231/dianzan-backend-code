package com.likes.common.mybatis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@ApiModel(value = "MemWallet对象", description = "用户绑定钱包信息表")
public class MemWallet {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @Id
    @Column(name = "`wallet_id`")
    @GeneratedValue(generator = "JDBC")
    private Long walletId;

    @ApiModelProperty(value = "用户标识")
    private String accno;

    @ApiModelProperty(value = "币种名称")
    private String coinName;

    @ApiModelProperty(value = "钱包地址")
    private String moneyAddress;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;


}