package com.likes.common.service.finances.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.enums.GoldchangeEnum;
import com.likes.common.enums.StatusCode;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.dto.finances.FinancesManagerProductOrderDto;
import com.likes.common.model.dto.member.MemGoldchangeDO;
import com.likes.common.model.vo.finance.FinancesManagerProductOrderVo;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import com.likes.common.mybatis.entity.FinancesManagerProductOrder;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import com.likes.common.mybatis.mapper.FinancesManagerProductOrderMapper;
import com.likes.common.service.finances.IFinancesManagerProductOrderService;
import com.likes.common.service.finances.IFinancesManagerProductService;
import com.likes.common.service.finances.IFinancesManagerProductSettingService;
import com.likes.common.service.member.MemBaseinfoWriteService;
import com.likes.common.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户购买理财订单明细表
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Slf4j
@Service
public class FinancesManagerProductOrderServiceImpl implements IFinancesManagerProductOrderService {

    @Autowired
    private IFinancesManagerProductService iFinancesManagerProductService;
    @Autowired
    private IFinancesManagerProductSettingService iFinancesManagerProductSettingService;
    @Autowired
    private MemBaseinfoWriteService memBaseinfoWriteService;

    @Autowired
    private FinancesManagerProductOrderMapper financesManagerProductOrderMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult findList(Map<String, Object> params, PageBounds pageBounds) {
        List<FinancesManagerProductOrderVo> list =
            financesManagerProductOrderMapper.findList(params, pageBounds.toRowBounds());
        return PageResult.getPageResult(pageBounds, list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo buyFinances(FinancesManagerProductOrderDto financesManagerProductOrderDto, LoginUser loginUser) {
        ResultInfo response = ResultInfo.ok();
        Map<String, Object> params = new HashMap<>();
        params.put("financesProductId", financesManagerProductOrderDto.getFinancesProductId());
        params.put("levelConfigLevel", loginUser.getMemlevel());
        List<FinancesManagerProductSetting> settingList = iFinancesManagerProductSettingService.findList(params);
        for (FinancesManagerProductSetting setting : settingList) {
            //限制用户购买次数（小于0为无限制）
            if (0 <= setting.getBuyNumber()) {
                if (0 == setting.getBuyNumber()) {
                    response = ResultInfo.error(StatusCode.FINANCE_FAILED_1062.getCode(),"用户已经达到最大购买次数" + setting.getBuyNumber());
                    return response;
                } else {
                    Map<String, Object> params1 = new HashMap<>();
                    params1.put("userId", loginUser.getMemid());
                    params1.put("financesProductId", financesManagerProductOrderDto.getFinancesProductId());
                    params1.put("levelConfigLevel", loginUser.getMemlevel());
                    Integer countOrders = financesManagerProductOrderMapper.countOrder(params1);
                    if (countOrders >= setting.getBuyNumber()) {
                        response = ResultInfo.error(StatusCode.FINANCE_FAILED_1062.getCode(),"用户已经达到最大购买次数" + setting.getBuyNumber());
                        return response;
                    }
                }
            }
            FinancesManagerProductOrder financesManagerProductOrder = new FinancesManagerProductOrder();
            BeanUtils.copyProperties(financesManagerProductOrderDto, financesManagerProductOrder);
            financesManagerProductOrder.setCreateBy(loginUser.getAccno());
            Date date = DateUtils.getTimeZone(new Date(), DateUtils.FORMAT_YYYY_MM_DD);
            //理财购买日期
            financesManagerProductOrder.setStartTime(date);
            FinancesManagerProduct financesManagerProduct =
                iFinancesManagerProductService.getById(financesManagerProductOrderDto.getFinancesProductId());
            //理财结算日期
            financesManagerProductOrder.setEndTime(DateUtils.addDateDays(date, financesManagerProduct.getValidDate()));
            BigDecimal incomeAmount = financesManagerProductOrderDto.getBuyAmount()
                .multiply(BigDecimal.valueOf(financesManagerProduct.getIncomeRate()).divide(BigDecimal.valueOf(100)));
            //每日收益金额
            financesManagerProductOrder.setEverydayAmount(
                incomeAmount.divide(BigDecimal.valueOf(financesManagerProduct.getValidDate())));
            //总收益金额
            financesManagerProductOrder.setSumAmount(incomeAmount);
            //会员ID
            financesManagerProductOrder.setUserId(loginUser.getMemid());
            //会员账号
            financesManagerProductOrder.setUserAcct(loginUser.getAccno());
            //会员等级
            financesManagerProductOrder.setLevelConfigLevel(loginUser.getMemlevel());
            financesManagerProductOrder.setFinancesProductStatus(0);
            this.saveOrUpdate(financesManagerProductOrder);

            //用户余额账变
            MemGoldchangeDO balance = new MemGoldchangeDO();
            balance.setOpnote("余额购买理财");
            balance.setQuantity(financesManagerProductOrderDto.getBuyAmount());
            balance.setCreatTime(new Date());
            balance.setAccno(loginUser.getAccno());
            balance.setChangetype(GoldchangeEnum.FINANCES_INTO.getValue());
            memBaseinfoWriteService.updateUserBalance(balance);

        }
        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo getFinances(Long id, LoginUser loginUser) {
        ResultInfo response = ResultInfo.ok();
        FinancesManagerProductOrder financesManagerProductOrder = this.getById(id);
        if (null == financesManagerProductOrder) {
            response = ResultInfo.error(StatusCode.SERVER_ERROR.getCode(),"购买理财订单为空");
            return response;
        } else {
            if (1 == financesManagerProductOrder.getFinancesProductStatus()) {
                response = ResultInfo.error(StatusCode.FINANCE_FAILED_1063.getCode(),"购买理财订单已经提现，请勿重复操作");
                return response;
            }
            financesManagerProductOrder.setUpdateBy(loginUser.getAccno());
            financesManagerProductOrder.setFinancesProductStatus(1);
            this.saveOrUpdate(financesManagerProductOrder);

            //用户余额账变
            MemGoldchangeDO balance = new MemGoldchangeDO();
            balance.setOpnote("余额购买理财提现");
            balance.setQuantity(financesManagerProductOrder.getBuyAmount().add(financesManagerProductOrder.getSumAmount()));
            balance.setUpdateTime(new Date());
            balance.setAccno(financesManagerProductOrder.getUserAcct());
            balance.setChangetype(GoldchangeEnum.FINANCES_OUT.getValue());
            memBaseinfoWriteService.updateUserBalance(balance);
        }
        return response;
    }

    @Override
    public void saveOrUpdate(FinancesManagerProductOrder financesManagerProductOrder) {
        if (ObjectUtil.isNotNull(financesManagerProductOrder.getId())) {
            financesManagerProductOrderMapper.updateByPrimaryKeySelective(financesManagerProductOrder);
        } else {
            financesManagerProductOrderMapper.insertSelective(financesManagerProductOrder);
        }
    }

    @Override
    public FinancesManagerProductOrder getById(Long id) {
        return financesManagerProductOrderMapper.selectByPrimaryKey(id);
    }
}
