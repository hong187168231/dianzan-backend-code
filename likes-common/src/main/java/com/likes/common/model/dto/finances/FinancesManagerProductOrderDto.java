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
public class FinancesManagerProductOrderDto {
    @ApiModelProperty(value = "购买理财本金")
    @NotNull(message = "购买理财本金不能为空！")
    private BigDecimal buyAmount;
    @ApiModelProperty(value = "理财产品ID")
    @NotNull(message = "理财产品ID不能为空！")
    private Long financesProductId;
}
