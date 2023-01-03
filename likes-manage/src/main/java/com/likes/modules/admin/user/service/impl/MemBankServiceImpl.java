package com.likes.modules.admin.user.service.impl;

import com.github.pagehelper.Page;
import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankSwitchReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.mapper.MemBankMapper;
import com.likes.modules.admin.user.service.IMemBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户绑定银行卡信息表 服务实现类
 * </p>
 *
 * @author kevin
 * @since 2021-11-06
 */
@Service
public class MemBankServiceImpl implements IMemBankService {

    @Autowired
    private MemBankMapper memBankMapper;

    @Override
    public PageResult queryList(MemBankPageReq req, PageBounds page) {
        Page<MemBankVO> list = memBankMapper.queryList(req, page.toRowBounds());
        return PageResult.getPageResult(page, list);
    }

    @Override
    public boolean switchStatus(MemBankSwitchReq req) {
        MemBank memBankRelation = new MemBank();
        memBankRelation.setMemBankId(req.getMemBankId());
        memBankRelation.setStatus(req.getStatus());
       return memBankMapper.updateByPrimaryKeySelective(memBankRelation) > 0;
    }

    @Override
    public boolean edit(Long memBankId, String bankCardNo) {
        MemBank memBank = memBankMapper.selectByPrimaryKey(memBankId);
        memBank.setBankCardNo(bankCardNo);
        return memBankMapper.updateByPrimaryKeySelective(memBank) > 0;
    }


}