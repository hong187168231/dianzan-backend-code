package com.likes.common.model.dto.coin;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CoinDepositDTO {

    private Long id;

    private String coinType;

    private String coinName;

    private String address;

    private String imageUrl;

    private Integer status;



}