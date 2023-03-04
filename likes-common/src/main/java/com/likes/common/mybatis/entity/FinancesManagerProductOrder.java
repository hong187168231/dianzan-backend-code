package com.likes.common.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FinancesManagerProductOrder {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @ApiModelProperty(value = "理财购买日期")
    @NotEmpty(message = "理财开始时间不能为空！")
    private String startTime;
    @ApiModelProperty(value = "理财结算日期")
    @NotEmpty(message = "理财结束时间不能为空！")
    private String endTime;
    @ApiModelProperty(value = "购买理财本金")
    @NotNull(message = "购买理财本金不能为空！")
    private BigDecimal buyAmount;
    @ApiModelProperty(value = "每日收益金额")
    @NotNull(message = "每日收益金额不能为空！")
    private BigDecimal everydayAmount;
    @ApiModelProperty(value = "总收益金额")
    @NotNull(message = "总收益金额不能为空！")
    private BigDecimal sumAmount;
    @ApiModelProperty(value = "理财产品ID")
    @NotNull(message = "理财产品ID不能为空！")
    private Long financesProductId;
    @ApiModelProperty(value = "会员ID")
    @NotNull(message = "会员ID不能为空！")
    private String userId;
    @ApiModelProperty(value = "会员账号")
    @NotEmpty(message = "会员账号不能为空！")
    private String userAcct;
    @ApiModelProperty(value = "提款状态0：未提款，1：已提款")
    @NotNull(message = "提款状态不能为空！")
    private Integer financesProductStatus;
    @ApiModelProperty(value = "vip等级")
    @NotEmpty(message = "vip等级不能为空！")
    private String levelConfigLevel;
}
