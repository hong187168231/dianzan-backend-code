package com.likes.modules.admin.users.service;

import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.entity.MemWallet;

/**
 * <p>
 * 用户绑定银行卡信息表 服务类
 * </p>
 *
 * @author xxx
 * @since 2021-11-17
 */
public interface AppMemWalletService {


    MemWallet findMemWalletByAccno(String accno);

    int saveWallet(MemWallet memWallet);

    int editWallet(MemWallet memWallet);

}