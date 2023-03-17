package com.likes.modules.admin.user.service;

import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankSwitchReq;
import com.likes.common.model.bank.MemWalletPageReq;
import com.likes.common.model.bank.MemWalletSwitchReq;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.entity.MemWallet;

public interface IMemWalletService {

    PageResult queryList(MemWalletPageReq req, PageBounds page);

    boolean switchStatus(MemWalletSwitchReq req);

    boolean edit(Long walletId, String moneyAddress);

    MemWallet selectByWalletId(Long walletId);

    MemWallet  selectByAccno(String accno);

}