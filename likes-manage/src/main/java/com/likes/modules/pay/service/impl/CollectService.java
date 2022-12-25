package com.likes.modules.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.exception.BusinessException;
import com.likes.common.mybatis.entity.pay.PaymentOrderFlow;
import com.likes.common.mybatis.mapper.pay.MerchantPaymentChannelMapper;
import com.likes.common.mybatis.mapper.pay.PaymentOrderFlowMapper;
import com.likes.modules.pay.api.cs.ICSapiService;
import com.likes.common.mybatis.entity.pay.MerchantPaymentChannel;
import com.likes.modules.pay.common.Constants;
import com.likes.modules.pay.service.ICollectService;
import com.likes.modules.pay.util.GetSerialNumUtil;
import com.likes.modules.pay.vo.GetCollectUrlVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CollectService implements ICollectService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ICSapiService icSapiService;
    @Resource
    private MerchantPaymentChannelMapper merchantPaymentChannelMapper;

    @Resource
    private PaymentOrderFlowMapper paymentOrderFlowMapper;
    @Override
    public String getCollectUrl(GetCollectUrlVo getCollectUrlVo)throws Exception {
        String collectUrl = "";
        //獲取支付通道(本平台,開關打卡，失敗次數最小)
        List<MerchantPaymentChannel> paymentChannelList = merchantPaymentChannelMapper.getMerchantPaymentChannelAll(Constants.MERCHAT_ACCT);
        if(null==paymentChannelList || paymentChannelList.size()<0){
            throw new BusinessException("您还未开通支付通道");
        }else {
            for(MerchantPaymentChannel paymentChannel:paymentChannelList) {
                String resultString = "";
                PaymentOrderFlow paymentOrderFlow = new PaymentOrderFlow();
                if ("CS".equals(paymentChannel.getPayChanCode())) {
                    try {

                        paymentOrderFlow.setPayChanCode(paymentChannel.getPayChanCode());//通道代码
                        paymentOrderFlow.setPayChanName(paymentChannel.getPayChanName());//通道名称
                        paymentOrderFlow.setMerchatAcct(Constants.MERCHAT_ACCT);//用户方账号
                        paymentOrderFlow.setMcode(paymentChannel.getMcode());//支付商户唯一标识（平台方）
                        paymentOrderFlow.setPayTypeCode(getCollectUrlVo.getPayType());//支付类型代码
                        paymentOrderFlow.setPayTypeName(getCollectUrlVo.getPayTypeName());//支付类型名称
                        paymentOrderFlow.setMerOrderNo(GetSerialNumUtil.getNum());//	是	String(20)	商户订单号
                        paymentOrderFlow.setOrderPrice(getCollectUrlVo.getOrderPrice());//	是	Int	订单金额
                        paymentOrderFlow.setStatus(3);//	是	Int	订单状态： 1 匹配中 2已匹配 3未匹配
                        paymentOrderFlow.setNotifyStatus(1);//	是	Int	回调状态： 1未回调 2已经回调 3 回调失败
                        paymentOrderFlow.setCreateTime(new Date());//创建时间
                        paymentOrderFlowMapper.insert(paymentOrderFlow);
                        resultString = icSapiService.getToken(getCollectUrlVo.getOrderPrice(), "", getCollectUrlVo.getPayType(), getCollectUrlVo.getPageBackUrl(), paymentChannel.getNotifyUrl());
                    } catch (Exception e) {
                        logger.error("創世支付，获取收银台支付token    (收款接口)失败Exception:{}",e);
                        //记录一次错误，进入下一个支付通道
                        continue;
                    }
                    if(null == resultString || "".equals(resultString)){
                        logger.error("創世支付，获取收银台支付token    (收款接口)失败");
                        //记录一次错误，进入下一个支付通道
                        continue;
                    }else {
                        JSONObject jsonObject = JSONObject.parseObject(resultString);
                        if(null == jsonObject ){
                            logger.error("創世支付，获取收银台支付token    (收款接口)失败resultString{}",resultString);
                            //记录一次错误，进入下一个支付通道
                            continue;
                        }else if ("0".equals(jsonObject.getString("code"))){
                            String dataStr = jsonObject.getString("data");
                            JSONObject dataJson = JSONObject.parseObject(dataStr);
                            String order_no = dataJson.getString("order_no");//	是	String	系统订单号
                            String mer_order_no = dataJson.getString("mer_order_no");//	是	String(20)	商户订单号
                            String token = dataJson.getString("token");//	是	String	重定向支付网页token
                            String pay_url = dataJson.getString("pay_url");//	是	String	收银台地址
                            paymentOrderFlow = paymentOrderFlowMapper.getPaymentOrderFlow(Constants.MERCHAT_ACCT, Constants.PAY_CHAN_CODE,mer_order_no);
                            paymentOrderFlow.setOrderNo(order_no);//	是	String	系统订单号（3方支付返回）
                            paymentOrderFlow.setUpdateTime(new Date());
                            paymentOrderFlowMapper.updateByPrimaryKey(paymentOrderFlow);
                            collectUrl = pay_url+"?token="+token;
                            break;
                        }else {
                            //记录一次错误，进入下一个支付通道
                            continue;
                        }
                    }
                }
            }
        }

        return collectUrl;
    }
}
