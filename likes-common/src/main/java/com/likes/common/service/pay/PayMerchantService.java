package com.likes.common.service.pay;

import com.likes.common.mybatis.entity.PayBank;
import com.likes.common.mybatis.entity.PayMerchant;

import java.util.List;

public interface PayMerchantService {


    List<PayMerchant> payMerchantList(String merchantCode);

    PayMerchant getMerchant(String mCode);

    public List<PayBank> queryBanks();
}
