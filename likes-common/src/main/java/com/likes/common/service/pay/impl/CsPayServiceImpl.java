package com.likes.common.service.pay.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.likes.common.constant.Constants;
import com.likes.common.constant.ModuleConstant;
import com.likes.common.constant.RedisKeys;
import com.likes.common.enums.AssetTypeEnum;
import com.likes.common.enums.GoldchangeEnum;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.dto.member.MemGoldchangeDO;
import com.likes.common.model.dto.pay.CSCallBackVoPrev;
import com.likes.common.model.dto.pay.CsPayDTO;
import com.likes.common.model.dto.pay.CsPayNoticeReq;
import com.likes.common.model.dto.pay.CsPaymentDTO;
import com.likes.common.model.request.IncarnateOrderReq;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.CsCallBackRecordMapper;
import com.likes.common.mybatis.mapper.PayRechargeOrderMapper;
import com.likes.common.service.common.CommonService;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemBaseinfoWriteService;
import com.likes.common.service.money.*;
import com.likes.common.service.sys.InfSysremindinfoService;
import com.likes.common.util.CommonUtils;
import com.likes.common.util.DateUtils;
import com.likes.common.util.PaySignUtil;
import com.likes.common.util.redis.RedisBusinessUtil;
import com.likes.common.service.pay.CsPayService;
import com.likes.common.service.pay.PayMerchantService;
import com.likes.common.util.cs.DESUtil;
import com.likes.common.util.cs.HttpClient4Util;
import com.likes.common.util.redis.RedisLock;
import com.likes.common.util.uploadFile.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.likes.common.util.ViewUtil.getTradeOffAmount;

@Service
@Slf4j
@Transactional
public class CsPayServiceImpl implements CsPayService {

    private static final ExecutorService taskCachedThreadPool = CommonUtils.getMaxThreadPoolExecutor();

    @Resource
    private MemBaseinfoService memBaseinfoService;
    @Resource
    private CommonService commonService;
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private TraOrderinfomService traOrderinfomService;
    @Resource
    private TraApplycashService traApplycashMapperService;
    @Resource
    private MemBaseinfoWriteService memBaseinfoWriteService;
    @Resource
    private TraApplyauditService traApplyauditMapperService;
    @Resource
    private PayRechargeOrderMapper payRechargeOrderMapper;
    @Resource
    private TraOrdertrackingService traOrdertrackingMapperService;
    @Resource
    private MemGoldchangeService memGoldchangeService;
    @Resource
    private TraOrderinfomService traOrderinfomMapperService;

    @Resource
    private InfSysremindinfoService infSysremindinfoService;

    @Resource
    private CsCallBackRecordMapper csCallBackRecordMapper;

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
//            String deParams = "{\"order_no\":\"INC2022122919444111933000\",\"business_type\":\"10003\",\"order_price\":16888.000,\"mer_order_no\":\"0375206448827328\",\"status\":\"2\",\"pay_time\":\"20221229194833\",\"timestamp\":1672318116}";
//            String sign = "511e1e421f8a6138bc03cdd006db087f";
//            JSONObject jsonObject = JSONObject.parseObject(deParams);
//            String business_type = jsonObject.getString("business_type");//	是	String(5)	业务编码	10003
//            String mer_order_no = jsonObject.getString("mer_order_no");//	是	String(20)	商户订单号
//            String order_no = jsonObject.getString("order_no");//	是	String	系统订单号
//            String order_price = jsonObject.getString("order_price");//	是	Int	订单金额
//            Integer status = jsonObject.getInteger("status");//	是	Int	支付状态 2已匹配	2
//            String pay_time = jsonObject.getString("pay_time");//	否	String	yyyyMMddHHmmss
//            Integer timestamp = jsonObject.getInteger("timestamp");//	是	Int(10)	十位时间戳
////            String sign = jsonObject.getString("sign");//	否	String	yyyyMMddHHmmss
//
//
//            Map<String, Object> noticeMap = new TreeMap<>();
//            noticeMap.put("order_no", order_no);
//            noticeMap.put("business_type", business_type);
//            noticeMap.put("order_price", order_price);
//            noticeMap.put("mer_order_no", mer_order_no);
//            noticeMap.put("status", status);
//            noticeMap.put("pay_time", pay_time);
//            noticeMap.put("timestamp", timestamp);
//
//            String likesSign = PaySignUtil.getSignLower(noticeMap, key);
//            return;

