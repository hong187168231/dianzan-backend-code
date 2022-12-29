package com.likes.modules.admin.pay.service;

import com.likes.modules.admin.pay.dto.CsPayDTO;
import com.likes.modules.admin.pay.dto.cs.CSCallBackVoPrev;
import com.likes.modules.admin.pay.dto.cs.CsPayNoticeReq;

public interface CsPayService {


    String submitPay(CsPayDTO csPayDTO) throws Exception;

    CSCallBackVoPrev callbackNotice(CsPayNoticeReq csNoticeVo) throws Exception;


//     JSONObject queryOrder(String orderNo) throws Exception;
}