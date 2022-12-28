package com.likes.common.mybatis.entity;


import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "`pay_type`")
public class PayType {

    private Integer id;

    private String merchantCode;//通道代码

    private String payTypeCode;//支付类型代码

    private String payTypeName;//支付类型名称

    private String payTypeNameViet;//支付类型名称

    private String payTypeNameEn;//支付类型名称

    private Date createTime;//创建时间

    private  Integer status;

    private Date updateTime;//修改时间


}