package com.likes.modules.admin.users.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.constant.GlobalConstants;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.bank.OrderDTO;
import com.likes.common.mybatis.entity.MemBank;
import com.likes.common.mybatis.entity.MemBaseinfo;
import com.likes.common.mybatis.entity.PayBank;
import com.likes.common.mybatis.mapper.MemBankMapper;
import com.likes.common.mybatis.mapper.PayBankMapper;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.util.CollectionUtil;
import com.likes.common.util.uploadFile.DTOUtil;
import com.likes.modules.admin.users.service.AppMemBankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 用户绑定银行卡信息表 服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-11-17
 */
@Service
public class AppMemBankServiceImpl implements AppMemBankService {

    @Autowired
    private MemBankMapper memBankMapper;

    @Autowired
    private PayBankMapper payBankMapper;

    @Autowired
    private MemBaseinfoService memBaseinfoService;


    @Override
    public boolean addBankCard(AddBankCardReq req, LoginUser loginUser) {
        MemBank countBank = new MemBank();
        countBank.setUserId(loginUser.getMemid());
        int levelCount = memBankMapper.selectCount(countBank);
        if (levelCount > 0) {
            throw new BusinessException("你已绑定银行卡!");
        }
        PayBank payBank = payBankMapper.selectByPrimaryKey(req.getBankId());
        if (ObjectUtil.isNull(payBank)) {
            throw new BusinessException("无效银行id!");
        }
        MemBaseinfo memBaseinfo = memBaseinfoService.selectById(loginUser.getMemid());
//        if(StringUtils.isEmpty(memBaseinfo.getIdCard())){
//            throw new BizException("请先完成实名认证！");
//        }
//        if(!req.getUserName().equals(memBaseinfo.getRealName())){
//            throw new BizException("银行卡户名和认证户名不一致!");
//        }
        MemBank memBankRelation = new MemBank();
        BeanUtils.copyProperties(req, memBankRelation);
        memBankRelation.setUserId(loginUser.getMemid());
        memBankRelation.setBankName(payBank.getBankName());
        return memBankMapper.insertSelective(memBankRelation) > 0;
    }

    @Override
    public boolean editBankCard(AddBankCardReq req, LoginUser loginUser) {
        PayBank payBank = payBankMapper.selectByPrimaryKey(req.getBankId());
        if (ObjectUtil.isNull(payBank)) {
            throw new BusinessException("无效银行id!");
        }
        MemBank memBankParam = new MemBank();
        memBankParam.setUserId(loginUser.getMemid());
        List<MemBank> memBankList = memBankMapper.select(memBankParam);
        List<Long> ids = new LinkedList<>();
        for (MemBank memBank : memBankList) {
            ids.add(memBank.getMemBankId());
        }
        if (!ids.contains(req.getMemBankId())) {
            throw new BusinessException("请输入自己的银行卡!");
        }
        MemBaseinfo memBaseinfo = memBaseinfoService.selectByPrimaryKey(loginUser.getMemid());
//        if(!req.getUserName().equals(memBaseinfo.getRealName())){
//            throw new BusinessException("银行卡户名和认证户名不一致!");
//        }
        OrderDTO orderRequest = new OrderDTO();
        orderRequest.setAccno(loginUser.getAccno());
        List<Integer> orderStatusList = new ArrayList<>();
        orderStatusList.add(GlobalConstants.PAY_CASH_STATUS_PENDING);
        orderStatusList.add(GlobalConstants.PAY_CASH_STATUS_LOCK);
        orderRequest.setOrderStatusList(orderStatusList);
//        PayTakeCash existOrderInfo = memBankMapper.existCashOrder(orderRequest);
//        if (existOrderInfo != null) {
//            throw new BizException("存在提现订单,不能更改银行卡");
//        }
        MemBank memBankRelation = new MemBank();
        BeanUtils.copyProperties(req, memBankRelation);
        memBankRelation.setUserId(loginUser.getMemid());
//        memBankRelation.setMobile(loginUser.getMobile());
        memBankRelation.setMemBankId(req.getMemBankId());
        memBankRelation.setBankId(payBank.getBankId());
        return memBankMapper.updateByPrimaryKey(memBankRelation) > 0;
    }

    @Override
    public MemBankVO findPage(LoginUser loginUser) {
        MemBank memBankParam = new MemBank();
        memBankParam.setUserId(loginUser.getMemid());
        List<MemBank> list = memBankMapper.select(memBankParam);
        if (CollectionUtil.isEmpty(list)) {
            return new MemBankVO();
        }
        MemBank memBank = list.get(0);
        MemBankVO result = DTOUtil.toDTO(memBank, MemBankVO.class);
        PayBank payBank = payBankMapper.selectByPrimaryKey(memBank.getBankId());
        result.setBankName(payBank.getBankName());
        return result;
    }

}
