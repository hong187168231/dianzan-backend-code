package com.likes.modules.admin.pay.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.xspec.S;
import com.likes.common.enums.GoldchangeEnum;
import com.likes.common.model.dto.member.MemGoldchangeDO;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.PayRechargeOrderMapper;
import com.likes.common.mybatis.mapper.PaymentOrderFlowMapper;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemBaseinfoWriteService;
import com.likes.common.service.money.TraOrderinfomService;
import com.likes.common.util.PaySignUtil;
import com.likes.common.util.SnowflakeIdWorker;
import com.likes.modules.admin.pay.service.CsPayService;
import com.likes.modules.admin.pay.common.Constants;
import com.likes.modules.admin.pay.dto.CsPayDTO;
import com.likes.modules.admin.pay.dto.cs.CSCallBackVoPrev;
import com.likes.modules.admin.pay.dto.cs.CsPayNoticeReq;
import com.likes.modules.admin.pay.service.PayMerchantService;
import com.likes.modules.admin.pay.util.DESUtil;
import com.likes.modules.admin.pay.util.HttpClient4Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

import static com.likes.common.util.ViewUtil.getTradeOffAmount;

@Service
@Slf4j
@Transactional
public class CsPayServiceImpl implements CsPayService {

    @Resource
    private MemBaseinfoService memBaseinfoService;

    @Resource
    private TraOrderinfomService traOrderinfomService;

    @Resource
    private MemBaseinfoWriteService memBaseinfoWriteService;

    @Resource
    private PayRechargeOrderMapper payRechargeOrderMapper;

    public static String key = "d2fb04d8103613b8d391ebc2d34228bd";
    public static String mcode = "gxtnxaciwhdg";
    public static String apiUrl = "http://api.vnhotpay.com/japi/index";

    public static void main(String[] args) {
        try {
//            long timestamp = System.currentTimeMillis() / 1000;
//            Map<String, Object> payMap = new TreeMap<>();
//            payMap.put("business_type", "20011");
////            payMap.put("bank_id", "ACB");
////            payMap.put("pay_type", "OnlineBank");
//            payMap.put("mer_order_no", SnowflakeIdWorker.generateShortId());
//            payMap.put("order_price", 50000);
//            payMap.put("page_back_url", "http://www.baidu.com");
//            payMap.put("notify_url", "http://www.baidu.com");
//            payMap.put("timestamp", timestamp);
//
//            String sign = PaySignUtil.getSignLower(payMap,key);
//            log.info("CS获取收银台支付token    (收款接口)输入加密前,sign：{}", sign);
//
//            log.info("铭文"+ JSON.toJSONString(payMap));
//            payMap.put("sign",sign);
//
//            String params = base642(DESUtil.encrypt(JSONObject.toJSONString(payMap), key));
//            Map<String, String> reqParams = new HashMap<>();
//            reqParams.put("mcode", mcode);
//            reqParams.put("params", params);
//            log.info("CS获取收银台支付token    (收款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(reqParams));
//            String resultString = "";
//            try {
//                resultString = HttpClient4Util.doPost(apiUrl, JSONObject.toJSONString(reqParams));
//                log.info("CS获取收银台支付token    (收款接口)返回,result：{}", resultString);
//            } catch (Exception e) {
//                log.info("CS获取收银台支付token    (收款接口)請求Exception：{}", e);
//                throw e;
//            }
//            String str = "c1ZnS0MyaHNmRXY0NElBNmpsMmJTSTh6Ym9OanRaQzlvSXZkdU5hOWpBWWZXTHpKcVdtMytxZDZNNFRBaGdHZGZ4a09ycTdHV3VLZ2RQblZwNlJTTktoRFhsa0d2WEZKcDN5c2ZJWlFDNVRaZkViSEl5Uk1nSUF4aXhaNitHKytFWnM3UGljN1BVbnZzODhGZ2tsbWZjUWsrellZR3hIemJaWWFmYXU4K3ZYZVk5MDdCaTBFeFpzbDhhcWN2NStSQWFuZE9LYzZiamxsMkhRQmJuclJzdnpXRy8xNEVwazNLTHQxMDV6MnN1dnEzZ2dRQ3p3aGYxZGd0K0tyaEFFalp3SXcxakI5dFBPRklnWHNFYnBzVi80dVlCMk5pUWxkUEdyQ2h6TEhyN1g5STd4MDBVK3g1QT09";
//           String inParams = DESUtil.decrypt(base64Decoder(str), "d2fb04d8103613b8d391ebc2d34228bd");
            String deParams = "{\"order_no\":\"INC2022122919444111933000\",\"business_type\":\"10003\",\"order_price\":16888.000,\"mer_order_no\":\"0375206448827328\",\"status\":\"2\",\"pay_time\":\"20221229194833\",\"timestamp\":1672318116}";
            String sign = "511e1e421f8a6138bc03cdd006db087f";
            JSONObject jsonObject = JSONObject.parseObject(deParams);
            String business_type = jsonObject.getString("business_type");//	是	String(5)	业务编码	10003
            String mer_order_no = jsonObject.getString("mer_order_no");//	是	String(20)	商户订单号
            String order_no = jsonObject.getString("order_no");//	是	String	系统订单号
            String order_price = jsonObject.getString("order_price");//	是	Int	订单金额
            Integer status = jsonObject.getInteger("status");//	是	Int	支付状态 2已匹配	2
            String pay_time = jsonObject.getString("pay_time");//	否	String	yyyyMMddHHmmss
            Integer timestamp = jsonObject.getInteger("timestamp");//	是	Int(10)	十位时间戳
//            String sign = jsonObject.getString("sign");//	否	String	yyyyMMddHHmmss


            Map<String, Object> noticeMap = new TreeMap<>();
            noticeMap.put("order_no", order_no);
            noticeMap.put("business_type", business_type);
            noticeMap.put("order_price", order_price);
            noticeMap.put("mer_order_no", mer_order_no);
            noticeMap.put("status", status);
            noticeMap.put("pay_time", pay_time);
            noticeMap.put("timestamp", timestamp);

            String likesSign = PaySignUtil.getSignLower(noticeMap, key);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
            //处理异常
        }

    }

