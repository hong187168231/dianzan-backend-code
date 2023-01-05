package com.likes.common.service.pay;

import com.likes.common.model.dto.pay.CSCallBackVoPrev;
import com.likes.common.model.dto.pay.CsPayDTO;
import com.likes.common.model.dto.pay.CsPayNoticeReq;
import com.likes.common.model.dto.pay.CsPaymentDTO;

public interface CsPayService {


    String submitPay(CsPayDTO csPayDTO) throws Exception;

    CSCallBackVoPrev callbackNotice(CsPayNoticeReq csNoticeVo) throws Exception;

//     JSONObject queryOrder(String orderNo) throws Exception;

    public String submitWithdraw(CsPaymentDTO csPaymentDTO) throws Exception;

    public String getCSAccountPrice() throws Exception;
}