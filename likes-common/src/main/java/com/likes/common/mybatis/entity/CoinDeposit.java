package com.likes.common.mybatis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "`coin_deposit`")
@Data
public class CoinDeposit {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`coin_type`")
    @ApiModelProperty(value = "币种类型")
    private String coinType;

    @Column(name = "`coin_name`")
    @ApiModelProperty(value = "币种名称")
    private BigDecimal coinName;

    @Column(name = "`address`")
    @ApiModelProperty(value = "钱包地址")
    private BigDecimal address;

    @Column(name = "`image_url`")
    @ApiModelProperty(value = "图片地址")
    private BigDecimal imageUrl;

    @Column(name = "`status`")
    @ApiModelProperty(value = "状态 0 关闭 1 开启")
    private Integer status;

    @Column(name = "`del_status`")
    @ApiModelProperty(value = "删除状态 0 正常 1 删除")
    private Integer delStatus;

    @Column(name = "`create_user`")
    @ApiModelProperty(value = "创建人")
    private String createUser;

    @Column(name = "`update_user`")
    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @Column(name = "`create_time`")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Column(name = "`update_time`")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}