package com.likes.modules.admin.users.service;

import com.likes.common.model.bank.PayBankVO;

import java.util.List;

/**
 * <p>
 * 支付银行表 服务类
 * </p>
 *
 * @author xxx
 * @since 2021-11-13
 */
public interface PayBankService {

    List<PayBankVO> bankList();

}
