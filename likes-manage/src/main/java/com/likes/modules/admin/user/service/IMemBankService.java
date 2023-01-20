package com.likes.modules.admin.user.service;

import com.github.pagehelper.Page;
import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankSwitchReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.MemBank;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 用户绑定银行卡信息表 服务类
 * </p>
 *
 * @author kevin
 * @since 2021-11-06
 */
public interface IMemBankService {

    PageResult queryList(MemBankPageReq req, PageBounds page);

    boolean switchStatus(MemBankSwitchReq req);

    boolean edit(Long memBankId, String bankCardNo,Long bankId);

    MemBank  selectByMemBankId(Long memBankId);

    MemBank  selectByAccno(String accno);

}