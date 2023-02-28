package com.likes.common.model.vo.finance;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
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
public class FinancesManagerProductOrderVo {
    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "购买理财订单ID")
    private Integer id;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @ApiModelProperty(value = "理财购买日期")
    private Date startTime;
    @ApiModelProperty(value = "理财结算日期")
    private Date endTime;
    @ApiModelProperty(value = "购买理财本金")
    private BigDecimal buyAmount;
    @ApiModelProperty(value = "每日收益金额")
    private BigDecimal everydayAmount;
    @ApiModelProperty(value = "当前收益金额")
    private BigDecimal thedayAmount;
    @ApiModelProperty(value = "总收益金额")
    private BigDecimal sumAmount;
    @ApiModelProperty(value = "理财产品ID")
    private Long financesProductId;
    @ApiModelProperty(value = "会员ID")
    private Long userId;
    @ApiModelProperty(value = "会员账号")
    private String userAcct;
    @ApiModelProperty(value = "提款状态0：未提款，1：已提款")
    private Integer financesProductStatus;
    @ApiModelProperty(value = "vip等级")
    private String levelConfigLevel;

    @ApiModelProperty(value = "收益利率%")
    private Double incomeRate;
    @ApiModelProperty(value = "有效天数")
    private int validDate;
    @ApiModelProperty(value = "产品中文名称")
    private String productNameCn;
    @ApiModelProperty(value = "产品英文名称")
    private String productNameEn;
    @ApiModelProperty(value = "产品越南文名称")
    private String productNameVn;
    @ApiModelProperty(value = "备注")
    private String remark;
    }
