package com.likes.common.model.dto.finances;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FinancesManagerGetProductOrderDto {
    @ApiModelProperty(value = "订单ID")
    @NotNull(message = "订单ID不能为空！")
    private Long orderId;
}
