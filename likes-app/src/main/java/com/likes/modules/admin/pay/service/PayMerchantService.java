package com.likes.modules.admin.pay.service;

import com.likes.common.mybatis.entity.PayMerchant;

import java.util.List;

public interface PayMerchantService {


    List<PayMerchant> payMerchantList(String merchantCode);

    PayMerchant getMerchant(String mCode);

}
