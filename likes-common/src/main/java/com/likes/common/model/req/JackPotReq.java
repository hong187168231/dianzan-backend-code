package com.likes.common.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel
public class JackPotReq {

    private String createUser;
    private String updateUser;

    private Integer type;

    @ApiModelProperty("会员标识号")
    private String memberAccno;

    @ApiModelProperty("代理标识号")
    private String agentAccno;

    @ApiModelProperty("操作额度")
    private BigDecimal amount;
}