package com.likes.common.service.pay.impl;

import com.likes.common.model.bank.PayBankVO;
import com.likes.common.mybatis.entity.PayBank;
import com.likes.common.mybatis.mapper.PayBankMapper;
import com.likes.common.util.uploadFile.DTOUtil;
import com.likes.common.service.pay.PayBankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 支付银行表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-13
 */
@Service
public class PayBankServiceImpl implements PayBankService {

    @Resource
    private PayBankMapper payBankMapper;

    @Override
    public List<PayBankVO> bankList() {
        PayBank payBank = new PayBank();
        payBank.setStatus(1);
        List<PayBank> list = payBankMapper.select(payBank);
        List<PayBankVO> result = DTOUtil.toDTO(list, PayBankVO.class);
        return result;
    }

    @Override
    public PayBank selectByBankId(Integer bankId) {
        return payBankMapper.selectByPrimaryKey(bankId);
    }
}