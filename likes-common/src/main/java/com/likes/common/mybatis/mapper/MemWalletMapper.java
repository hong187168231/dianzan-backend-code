package com.likes.common.mybatis.mapper;

import com.github.pagehelper.Page;
import com.likes.common.model.bank.MemBankPageReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.bank.MemWalletPageReq;
import com.likes.common.model.bank.MemWalletVO;
import com.likes.common.mybatis.entity.MemWallet;
import com.likes.common.mybatis.entity.MemWalletAddress;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

public interface MemWalletMapper extends Mapper<MemWallet> {

    Page<MemWalletVO> queryList(@Param("req") MemWalletPageReq req, RowBounds rowBounds);

}
