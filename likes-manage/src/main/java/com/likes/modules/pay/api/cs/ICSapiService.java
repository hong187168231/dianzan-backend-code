package com.likes.modules.pay.api.cs;

import com.alibaba.fastjson.JSONObject;

public interface ICSapiService {
    public String getToken(Integer amount,String orderNo,String payType,String backUrl,String notifyUsrl) throws Exception;
    public JSONObject queryOrder(String orderNo) throws Exception;
}
