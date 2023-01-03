package com.likes.modules.admin.users.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.constant.Constants;
import com.likes.common.constant.GlobalConstants;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.bank.AddBankCardReq;
import com.likes.common.model.bank.MemBankVO;
import com.likes.common.model.bank.OrderDTO;
import com.likes.common.model.dto.order.OrderRequest;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.MemBankMapper;
import com.likes.common.mybatis.mapper.PayBankMapper;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.money.TraOrderinfomService;
import com.likes.common.util.CollectionUtil;
import com.likes.common.util.uploadFile.DTOUtil;
import com.likes.modules.admin.users.service.AppMemBankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private TraOrderinfomService traOrderinfomMapperService;


    @Override
    public boolean addBankCard(AddBankCardReq req, LoginUser loginUser) {
        MemBank countBank = new MemBank();
        countBank.setAccno(loginUser.getAccno());
        int levelCount = memBankMapper.selectCount(countBank);
        if (levelCount > 0) {
            throw new BusinessException("你已绑定银行卡!");
        }
        PayBank payBank = payBankMapper.selectByPrimaryKey(req.getBankId());
        if (ObjectUtil.isNull(payBank)) {
            throw new BusinessException("无效银行id!");
        }
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setAccno(loginUser.getAccno());
        List<String> orderstatusList = new ArrayList<>();
        // ord05提现申请 ord07提现处理中
        orderstatusList.add(Constants.ORDER_ORD05);
        orderstatusList.add(Constants.ORDER_ORD07);
        orderRequest.setOrderstatusList(orderstatusList);
        TraOrderinfom existOrderinfom = traOrderinfomMapperService.existOrderinfom(orderRequest);
        if (existOrderinfom != null) {
            throw new BusinessException(StatusCode.LIVE_ERROR_109.getCode(), "存在提现订单,不能更改钱包地址");
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
        memBankRelation.setAccno(loginUser.getAccno());
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
        memBankParam.setAccno(loginUser.getAccno());
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
        TraApplycash existOrderInfo = memBankMapper.existCashOrder(orderRequest);
        if (existOrderInfo != null) {
            throw new BusinessException("存在提现订单,不能更改银行卡");
        }
        MemBank memBankRelation = new MemBank();
        BeanUtils.copyProperties(req, memBankRelation);
        memBankRelation.setAccno(loginUser.getAccno());
//        memBankRelation.setMobile(loginUser.getMobile());
        memBankRelation.setMemBankId(req.getMemBankId());
        memBankRelation.setBankId(payBank.getBankId());
        return memBankMapper.updateByPrimaryKey(memBankRelation) > 0;
    }

    @Override
    public MemBankVO findPage(LoginUser loginUser) {
        MemBank memBankParam = new MemBank();
        memBankParam.setAccno(loginUser.getAccno());
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

    @Override
    public boolean getBindStatus(LoginUser loginUser) {
        MemBank countBank = new MemBank();
        countBank.setAccno(loginUser.getAccno());
        int levelCount = memBankMapper.selectCount(countBank);
        if (levelCount > 0) {
            return true;
        }
        return false;
    }

}