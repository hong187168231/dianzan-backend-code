package com.likes.common.mybatis.entity;


import lombok.Data;

import java.util.Date;

@Data
public class PaymentChannel {
    private Integer id;

    private String payChanCode;//通道代码  关联 MerchantPaymentChannel

    private String payChanName;//通道名称

    private Date createTime;//创建时间

    private Date updateTime;//修改时间
}
