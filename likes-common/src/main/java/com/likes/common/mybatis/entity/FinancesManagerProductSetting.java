package com.likes.common.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("finances_manager_product_order")
public class FinancesManagerProductSetting{
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
    @NotNull(message = "最低存款金额不能为空！")
    @ApiModelProperty(value = "最低存款金额")
    private Double minAmout;
    @ApiModelProperty(value = "vip等级ID")
    @NotNull(message = "vip等级ID不能为空！")
    private Long levelConfigId;
    @ApiModelProperty(value = "vip等级")
    @NotEmpty(message = "vip等级不能为空！")
    private String levelConfigLevel;
    @ApiModelProperty(value = "vip等级序号")
    @NotNull(message = "vip等级序号不能为空！")
    private Integer levelConfigReq;
    @ApiModelProperty(value = "限制用户购买次数（小于0为无限制）")
    @NotNull(message = "限制用户购买次数不能为空！")
    private Integer buyNumber;
    @ApiModelProperty(value = "理财产品ID")
    @NotNull(message = "理财产品ID不能为空！")
    private Long financesProductId;
    }
