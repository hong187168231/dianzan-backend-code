package com.likes.modules.admin.pay.service.impl;

import com.likes.common.mybatis.entity.PayMerchant;
import com.likes.common.mybatis.mapper.PayMerchantMapper;
import com.likes.modules.admin.pay.service.PayMerchantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayMerchantServiceImpl implements PayMerchantService {

    @Resource
    private PayMerchantMapper payMerchantMapper;

    @Override
    public List<PayMerchant> payMerchantList(String merchantCode) {
        PayMerchant payMerchant = new PayMerchant();
        payMerchant.setMerchantCode(merchantCode);
        List<PayMerchant> merchants = payMerchantMapper.select(payMerchant);
        return merchants;
    }

    @Override
    public PayMerchant getMerchant(String mCode) {
        PayMerchant payMerchant = new PayMerchant();
        payMerchant.setMerchantCode(mCode);
        PayMerchant merchant = payMerchantMapper.selectOne(payMerchant);
        return merchant;
    }
}
