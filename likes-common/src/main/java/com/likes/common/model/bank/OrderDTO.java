package com.likes.common.model.bank;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {

    private String accno;

    private String orderno;

    private String orderStatus;

    private List<Integer> orderStatusList = new ArrayList<>();


}
