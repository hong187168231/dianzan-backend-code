package com.likes.modules.admin.pay.service;

import com.likes.modules.admin.pay.dto.CsPayDTO;
import com.likes.modules.admin.pay.dto.cs.CSCallBackVoPrev;
import com.likes.modules.admin.pay.dto.cs.CSNoticeVo;

public interface CsPayService {


    String submitPay(CsPayDTO csPayDTO) throws Exception;

    CSCallBackVoPrev csNotice(CSNoticeVo csNoticeVo) throws Exception;


//     JSONObject queryOrder(String orderNo) throws Exception;
}
