package com.likes.modules.pay.vo;

public class GetCollectUrlVo {
    private Integer orderPrice;//	是	Int	订单金额
    private String payType;//	否	String	支付方式：
//    OnlineBank 账户转账
//    ScanCode 银行扫码付
//    DirectBank 网银直连
    private String payTypeName;//支付类型名称
    private String pageBackUrl;//	是	String	同步返回商户页面地址(urlencode编码)

    private String merOrderNo;//	是	String(20)	商户订单号

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPageBackUrl() {
        return pageBackUrl;
    }

    public void setPageBackUrl(String pageBackUrl) {
        this.pageBackUrl = pageBackUrl;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
