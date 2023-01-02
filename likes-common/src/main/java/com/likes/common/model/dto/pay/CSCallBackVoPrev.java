package com.likes.common.model.dto.pay;

public class CSCallBackVoPrev {
    private String code;//	是	String	0代表成功
    private String msg;//	是	String	返回消息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