    private String base64(String result) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(result.getBytes());
    }

    private static String base64Decoder(String result) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(decoder.decodeBuffer(result), "utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String base642(String result) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(result.getBytes());
    }


    @Override
    public String submitPay(CsPayDTO csPayDTO) throws Exception {

        long timestamp = System.currentTimeMillis() / 1000;


        Map<String, Object> payMap = new TreeMap<>();
        payMap.put("business_type", "20011");
//        payMap.put("bank_id", "ACB");
//        payMap.put("pay_type", csPayDTO.getPayType());
        payMap.put("mer_order_no", csPayDTO.getOrderNo());
        payMap.put("order_price", csPayDTO.getAmount());
        payMap.put("page_back_url", "http://www.baidu.com");
        payMap.put("notify_url", csPayDTO.getNotifyUrl());
        payMap.put("timestamp", timestamp);

        String sign = PaySignUtil.getSignLower(payMap, key);
        log.info("CS获取收银台支付token    (收款接口)输入加密前,sign：{}", sign);

        log.info("铭文" + JSON.toJSONString(payMap));
        payMap.put("sign", sign);

        String params = base64(DESUtil.encrypt(JSONObject.toJSONString(payMap), key));
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("mcode", mcode);
        reqParams.put("params", params);
        log.info("CS获取收银台支付token    (收款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(reqParams));
        String resultString = "";
        try {
            resultString = HttpClient4Util.doPost(apiUrl, JSONObject.toJSONString(reqParams));
            log.info("CS获取收银台支付token    (收款接口)返回,result：{}", resultString);
        } catch (Exception e) {
            log.info("CS获取收银台支付token    (收款接口)請求Exception：{}", e);
            throw e;
        }
        return resultString;
    }

    //七、	订单查询接口    (收款接口)
//    @Override
//    public JSONObject queryOrder(String orderNo) throws Exception {
//
//        CSgetOrderVo cSgetOrderVo = new CSgetOrderVo();
//        cSgetOrderVo.setBusiness_type("10004");//	是	String(5)	业务编码
//        cSgetOrderVo.setMer_order_no(orderNo);//	是	String(20)	商户订单号
//        long time11 = System.currentTimeMillis() / 1000;
//        cSgetOrderVo.setTimestamp(time11);//	是	Int(10)	十位时间戳
//        String sign = this.getParameter(this.getDeclaredFields(cSgetOrderVo), key);
//        log.info("CS订单查询接口    (收款接口)输入加密前,sign：{}", sign);
//        cSgetOrderVo.setSign(DigestUtils.md5Hex(sign));//	是	String(32)	签名字符(查看sign签名说明)
//        log.info("CS订单查询接口    (收款接口)输入加密前,params：{}", JSONObject.toJSONString(cSgetOrderVo));
//
//
//        String paramsStr = JSONObject.toJSONString(cSgetOrderVo);
//        String params = this.base64(DESUtil.encrypt(paramsStr, key));//加密参数
//        Map<String, String> trr = new HashMap<>();
//        trr.put("mcode", mcode);//商户唯一标识
//        trr.put("params", params);
//        log.info("C订单查询接口    (收款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(trr));
//        try {
//            String resultString = HttpClient4Util.doPost(apiUrl, trr);
//            log.info("CS订单查询接口    (收款接口)返回,result：{}", resultString);
//        } catch (Exception e) {
//            log.info("CS订单查询接口    (收款接口)請求Exception：{}", e);
//            throw e;
//        }
//        return null;
//    }


    @Resource
    private PayMerchantService payMerchantService;


    /**
     * 六、	异步通知接口
     *
     * @return
     * @throws Exception
     */
    @Override
    public CSCallBackVoPrev callbackNotice(CsPayNoticeReq csPayNoticeReq) throws Exception {
        CSCallBackVoPrev csCallBackVoPrev = new CSCallBackVoPrev();
        csCallBackVoPrev.setCode("success");
        PayMerchant payMerchant = payMerchantService.getMerchant(Constants.PAY_CHAN_CS_CODE);
        if (ObjectUtil.isNull(payMerchant)) {
            log.error("创世支付回调接口，您还未开通支付通道");
            csCallBackVoPrev.setCode("2000");
            return csCallBackVoPrev;
        }
        if (ObjectUtil.isNull(csPayNoticeReq) || !csPayNoticeReq.getMcode().equals("gxtnxaciwhdg")) {
            log.error("创世支付回调接口，商户唯一标识不正确,csmcode：{},ptmcode：{},", csPayNoticeReq.getMcode(), payMerchant.getMerchantCode());
            csCallBackVoPrev.setCode("2000");
            return csCallBackVoPrev;
        }
        //解密
        String params = DESUtil.decrypt(base64Decoder(csPayNoticeReq.getParams()), payMerchant.getMerchantKey());
        try {
            JSONObject jsonObject = JSONObject.parseObject(params);
            String business_type = jsonObject.getString("business_type");//	是	String(5)	业务编码	10003
            String mer_order_no = jsonObject.getString("mer_order_no");//	是	String(20)	商户订单号
            String order_no = jsonObject.getString("order_no");//	是	String	系统订单号
            String order_price = jsonObject.getString("order_price");//	是	Int	订单金额
            Integer status = jsonObject.getInteger("status");//	是	Int	支付状态 2已匹配	2
            String pay_time = jsonObject.getString("pay_time");//	否	String	yyyyMMddHHmmss
            Integer timestamp = jsonObject.getInteger("timestamp");//	是	Int(10)	十位时间戳
            String sign = jsonObject.getString("sign");//	否	String	yyyyMMddHHmmss

            Map<String, Object> noticeMap = new TreeMap<>();
            noticeMap.put("business_type", business_type);
            noticeMap.put("mer_order_no", mer_order_no);
            noticeMap.put("order_no", order_no);
            noticeMap.put("order_price", order_price);
            noticeMap.put("status", status);
            noticeMap.put("pay_time", pay_time);
            noticeMap.put("timestamp", timestamp);
            String likesSign = PaySignUtil.getSignLower(noticeMap, key);
            if (!sign.equals(likesSign)) {
                log.error("创世支付回调接口，签名错误============{},", JSON.toJSONString(csPayNoticeReq));
                csCallBackVoPrev.setCode("1001");
                return csCallBackVoPrev;
            }
            PayRechargeOrder rechargeParam = new PayRechargeOrder();
            rechargeParam.setTradeId(mer_order_no);
            PayRechargeOrder rechargeOrder = payRechargeOrderMapper.selectOne(rechargeParam);
            if (ObjectUtil.isNull(rechargeOrder)) {
                csCallBackVoPrev.setCode("1002");
                log.error("商户订单号不存在===[{}]", order_no);
                return csCallBackVoPrev;
            }
            if (!rechargeOrder.getOrderNo().equals(order_no)) {
                csCallBackVoPrev.setCode("1002");
                log.error("CS平台订单号和商户订单号不匹配===[{}]", JSON.toJSONString(csPayNoticeReq));
                return csCallBackVoPrev;
            }
            if (rechargeOrder.getTradeStatus() != 0) {
                csCallBackVoPrev.setCode("2000");
                log.error("订单号已经处理===[{}]", order_no);
                return csCallBackVoPrev;
            }
            if (rechargeOrder.getOrderStatus() == 2) {
                csCallBackVoPrev.setCode("2000");
                log.error("订单已经充值成功无需处理===[{}]", order_no);
                return csCallBackVoPrev;
            }
            rechargeOrder.setUpdateTime(new Date());
            rechargeOrder.setTradeStatus(1);
            rechargeOrder.setOrderStatus(2);
            payRechargeOrderMapper.updateByPrimaryKeySelective(rechargeOrder);
            createRechargeOrder(rechargeOrder);
        } catch (Exception e) {
            log.error("创世支付回调发生错误,错误信息 ===== params:{}", params);
            csCallBackVoPrev.setCode("9999");
            return csCallBackVoPrev;
        }
        return csCallBackVoPrev;
    }


    private boolean createRechargeOrder(PayRechargeOrder payRechargeOrder) {
        MemBaseinfo memBaseinfo = memBaseinfoService.getUserByAccno(payRechargeOrder.getAccno());
        TraOrderinfom traOrderinfom = new TraOrderinfom();
        //给会员代充
        traOrderinfom.setOrdertype(com.likes.common.constant.Constants.ORDERTYPE1);
        traOrderinfom.setOrderno(payRechargeOrder.getTradeId());
        traOrderinfom.setAccno(memBaseinfo.getAccno());
        traOrderinfom.setOrderdate(new Date());

        //实际到账金额（赠送后的金额）
        traOrderinfom.setSumamt(payRechargeOrder.getAmount());
        traOrderinfom.setRealamt(payRechargeOrder.getAmount());
        traOrderinfom.setIsinvoice(9);
        traOrderinfom.setOrderstatus(com.likes.common.constant.Constants.ORDER_ORD08);
        traOrderinfom.setAccountstatus(com.likes.common.constant.Constants.ORDER_ACC04);
        traOrderinfom.setOrdernote("用户[" + memBaseinfo.getEmail() + "]css 充值: ");
        traOrderinfom.setPaydate(new Date());
        int i = traOrderinfomService.insertOrder(traOrderinfom);
        if (i < 0) {
            log.error("cs 充值回调入库失败 == accLogin={}", memBaseinfo.getAccno());
            return false;
        }
        updateChangeBalance(traOrderinfom, memBaseinfo);
        return true;
    }

    private void updateChangeBalance(TraOrderinfom traOrderinfom, MemBaseinfo memBaseinfo) {
        MemGoldchangeDO memGoldchangeDO = new MemGoldchangeDO();
        memGoldchangeDO.setRefid(traOrderinfom.getOrderid());
        memGoldchangeDO.setUserId(memBaseinfo.getMemid().intValue());
        memGoldchangeDO.setShowChange(getTradeOffAmount(traOrderinfom.getSumamt()));
        memGoldchangeDO.setCreateUser(memBaseinfo.getAccno());
        memGoldchangeDO.setUpdateUser(memBaseinfo.getAccno());
        memGoldchangeDO.setQuantity(traOrderinfom.getSumamt());
        memGoldchangeDO.setAmount(traOrderinfom.getSumamt());
        memGoldchangeDO.setPayAmount(traOrderinfom.getSumamt());
        memGoldchangeDO.setChangetype(GoldchangeEnum.RECHARGE.getValue());
        memBaseinfoWriteService.updateUserBalance(memGoldchangeDO);
    }


}