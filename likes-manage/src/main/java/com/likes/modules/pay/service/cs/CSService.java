package com.likes.modules.pay.service.cs;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.mybatis.entity.pay.MerchantPaymentChannel;
import com.likes.common.mybatis.entity.pay.PaymentOrderFlow;
import com.likes.common.mybatis.mapper.pay.MerchantPaymentChannelMapper;
import com.likes.common.mybatis.mapper.pay.PaymentOrderFlowMapper;
import com.likes.modules.pay.common.Constants;
import com.likes.modules.pay.util.DESUtil;
import com.likes.modules.pay.vo.cs.CSCallBackVoPrev;
import com.likes.modules.pay.vo.cs.CSNoticeVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class CSService implements ICSService{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MerchantPaymentChannelMapper merchantPaymentChannelMapper;

    @Resource
    private PaymentOrderFlowMapper paymentOrderFlowMapper;

    /**
     * 六、	异步通知接口
     * @param csNoticeVo
     * @return
     * @throws Exception
     */
    @Override
    public CSCallBackVoPrev csNotice(CSNoticeVo csNoticeVo)throws Exception{
        CSCallBackVoPrev csCallBackVoPrev = new CSCallBackVoPrev();
        csCallBackVoPrev.setCode("0");
        MerchantPaymentChannel paymentChannel = merchantPaymentChannelMapper.getMerchantPaymentChannel(Constants.MERCHAT_ACCT, Constants.PAY_CHAN_CODE);
        if(null==paymentChannel){
            logger.error("創世支付回調接口，您还未开通支付通道");
            csCallBackVoPrev.setCode("2000");
            return csCallBackVoPrev;
        }
        if(null==csNoticeVo || !csNoticeVo.getMcode().equals(paymentChannel.getMcode())){
            logger.error("創世支付回調接口，商户唯一标识不正确,csmcode：{},ptmcode：{},",csNoticeVo.getMcode(),paymentChannel.getMcode());
            csCallBackVoPrev.setCode("2000");
            return csCallBackVoPrev;
        }
        //解密
        String params = DESUtil.decrypt(csNoticeVo.getParams(),paymentChannel.getMkey());
        try {
            JSONObject jsonObject = JSONObject.parseObject(params);
            String business_type = jsonObject.getString("business_type");//	是	String(5)	业务编码	10003
            String mer_order_no = jsonObject.getString("mer_order_no");//	是	String(20)	商户订单号
            String order_no = jsonObject.getString("order_no");//	是	String	系统订单号
            Integer order_price = jsonObject.getInteger("order_price");//	是	Int	订单金额
            Integer status = jsonObject.getInteger("status");//	是	Int	支付状态 2已匹配	2
            String pay_time = jsonObject.getString("pay_time");//	否	String	yyyyMMddHHmmss
            Integer timestamp = jsonObject.getInteger("timestamp");//	是	Int(10)	十位时间戳
            PaymentOrderFlow paymentOrderFlow = paymentOrderFlowMapper.getPaymentOrderFlow(Constants.MERCHAT_ACCT, Constants.PAY_CHAN_CODE,mer_order_no);
            paymentOrderFlow.setOrderNo(order_no);
            paymentOrderFlow.setPayTime(pay_time);
            paymentOrderFlow.setStatus(2);
            paymentOrderFlow.setNotifyStatus(2);
            paymentOrderFlow.setUpdateTime(new Date());
            paymentOrderFlowMapper.updateByPrimaryKey(paymentOrderFlow);

        }catch (Exception e) {
            logger.error("創世支付回調接口，解密失败,params:{}",params);
            csCallBackVoPrev.setCode("9999");
            return csCallBackVoPrev;
        }
        return csCallBackVoPrev;
    }

}
