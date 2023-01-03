package com.likes.common.model.req;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class JackPotReq {


    private String createUser;

    private String updateUser;

    private Integer type;

    private String memberAccno;

    private String agentAccno;

    private BigDecimal amount;
}