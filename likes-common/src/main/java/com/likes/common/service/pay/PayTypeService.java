package com.likes.common.service.pay;

import com.likes.common.model.request.PayTypeRequest;
import com.likes.common.model.vo.pay.PayTypeVO;

import java.util.List;

public interface PayTypeService {

    List<PayTypeVO> payTypeList(String language);
}