package com.likes.common.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class AgentUsersRequest {

    private String email;
    private String password;
    private String nickname;

    private Integer singleAddMoney;


}