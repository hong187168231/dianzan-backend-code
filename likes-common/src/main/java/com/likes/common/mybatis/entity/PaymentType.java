package com.likes.common.mybatis.entity;


import lombok.Data;

import java.util.Date;

@Data
public class PaymentType {

    private Integer id;

    private String payChanCode;//通道代码

    private String payTypeCode;//支付类型代码

    private String payTypeName;//支付类型名称

    private Date createTime;//创建时间

    private Date updateTime;//修改时间


}
