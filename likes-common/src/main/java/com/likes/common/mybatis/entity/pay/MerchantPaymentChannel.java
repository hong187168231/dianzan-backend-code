package com.likes.common.mybatis.entity.pay;


import java.util.Date;

public class MerchantPaymentChannel {
    private Integer id;

    private String payChanCode;//通道代码

    private String payChanName;//通道名称

    private String merchatAcct;//用户方账号

    private String mcode;//支付商户唯一标识（平台方）

    private String mkey;//支付商户key（平台方）

    private Date createTime;//创建时间

    private int isOff;//是否關閉 0：否 1關閉

    private int errNo;//錯誤次數 次數越大越靠后

    private String notifyUrl;//	是	String	后台回调通知地址(urlencode编码)

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

    public String getMkey() {
        return mkey;
    }

    public void setMkey(String mkey) {
        this.mkey = mkey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIsOff() {
        return isOff;
    }

    public void setIsOff(int isOff) {
        this.isOff = isOff;
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
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
}
