package com.likes.common.model.vo.pay;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 * 天强支付
 * @author 瑞夫
 * @version 1.0
 * @date 2020/7/14
 */
@Scope("prototype")
@Component
public class TianqiangNotify extends Notify{

    private String memberid;

    private String orderid;

    private String amount;

    private String transaction_id;

    private String datetime;

    private String returncode;

    private String attach;

    private String sign;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
