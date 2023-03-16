package com.likes.modules.admin.users.service.impl;

import com.likes.common.mybatis.entity.MemWallet;
import com.likes.common.mybatis.mapper.MemWalletMapper;
import com.likes.modules.admin.users.service.AppMemWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppMemWalletkServiceImpl implements AppMemWalletService {

    @Autowired
    private MemWalletMapper memWalletMapper;

    @Override
    public MemWallet findMemWalletByAccno(String accno) {
        MemWallet memBankParam = new MemWallet();
        memBankParam.setAccno(accno);
        return memWalletMapper.selectOne(memBankParam);
    }

    @Override
    public int saveWallet(MemWallet memWallet) {
        return memWalletMapper.insertSelective(memWallet);
    }

    @Override
    public int editWallet(MemWallet memWallet) {
        return memWalletMapper.updateByPrimaryKeySelective(memWallet);
    }

}