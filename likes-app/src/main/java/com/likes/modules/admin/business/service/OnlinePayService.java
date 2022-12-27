package com.likes.modules.admin.business.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.vo.pay.CsPayResultVo;
import com.likes.common.mybatis.entity.MemBaseinfo;
import com.likes.common.mybatis.entity.PayMerchant;
import com.likes.common.mybatis.entity.PayRechargeOrder;
import com.likes.common.mybatis.entity.PaymentOrderFlow;
import com.likes.common.mybatis.mapper.PayRechargeOrderMapper;
import com.likes.common.mybatis.mapper.PaymentOrderFlowMapper;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.util.SnowflakeIdWorker;
import com.likes.modules.admin.pay.service.CsPayService;
import com.likes.modules.admin.pay.common.Constants;
import com.likes.modules.admin.pay.dto.CsPayDTO;
import com.likes.modules.admin.pay.dto.OnlinePayDTO;
import com.likes.modules.admin.pay.service.PayMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class OnlinePayService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private CsPayService csPayService;
    @Resource
    private PayMerchantService payMerchantService;
    @Resource
    private MemBaseinfoService memBaseinfoService;
    @Resource
    private PaymentOrderFlowMapper paymentOrderFlowMapper;
    @Resource
    private PayRechargeOrderMapper payRechargeOrderMapper;


    public CsPayResultVo doOnlinePay(OnlinePayDTO onlinePayDTO, LoginUser loginUser) throws Exception {
        CsPayResultVo csPayResultVo = new CsPayResultVo();
        CsPayDTO csPayDTO = new CsPayDTO();
        //獲取支付通道(本平台,開關打卡，失敗次數最小)
        List<PayMerchant> payMerchantList = payMerchantService.payMerchantList(Constants.PAY_CHAN_CS_CODE);
        if (CollUtil.isEmpty(payMerchantList)) {
            throw new BusinessException("您还未开通支付通道");
        } else {
            for (PayMerchant payMerchant : payMerchantList) {
                String resultString = "";
                PaymentOrderFlow paymentOrderFlow = new PaymentOrderFlow();
                if (Constants.PAY_CHAN_CS_CODE.equals(payMerchant.getMerchantCode())) {
                    try {
                        csPayDTO.setAmount(onlinePayDTO.getOrderPrice());
                        csPayDTO.setNotifyUrl(payMerchant.getNotifyUrl());
                        csPayDTO.setBackUrl(payMerchant.getPageBackUrl());
                        csPayDTO.setOrderNo(SnowflakeIdWorker.generateShortId());
                        System.out.println(csPayDTO.getOrderNo().length());
                        csPayDTO.setPayType("OnlineBank");
                        resultString = csPayService.submitPay(csPayDTO);
                    } catch (Exception e) {
                        logger.error("創世支付，获取收银台支付token    (收款接口)失败Exception:{}", e);
                    }
                    if (null == resultString || "".equals(resultString)) {
                        logger.error("創世支付，获取收银台支付token    (收款接口)失败");
                        //记录一次错误，进入下一个支付通道
                       return csPayResultVo;
                    } else {
                        JSONObject jsonObject = JSONObject.parseObject(resultString);
                        if (null == jsonObject) {
                            logger.error("創世支付，获取收银台支付token    (收款接口)失败resultString{}", resultString);
                            //记录一次错误，进入下一个支付通道
                            return csPayResultVo;
                        } else if ("0".equals(jsonObject.getString("code"))) {
                            String dataStr = jsonObject.getString("data");
                            JSONObject dataJson = JSONObject.parseObject(dataStr);
                            String order_no = dataJson.getString("order_no");//	是	String	系统订单号
                            String mer_order_no = dataJson.getString("mer_order_no");//	是	String(20)	商户订单号
                            String token = dataJson.getString("token");//	是	String	重定向支付网页token
                            String pay_url = dataJson.getString("pay_url");//	是	String	收银台地址
//                            paymentOrderFlow = paymentOrderFlowMapper.getPaymentOrderFlow(Constants.PAY_CHAN_CS_CODE, Constants.PAY_CHAN_CS_CODE, mer_order_no);
//                            paymentOrderFlow.setOrderNo(order_no);//	是	String	系统订单号（3方支付返回）
//                            paymentOrderFlow.setUpdateTime(new Date());
//                            paymentOrderFlowMapper.updateByPrimaryKey(paymentOrderFlow);
                            insertPayment(csPayDTO, loginUser);
                            csPayResultVo.setToken(token);
                            csPayResultVo.setUrl(pay_url + "?token=" + token);
                            break;
                        } else {
                            //记录一次错误，进入下一个支付通道
                            continue;
                        }
                    }
                }
            }
        }
        return csPayResultVo;
    }


    public boolean insertPayment(CsPayDTO csPayDTO, LoginUser loginUser) {
//        MemBaseinfo memBaseinfo = memBaseinfoService.getUserByAccno(loginUser.getAccno());
//        PayRechargeOrder payRechargeOrder = new PayRechargeOrder();
//        payRechargeOrder.setAmount(new BigDecimal(csPayDTO.getAmount()));
//        payRechargeOrder.setAccno(memBaseinfo.getAccno());
//        payRechargeOrder.setTradeId(csPayDTO.getOrderNo());
//        payRechargeOrder.setCreateUser(loginUser.getAcclogin());
//        payRechargeOrder.setCreateTime(new Date());
//        payRechargeOrder.setTradeStatus(0);
//        int row = payRechargeOrderMapper.insertSelective(payRechargeOrder);
//        return row > 0;
        return true;

    }
}