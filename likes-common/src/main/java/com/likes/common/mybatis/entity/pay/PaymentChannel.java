package com.likes.common.mybatis.entity.pay;


import java.util.Date;

public class PaymentChannel {
    private Integer id;

    private String payChanCode;//通道代码  关联 MerchantPaymentChannel

    private String payChanName;//通道名称

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

    public String getPayChanName() {
        return payChanName;
    }

    public void setPayChanName(String payChanName) {
        this.payChanName = payChanName;
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
}
