package com.likes.common.mybatis.entity.pay;


import java.util.Date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayChanCode() {
        return payChanCode;
    }

    public void setPayChanCode(String payChanCode) {
        this.payChanCode = payChanCode;
    }

    public String getPayTypeCode() {
        return payTypeCode;
    }

    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPayChanName() {
        return payChanName;
    }

    public void setPayChanName(String payChanName) {
        this.payChanName = payChanName;
    }

    public String getMerchatAcct() {
        return merchatAcct;
    }

    public void setMerchatAcct(String merchatAcct) {
        this.merchatAcct = merchatAcct;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(Integer notifyStatus) {
        this.notifyStatus = notifyStatus;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
}
