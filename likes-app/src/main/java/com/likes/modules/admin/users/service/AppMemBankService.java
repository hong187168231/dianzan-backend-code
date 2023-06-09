package com.likes.modules.admin.users.service;

import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.entity.MemBankaccount;

/**
 * <p>
 * 用户绑定银行卡信息表 服务类
 * </p>
 *
 * @author xxx
 * @since 2021-11-17
 */
public interface AppMemBankService {

    boolean addBankCard(AddBankCardReq req, LoginUser loginUser);

    boolean editBankCard(AddBankCardReq req, LoginUser loginUser);

    MemBankVO findPage(LoginUser loginUser);

    boolean getBindStatus(LoginUser loginUser);


    MemBank findMemBankByAccno(String accno);

    MemBank findByMemBankId(Long memBankId);


}