package com.likes.modules.admin.pay.dto.cs;

public class CSgetOrderVo {
    private String business_type;//	是	String(5)	业务编码
    private String mer_order_no;//	是	String(20)	商户订单号
    private Long timestamp;//	是	Int(10)	十位时间戳
    private String sign;//	是	String(32)	签名字符(查看sign签名说明)

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getMer_order_no() {
        return mer_order_no;
    }

    public void setMer_order_no(String mer_order_no) {
        this.mer_order_no = mer_order_no;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