            long timestamp = System.currentTimeMillis() / 1000;
            Map<String, Object> noticeMap = new TreeMap<>();
            noticeMap.put("order_no", "INC2022123016062821172723");
            noticeMap.put("business_type", "10003");
            noticeMap.put("order_price", "50001.000");
            noticeMap.put("mer_order_no", "0375356579075008");
            noticeMap.put("status", 2);
            noticeMap.put("pay_time", "20221229194833");
            noticeMap.put("timestamp", timestamp);

            String sign = PaySignUtil.getSignLower(noticeMap, key);
            log.info("CS获取收银台支付token    (收款接口)输入加密前,sign：{}", sign);
            noticeMap.put("sign", sign);

            String params = base642(DESUtil.encrypt(JSONObject.toJSONString(noticeMap), key));
            System.out.println(params);

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
    @Transactional
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
            if (null != business_type && !"".equals(business_type)) {
                if ("10003".equals(business_type)) {//收款接口回调
                    return this.callbackNotice10003(jsonObject);
                } else if ("30003".equals(business_type)) {//付款接口回调
                    return this.callbackNotice30003(jsonObject);
                } else {
                    log.error("创世支付回调发生错误,错误信息 ===== 业务编码为：{}", business_type);
                    csCallBackVoPrev.setCode("9999");
                    return csCallBackVoPrev;
                }
            } else {
                log.error("创世支付回调发生错误,错误信息 ===== 业务编码为空");
                csCallBackVoPrev.setCode("9999");
                return csCallBackVoPrev;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("创世支付回调发生错误,错误信息 ===== params:{}", params);
            csCallBackVoPrev.setCode("9999");
            return csCallBackVoPrev;
        }
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

    /**
     * 六、	异步通知接口（收款接口）
     *
     * @return
     * @throws Exception
     */
    public CSCallBackVoPrev callbackNotice10003(JSONObject jsonObject) throws Exception {
        CSCallBackVoPrev csCallBackVoPrev = new CSCallBackVoPrev();
        csCallBackVoPrev.setCode("success");
        try {
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
                log.error("创世支付回调接口(收款接口)，签名错误============{},", JSON.toJSONString(noticeMap));
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
                log.error("CS平台订单号和商户订单号不匹配===[{}]", JSON.toJSONString(noticeMap));
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
            log.error("创世支付回调发生错误(付款接口),错误信息 ===== params:{}", jsonObject.toJSONString());
            csCallBackVoPrev.setCode("9999");
            return csCallBackVoPrev;
        }
        return csCallBackVoPrev;
    }

    //===========================付款接口==========================================================

