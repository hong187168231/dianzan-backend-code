package com.likes.common.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.units.qual.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("finances_manager_product")
public class FinancesManagerProduct{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "更新人")
    private String updateBy;
    @Min(value = 0,message = "活动商品单价必须大于等于0！")
    @ApiModelProperty(value = "收益利率%")
    @NotNull(message = "收益利率%不能为空！")
    private Double incomeRate;
    @Min(value = 1,message = "活动商品单价必须大于等于1！")
    @NotNull(message = "有效天数不能为空！")
    @ApiModelProperty(value = "有效天数")
    private int validDate;
    @ApiModelProperty(value = "产品中文名称")
    @NotEmpty(message = "产品中文名称不能为空！")
    private String productNameCn;
    @ApiModelProperty(value = "产品英文名称")
    @NotEmpty(message = "产品英文名称不能为空！")
    private String productNameEn;
    @ApiModelProperty(value = "产品越南文名称")
    @NotEmpty(message = "产品越南文名称不能为空！")
    private String productNameVn;
    @ApiModelProperty(value = "备注")
    private String remark;
    }
