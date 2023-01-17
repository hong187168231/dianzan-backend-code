package com.likes.common.model.request;


import lombok.Data;

@Data
public class AgentOrderReq {

    private String email;

    private String acclogin;

    private String accno;
    /**
     * 订单编号
     */
    private String orderno;
    /**
     * 订单状态
     */
    private String orderstatus;
    private String uniqueId;
    private String superiorId;
    private String startDate;
    private String endDate;

    private String beginTime;
    private String endTime;

}
