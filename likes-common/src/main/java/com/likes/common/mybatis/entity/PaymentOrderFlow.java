package com.likes.common.mybatis.entity;


import lombok.Data;

import java.util.Date;


@Data
public class PaymentOrderFlow {

    private Integer id;
    private String payChanCode;//通道代码
    private String payChanName;//通道名称
    private String merchatAcct;//用户方账号
    private String mcode;//支付商户唯一标识（平台方）
    private String payTypeCode;//支付类型代码
    private String payTypeName;//支付类型名称
    private String orderNo;//	是	String	系统订单号（3方支付返回）
    private String merOrderNo;//	是	String(20)	商户订单号
    private Integer orderPrice;//	是	Int	订单金额
    private Integer status;//	是	Int	订单状态： 1 匹配中 2已匹配 3未匹配
    private Integer notifyStatus;//	是	Int	回调状态： 1未回调 2已经回调 3 回调失败
    private String payTime;//	否	String	yyyyMMddHHmmss
    private Date createTime;//创建时间
    private Date updateTime;//修改时间


}
