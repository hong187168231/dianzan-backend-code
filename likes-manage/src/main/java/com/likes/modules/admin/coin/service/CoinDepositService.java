package com.likes.modules.admin.coin.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.dto.coin.CoinDepositDTO;
import com.likes.common.mybatis.entity.CoinDeposit;
import com.likes.common.mybatis.mapper.CoinDepositMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CoinDepositService {

    @Resource
    private CoinDepositMapper coinDepositMapper;

    /**
     * 最新公告
     *
     * @return
     */
    public PageInfo<CoinDeposit> coinDepositList(PageBounds page) {
        CoinDeposit coinDeposit = new CoinDeposit();
        coinDeposit.setDelStatus(0);
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<CoinDeposit> coinDepositList = coinDepositMapper.select(coinDeposit);
        PageInfo<CoinDeposit> pageInfo = new PageInfo<>(coinDepositList);
        return pageInfo;
    }

    public Boolean saveCoinDeposit(CoinDeposit coinDeposit, LoginUser loginUser) {
        coinDeposit.setCreateUser(loginUser.getAcclogin());
        coinDeposit.setDelStatus(0);
        return coinDepositMapper.insert(coinDeposit) > 0;
    }

    public boolean modifyCoinDeposit(CoinDepositDTO coinDto, LoginUser loginUser) {
        if (ObjectUtils.isEmpty(coinDto.getId())) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "id项不允许为空");
        }
        CoinDeposit coinDeposit = new CoinDeposit();
        BeanUtils.copyProperties(coinDto, coinDeposit);
        coinDeposit.setId(coinDto.getId().intValue());
        coinDeposit.setUpdateUser(loginUser.getAcclogin());
        return coinDepositMapper.updateByPrimaryKeySelective(coinDeposit) > 0;
    }


    public boolean delCoinDeposit(Integer id, LoginUser loginUser) {
        CoinDeposit coinDeposit = new CoinDeposit();
        coinDeposit.setDelStatus(1);
        coinDeposit.setId(id);
        coinDeposit.setUpdateUser(loginUser.getAcclogin());
        return coinDepositMapper.updateByPrimaryKeySelective(coinDeposit) > 0;
    }

    public boolean editCoinStatus(Integer id, Integer status, LoginUser loginUser) {
        CoinDeposit coinDeposit = new CoinDeposit();
        coinDeposit.setStatus(status);
        coinDeposit.setId(id);
        coinDeposit.setUpdateUser(loginUser.getAcclogin());
        return coinDepositMapper.updateByPrimaryKeySelective(coinDeposit) > 0;
    }

}