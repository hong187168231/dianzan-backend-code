package com.likes.modules.admin.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.bank.*;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.entity.MemWallet;
import com.likes.common.mybatis.entity.PayBank;
import com.likes.common.mybatis.mapper.MemBankMapper;
import com.likes.common.mybatis.mapper.MemWalletMapper;
import com.likes.common.mybatis.mapper.PayBankMapper;
import com.likes.modules.admin.user.service.IMemBankService;
import com.likes.modules.admin.user.service.IMemWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemWalletServiceImpl implements IMemWalletService {

    @Autowired
    private MemWalletMapper memWalletMapper;

    @Override
    public PageResult queryList(MemWalletPageReq req, PageBounds page) {
        Page<MemWalletVO> list = memWalletMapper.queryList(req, page.toRowBounds());
        return PageResult.getPageResult(page, list);
    }

    @Override
    public boolean switchStatus(MemWalletSwitchReq req) {
        MemWallet memBankRelation = new MemWallet();
        memBankRelation.setWalletId(req.getWalletId());
        memBankRelation.setStatus(req.getStatus());
        return memWalletMapper.updateByPrimaryKeySelective(memBankRelation) > 0;
    }

    @Override
    public boolean edit(Long walletId, String moneyAddress) {
        MemWallet memWallet = memWalletMapper.selectByPrimaryKey(walletId);
        memWallet.setMoneyAddress(moneyAddress);
        memWallet.setUpdateTime(new Date());
        return memWalletMapper.updateByPrimaryKeySelective(memWallet) > 0;
    }

    @Override
    public MemWallet selectByWalletId(Long walletId) {
        if (ObjectUtil.isNull(walletId)) {
            return null;
        }
        MemWallet memBankParam = new MemWallet();
        memBankParam.setWalletId(walletId);
        return memWalletMapper.selectOne(memBankParam);
    }

    @Override
    public MemWallet selectByAccno(String accno) {
        if (StrUtil.isBlank(accno)) {
            return null;
        }
        MemWallet memBankParam = new MemWallet();
        memBankParam.setAccno(accno);
        return memWalletMapper.selectOne(memBankParam);
    }

}