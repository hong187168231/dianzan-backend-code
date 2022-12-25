package com.likes.common.mybatis.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "`pay_merchant`")
public class PayMerchant {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "通道代码")
    private String payChanCode;

    @ApiModelProperty(value = "通道名称")
    private String payChanName;


    @ApiModelProperty(value = "用户方账号")
    private String merchantNo;

    @ApiModelProperty(value = "支付商户唯一标识")
    private String merchantCode;

    @ApiModelProperty(value = "支付商户key")
    private String merchantKey;

    @ApiModelProperty(value = "是否關閉 0：否 1關閉")
    private int status;

    @ApiModelProperty(value = "支付成功跳转地址")
    private String pageBackUrl;

    @ApiModelProperty(value = "异步通知地址")
    private String notifyUrl;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;




}
