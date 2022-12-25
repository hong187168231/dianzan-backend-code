package com.likes.modules.admin.pay.dto.cs;

public class CSNoticeVo {
    public String mcode;//	是	String(32)	商户唯一标识
    public String params;//	是	String	加密参数(查看params参数说明)

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
