package com.likes.modules.pay.vo.cs;

public class CSgetTokenVo {
    private String business_type;//	是	String(5)	业务编码
    private String mer_order_no;//	是	String(20)	商户订单号
    private Integer order_price;//	是	Int	订单金额
    private String pay_type;//	否	String	支付方式：
//    OnlineBank 账户转账
//    ScanCode 银行扫码付
//    DirectBank 网银直连
    private String page_back_url;//	是	String	同步返回商户页面地址(urlencode编码)
    private String notify_url;//	是	String	后台回调通知地址(urlencode编码)
    private String reserve;//	否	String	预留备注留言字段
    private String reserved1;//	否	String	预留字段1
    private String reserved2;//	否	String	预留字段2
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

    public Integer getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getPage_back_url() {
        return page_back_url;
    }

    public void setPage_back_url(String page_back_url) {
        this.page_back_url = page_back_url;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
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
