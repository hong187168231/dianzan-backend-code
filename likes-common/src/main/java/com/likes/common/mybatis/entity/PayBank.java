package com.likes.common.mybatis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Table(name = "`pay_bank`")
public class PayBank {

    @Id
    @Column(name = "`bank_id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "id")
    private Integer bankId;

    @ApiModelProperty(value = "银行编码")
    private String bankCode;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "银行名称")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}