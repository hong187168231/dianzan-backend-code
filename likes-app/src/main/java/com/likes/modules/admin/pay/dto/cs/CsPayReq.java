package com.likes.modules.admin.pay.dto.cs;


import lombok.Data;

@Data
public class CsPayReq {

    private String business_type;//	是	String(5)	业务编码
    private String mer_order_no;//	是	String(20)	商户订单号
    private Integer order_price;//	是	Int	订单金额
    private String pay_type;//	否	String	支付方式：
    private String page_back_url;//	是	String	同步返回商户页面地址(urlencode编码)
    private String notify_url;//	是	String	后台回调通知地址(urlencode编码)
    private String reserve;//	否	String	预留备注留言字段
    private String reserved1;//	否	String	预留字段1
    private String reserved2;//	否	String	预留字段2
    private Long timestamp;//	是	Int(10)	十位时间戳
    private String sign;//	是	String(32)	签名字符(查看sign签名说明)

}
