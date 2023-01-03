package com.likes.common.mybatis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * <p>
 * 用户绑定银行卡信息表
 * </p>
 *
 * @author xxx
 * @since 2021-12-21
 */
@Data
@ApiModel(value = "MemBankRelation对象", description = "用户绑定银行卡信息表")
public class MemBank {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @Id
    @Column(name = "`mem_bank_id`")
    @GeneratedValue(generator = "JDBC")
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

    @ApiModelProperty(value = "备注")
    private String remark;


    private String createUser;

    private String updateUser;

    private Date createTime;

    private Date updateTime;


}