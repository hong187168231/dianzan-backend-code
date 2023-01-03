package com.likes.common.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
@Data
public class AgentUserRequest {

    @ApiModelProperty("代理用户ID")
    private Long memId;

    @ApiModelProperty("账号")
    private String email;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("单笔操额度")
    private Integer singleAddMoney;


}