    /**
     * 四、	付款接口
     *
     * @param csPaymentDTO
     * @return
     * @throws Exception
     */
    @Override
    public String submitWithdraw(CsPaymentDTO csPaymentDTO) {
        long timestamp = System.currentTimeMillis() / 1000;
        Map<String, Object> payMap = new TreeMap<>();
        payMap.put("business_type", "30001");
        payMap.put("mer_order_no", csPaymentDTO.getOrderNo());
        payMap.put("order_price", csPaymentDTO.getAmount());
        payMap.put("notify_url", csPaymentDTO.getNotifyUrl());
        payMap.put("bank_id", csPaymentDTO.getBankId());
        payMap.put("bene_no", csPaymentDTO.getBeneNo());
        payMap.put("payee", csPaymentDTO.getPayee());
        payMap.put("timestamp", timestamp);
        log.info("CS付款接口请求参数", JSON.toJSONString(payMap));
        String sign = PaySignUtil.getSignLower(payMap, key);
        log.info("CS付款接口    (付款接口)输入加密前,sign：{}", sign);
        payMap.put("sign", sign);
        String params = base64(DESUtil.encrypt(JSONObject.toJSONString(payMap), key));
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("mcode", mcode);
        reqParams.put("params", params);
        log.info("CS付款接口   (付款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(reqParams));
        String resultString = "";
        try {
            resultString = HttpClient4Util.doPost(apiUrl, JSONObject.toJSONString(reqParams));
            log.info("CS付款接口    (付款接口)返回,result：{}", resultString);
        } catch (Exception e) {
            log.info("CS付款接口    (付款接口)請求Exception：{}", e);
            return "";
        }
        return resultString;
    }


    //七、	订单查询接口    (付款接口)
//    @Override
//    public JSONObject queryOrder30002(String orderNo) throws Exception {
//
//        CSgetOrderVo cSgetOrderVo = new CSgetOrderVo();
//        cSgetOrderVo.setBusiness_type("30002");//	是	String(5)	业务编码 30002
//        cSgetOrderVo.setMer_order_no(orderNo);//	是	String(20)	商户订单号
//        long time11 = System.currentTimeMillis() / 1000;
//        cSgetOrderVo.setTimestamp(time11);//	是	Int(10)	十位时间戳
//        String sign = this.getParameter(this.getDeclaredFields(cSgetOrderVo), key);
//        log.info("CS订单查询接口    (付款接口)输入加密前,sign：{}", sign);
//        cSgetOrderVo.setSign(DigestUtils.md5Hex(sign));//	是	String(32)	签名字符(查看sign签名说明)
//        log.info("CS订单查询接口    (付款接口)输入加密前,params：{}", JSONObject.toJSONString(cSgetOrderVo));
//
//
//        String paramsStr = JSONObject.toJSONString(cSgetOrderVo);
//        String params = this.base64(DESUtil.encrypt(paramsStr, key));//加密参数
//        Map<String, String> trr = new HashMap<>();
//        trr.put("mcode", mcode);//商户唯一标识
//        trr.put("params", params);
//        log.info("C订单查询接口    (付款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(trr));
//        try {
//            String resultString = HttpClient4Util.doPost(apiUrl, trr);
//            log.info("CS订单查询接口    (付款接口)返回,result：{}", resultString);
//        } catch (Exception e) {
//            log.info("CS订单查询接口    (付款接口)請求Exception：{}", e);
//            throw e;
//        }
//        return null;
//    }

    /**
     * 七、	商户余额查询接口
     *
     * @return
     * @throws Exception
     */
    @Override
    public String getCSAccountPrice() throws Exception {

        long timestamp = System.currentTimeMillis() / 1000;


        Map<String, Object> payMap = new TreeMap<>();
        payMap.put("business_type", "30004");
        payMap.put("timestamp", timestamp);

        String sign = PaySignUtil.getSignLower(payMap, key);
        log.info("CS商户余额查询接口    (付款接口)输入加密前,sign：{}", sign);

        payMap.put("sign", sign);

        String params = base64(DESUtil.encrypt(JSONObject.toJSONString(payMap), key));
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("mcode", mcode);
        reqParams.put("params", params);
        log.info("CS商户余额查询接口   (付款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl, JSONObject.toJSONString(reqParams));
        String resultString = "";
        try {
            resultString = HttpClient4Util.doPost(apiUrl, JSONObject.toJSONString(reqParams));
            log.info("CS商户余额查询接口口    (付款接口)返回,result：{}", resultString);
        } catch (Exception e) {
            log.info("CS商户余额查询接口    (付款接口)請求Exception：{}", e);
            throw e;
        }
        return resultString;
    }

    /**
     * 六、	异步通知接口（付款接口）
     *
     * @return
     * @throws Exception
     */
    public CSCallBackVoPrev callbackNotice30003(JSONObject jsonObject) {
        CSCallBackVoPrev csCallBackVoPrev = new CSCallBackVoPrev();
        csCallBackVoPrev.setCode("success");

        String business_type = jsonObject.getString("business_type");//	是	String(5)	业务编码	30003
        String mer_order_no = jsonObject.getString("mer_order_no");//	是	String(20)	商户订单号
        String msg = jsonObject.getString("msg");
        String pay_account_no = jsonObject.getString("pay_account_no");
        String order_no = jsonObject.getString("order_no");
        String order_price = jsonObject.getString("order_price");//	是	Int	订单金额
        Integer status = jsonObject.getInteger("status");//	是	Int	支付状态 2 执行失败 3 执行成功
        String bene_no = jsonObject.getString("bene_no");//		是	String	收款账号/卡号
        String payee = jsonObject.getString("payee");//		是	String	收款人姓名(urlencode编码)
        String bank_id = jsonObject.getString("bank_id");//		是	String	收款银行ID
        String pay_time = jsonObject.getString("pay_time");//	否	String	yyyyMMddHHmmss
        Integer timestamp = jsonObject.getInteger("timestamp");//	是	Int(10)	十位时间戳
        String sign = jsonObject.getString("sign");//	否	String	yyyyMMddHHmmss

        CsCallBackRecord csCallBackRecord = new CsCallBackRecord();
        csCallBackRecord.setId(UUIDUtils.getUUID());
        csCallBackRecord.setParam(JSON.toJSONString(jsonObject));
        csCallBackRecord.setOrderNo(mer_order_no);
        csCallBackRecord.setCreateTime(new Date());

        taskCachedThreadPool.execute(() -> ybError(csCallBackRecord));

        Map<String, Object> noticeMap = new TreeMap<>();
        noticeMap.put("business_type", business_type);
        noticeMap.put("mer_order_no", mer_order_no);
        noticeMap.put("order_no", order_no);
        noticeMap.put("msg", msg);
        if (StringUtils.isNotBlank(pay_account_no)) {
            noticeMap.put("pay_account_no", pay_account_no);
        }
        noticeMap.put("order_price", order_price);
        noticeMap.put("status", status);
        noticeMap.put("bene_no", bene_no);
        noticeMap.put("payee", payee);
        noticeMap.put("bank_id", bank_id);
        noticeMap.put("pay_time", pay_time);
        noticeMap.put("timestamp", timestamp);
        String likesSign = PaySignUtil.getSignLower(noticeMap, key);
        if (!sign.equals(likesSign)) {
            log.error("创世支付回调接口(付款接口)，签名错误============{},", JSON.toJSONString(noticeMap));
            csCallBackVoPrev.setCode("1001");
            return csCallBackVoPrev;
        }
        TraOrderinfom traOrderinfom = traOrderinfomMapperService.findByOrderno(mer_order_no);
        if (traOrderinfom == null) {
            log.error("订单不存在");
            throw new BusinessException("订单不存在");
        }
        if (!(traOrderinfom.getRealamt().intValue() == new BigDecimal(order_price).intValue())) {
            throw new BusinessException("金额不一致");
        }

        if (!Constants.ORDER_ORD07.equals(traOrderinfom.getOrderstatus())) {
            log.error("订单状态不为提现处理中");
            throw new BusinessException("订单状态不为提现处理中");
        }
        // 获取订单对应的申请提现
        TraApplycash traApplycash = traApplycashMapperService.findByOrderid(traOrderinfom.getOrderid());
        if (traApplycash == null) {
            throw new BusinessException("不存在提现申请");
        }
        if (Constants.APYCSTATUS2 != traApplycash.getApycstatus()) {
            throw new BusinessException("状态不为提现处理中");
        }
        if (Constants.ORDER_ORD12.equals(traOrderinfom.getOrderstatus())) {
            throw new BusinessException("订单状态已提现");
        }
        // 用户
        MemBaseinfo zhubo = memBaseinfoService.getUserByAccno(traOrderinfom.getAccno());
        if (zhubo == null) {
            log.error("用户不存在");
            throw new BusinessException("用户不存在");
        }
        if (status != 3) {
            failedOrder(traOrderinfom, traApplycash, msg);
            return csCallBackVoPrev;
        }
        // 申请状态 1提交申请 2提现处理中 3已经失败 4已打款 8已到账 9已取消
        traApplycash.setApycstatus(com.likes.common.constant.Constants.APYCSTATUS8);
        traApplycash.setApycamt(new BigDecimal(order_price));//打款金额
        traApplycash.setOrderno(order_no);
        // 提现申请
        traApplycashMapperService.updateIncarnateConfirmApplycash(traApplycash);

        // 订单
        traOrderinfom.setOrderstatus(Constants.ORDER_ORD12);
        traOrderinfom.setPaydate(new Date());
        traOrderinfom.setUpdateUser("udun");
        traOrderinfom.setOrdernote("cs " + msg);
        int i = traOrderinfomMapperService.udunUpdateIncarnateConfirmOrder(traOrderinfom);
        if (i > 0) {
            // 提现数据修改
            traApplycash.setPaydate(new Date());
            traApplycash.setApycstatus(Constants.APYCSTATUS4);
            traApplycash.setUpdateUser("udun");
            // 提现申请
            int k = traApplycashMapperService.udunUpdateIncarnateConfirmApplycash(traApplycash);
            if (!(k > 0)) {
                throw new BusinessException("提现状态不为提现处理中");
            }
            // 修改 金币变化记录表 将用户申请提现的记录 改为 状态已提现
            MemGoldchange paramMemGoldchange = new MemGoldchange();
            paramMemGoldchange.setAccno(traOrderinfom.getAccno());
            paramMemGoldchange.setChangetype(GoldchangeEnum.WITHDRAWAL_APPLY.getValue());
            paramMemGoldchange.setRefid(traOrderinfom.getOrderid());
            paramMemGoldchange.setUpdateUser(traOrderinfom.getAccno());
            paramMemGoldchange.setOpnote("提现完成");
            paramMemGoldchange.setSource(traOrderinfom.getSource());

            int mg = memGoldchangeService.updateZhuboTixian(paramMemGoldchange);
            if (!(mg > 0)) {
                throw new BusinessException(StatusCode.LIVE_ERROR_115.getCode(), "处理用户提现失败");
            }
            // 修改 对应 充值订单的 结算状态
            Long apyid = traApplycash.getApycid();
            List<TraApplyaudit> traApplyaudits = traApplyauditMapperService.getListById(apyid);
            if (CollectionUtils.isNotEmpty(traApplyaudits)) {
                List<Long> orderids = traApplyaudits.stream().map(ob -> ob.getOrderid()).collect(Collectors.toList());
                traOrderinfomMapperService.doJiesuanOrder(orderids);
            }
            MemBaseinfoExample membaseinfoExample = new MemBaseinfoExample();
            membaseinfoExample.createCriteria().andAccnoEqualTo(traOrderinfom.getAccno());
            MemBaseinfo membaseinfo = memBaseinfoService.selectOneByExample(membaseinfoExample);
            // 设置提现金额
            membaseinfo.setWithdrawalAmount(getTradeOffAmount(traOrderinfom.getSumamt()));
            // 设置首次提现金额
            if (membaseinfo.getWithdrawalFirst() == null || membaseinfo.getWithdrawalFirst().compareTo(BigDecimal.ZERO) == 0) {
                membaseinfo.setWithdrawalFirst(getTradeOffAmount(traOrderinfom.getSumamt()));
            }
            // 设置最大提现金额
            if (membaseinfo.getWithdrawalMax() == null || membaseinfo.getWithdrawalMax().compareTo(getTradeOffAmount(traOrderinfom.getSumamt())) == -1) {
                membaseinfo.setWithdrawalMax(getTradeOffAmount(traOrderinfom.getSumamt()));
            }
            // 修改已提现金额
            memBaseinfoService.updateWithdrawalAmount(membaseinfo);
            // 发送系统消息
            this.doInfSysremindinfo(traOrderinfom, traOrderinfom.getAccno());
            // 会员提现成功日志
            SysInfolog sysInfolog = new SysInfolog();
            sysInfolog.setAccno(traOrderinfom.getAccno());
            sysInfolog.setOptcontent("会员提现[" + membaseinfo.getUniqueId() + "]金额[" + traOrderinfom.getRealamt() + "]订单号[" + traOrderinfom.getOrderno() + "]提现成功");
            sysInfolog.setSystemname(ModuleConstant.LIVE_MANAGE);
            sysInfolog.setModelname("会员提现");
            sysInfolog.setOrginfo("doIncarnateConfirm");
            commonService.insertSelective(sysInfolog);
            RedisBusinessUtil.delIncarnateOrderListCahce();
        } else {
            throw new BusinessException("提现失败(订单已提现)");
        }
        return csCallBackVoPrev;
    }


    public void ybError(CsCallBackRecord csCallBackRecord) {
        csCallBackRecordMapper.insert(csCallBackRecord);
    }

    private void doInfSysremindinfo(TraOrderinfom traOrderinfom, String accno) {
        InfSysremindinfo infSysremindinfo = new InfSysremindinfo();
        infSysremindinfo.setSender(accno);
        infSysremindinfo.setRmtype(com.likes.common.constant.Constants.RMTYPE_SYSTEM);
        infSysremindinfo.setRecipienter(traOrderinfom.getAccno());
        infSysremindinfo.setRemindtxt("恭喜您，提现" + traOrderinfom.getRealamt().doubleValue() + "元成功");
        infSysremindinfo.setRmtitle("用户提现");
        infSysremindinfo.setSenddate(new Date());
        infSysremindinfo.setRefparm(String.valueOf(traOrderinfom.getOrderid()));
        infSysremindinfo.setRefaddlink(String.valueOf(traOrderinfom.getOrderid()));
        infSysremindinfo.setRmdateexp(DateUtils.afterDays(new Date(), 7));
        infSysremindinfo.setIssee(com.likes.common.constant.Constants.ISSEE_9);
        infSysremindinfo.setIstodo(com.likes.common.constant.Constants.ISTODO_0);
        infSysremindinfo.setCreateUser(accno);
        infSysremindinfo.setUpdateUser(accno);
        infSysremindinfoService.insertSelective(infSysremindinfo);
        RedisBusinessUtil.delete(RedisKeys.LIVE_INF_SYSREMINDINFO_NUM + traOrderinfom.getAccno());

    }


    private void failedOrder(TraOrderinfom traOrderinfom, TraApplycash traApplycash, String msg) {
        BigDecimal sumamt = traOrderinfom.getSumamt();
        // 修改订单状态
        traOrderinfom.setOrderstatus(Constants.ORDER_ORD14);
        traOrderinfom.setUpdateUser("cs");
        traOrderinfom.setUpdateTime(new Date());
        traOrderinfom.setOrdernote("cs" + msg);
        traOrderinfomMapperService.updateByPrimaryKeySelective(traOrderinfom);
        Long mid = memBaseinfoService.selectByAccno(traOrderinfom.getAccno()).getMemid();
        RReadWriteLock lock = redissonClient.getReadWriteLock(RedisLock.UPDATE_USER_BALANCE_ + mid);
        try {
            boolean bool = lock.writeLock().tryLock(100, 20, TimeUnit.SECONDS);
            if (!bool) {
                log.error("{}.failedOrder 未获得锁:{}", getClass().getName(), RedisLock.UPDATE_USER_BALANCE_ + mid);
                throw new BusinessException("操作太频繁，请稍后再试");
            }
            // 插入订单轨迹
            MemBaseinfo membaseinfo = memBaseinfoService.getUserByAccno(traOrderinfom.getAccno());
            TraOrdertracking traOrdertracking = new TraOrdertracking();
            traOrdertracking.setOrderid(traOrderinfom.getOrderid());
            traOrdertracking.setTrackdate(new Date());
            traOrdertracking.setOrderstatus(Constants.ORDER_ORD14);
            traOrdertracking.setOperuse("cs");
            traOrdertracking.setTrackbody("支付商[ cs ]将提现订单[" + traOrderinfom.getOrderno() + "]失败");
            traOrdertrackingMapperService.insertSelective(traOrdertracking);
            // 设置 提现申请为失败
            traApplycash.setApycstatus(Constants.APYCSTATUS3);
            traApplycash.setPaymemname("cs");
            traApplycash.setUpdateUser("cs");
            traApplycashMapperService.updateByPrimaryKeySelective(traApplycash);
            //帐变
            // 修改 金币变化记录表 将用户申请提现的记录 改为 状态已提现
            MemGoldchange memGoldchange = memGoldchangeService.selectOneByExample(traOrderinfom.getOrderid(), traOrderinfom.getAccno());
            BigDecimal tradeOffAmount = getTradeOffAmount(membaseinfo.getNoWithdrawalAmount());
            BigDecimal tradeOffAmount1 = getTradeOffAmount(membaseinfo.getGoldnum());
            memGoldchange.setAfterCgdml(tradeOffAmount);
            memGoldchange.setPreCgdml(tradeOffAmount);
            memGoldchange.setSource(traOrderinfom.getSource());
            memGoldchange.setGoldnum(tradeOffAmount1);
            memGoldchange.setQuantity(getTradeOffAmount(sumamt.multiply(new BigDecimal(Constants.CHONGZHIBILIE))));
            memGoldchange.setAmount(getTradeOffAmount(sumamt));
            memGoldchange.setRecgoldnum(tradeOffAmount1.add(sumamt));
            memGoldchange.setChangetype(GoldchangeEnum.WITHDRAW_FAILED.getValue());
            memGoldchange.setUpdateUser("cs");
            memGoldchange.setUpdateTime(new Date());
            memGoldchange.setOpnote("提现失败");
            memGoldchangeService.updateByPrimaryKeySelective(memGoldchange);
            memBaseinfoService.updateMemBalance(sumamt, BigDecimal.ZERO, BigDecimal.ZERO, membaseinfo.getAccno());

            // 会员人工取消日志
            SysInfolog sysInfolog = new SysInfolog();
            sysInfolog.setAccno("cs");
            sysInfolog.setOptcontent("会员提现[" + membaseinfo.getUniqueId() + "]金额[" + traOrderinfom.getRealamt() + "]订单号[" + traOrderinfom.getOrderno() + "]三方失败");
            sysInfolog.setSystemname(ModuleConstant.LIVE_MANAGE);
            sysInfolog.setModelname("会员提现");
            sysInfolog.setOrginfo("doIncarnateConfirm");
            commonService.insertSelective(sysInfolog);
        } catch (Exception e) {
            log.error("{}.failedOrder 失败", getClass().getName(), e);
            throw new BusinessException("修改账变失败");
        } finally {
            lock.writeLock().unlock();
        }
    }

}