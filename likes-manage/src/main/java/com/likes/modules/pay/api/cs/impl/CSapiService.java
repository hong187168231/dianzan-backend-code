package com.likes.modules.pay.api.cs.impl;
import com.alibaba.fastjson.JSONObject;
import com.likes.modules.pay.api.cs.ICSapiService;
import com.likes.modules.pay.util.DESUtil;
import com.likes.modules.pay.util.HttpClient4Util;
import com.likes.modules.pay.vo.cs.CSgetOrderVo;
import com.likes.modules.pay.vo.cs.CSgetTokenVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

@Service
@Slf4j
public class CSapiService implements ICSapiService {

    public static String key = "d2fb04d8103613b8d391ebc2d34228bd";
    public static String mcode = "gxtnxaciwhdg";
    public static String apiUrl = "http://api.vnhotpay.com/japi/index";
    public static void main(String[] args)
    {
        try{
            CSapiService cSapi = new CSapiService();
            cSapi.getToken(2,"cs12345","OnlineBank","http://admin.kk88814.net/","http://admin.kk88814.net/");
            String str = DigestUtils.md5Hex("sign：business_type=20011&mer_order_no=cs12345&notify_url=http://127.0.0.1/notify&order_price=2&page_back_url=http://127.0.0.1/notify&pay_type=OnlineBank&reserve=&reserved1=&reserved2=&sign=&timestamp=1671891508&key=d2fb04d8103613b8d391ebc2d34228bd");
            System.out.println(str);
        }catch (Exception ex){
            ex.printStackTrace();
            //处理异常
        }

    }

    private String base64(String result){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(result.getBytes());
    }

    private List<String> getDeclaredFields(Object obj){
        List<String> list = new ArrayList<>();
        // voucher是目标对象
        try{
            //通过getDeclaredFields()方法获取对象类中的所有属性（含私有）
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                //设置允许通过反射访问私有变量
                field.setAccessible(true);
                //获取字段的值
                String value = null!=field.get(obj)?field.get(obj).toString():"";
                if(null!=value && !"".equals(value)) {
                    //获取字段属性名称
                    String name = field.getName();
                    //其他自定义操作
                    list.add(name + "=" + value);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            //处理异常
        }
        return list;
    }

    /**
     * 参数加密
     * @param list
     * @param key
     * @return
     */
    private String getParameter(List<String> list,String key){
        Collections.sort(list);
        String parameter = "";
        for(int i=0;i<list.size();i++){
            parameter = parameter + list.get(i);
            if(i!=list.size()-1){
                parameter = parameter + "&";
            }
        }
        return parameter+"&key="+key;
    }

    //四、	获取收银台支付token    (收款接口)
    @Override
    public String getToken(Integer amount,String orderNo,String payType,String backUrl,String notifyUsrl) throws Exception {
        CSgetTokenVo cSgetTokenVo = new CSgetTokenVo();
        cSgetTokenVo.setBusiness_type("20011");//	是	String(5)	业务编码
        cSgetTokenVo.setMer_order_no(orderNo);//	是	String(20)	商户订单号
        cSgetTokenVo.setOrder_price(amount);//	是	Int	订单金额

        cSgetTokenVo.setPay_type(payType);//	否	String	支付方式：
//        OnlineBank 账户转账
//        ScanCode 银行扫码付
//        DirectBank 网银直连
        cSgetTokenVo.setPage_back_url(null!=backUrl?URLEncoder.encode(backUrl,"utf-8"):"");//	是	String	同步返回商户页面地址(urlencode编码)
        cSgetTokenVo.setNotify_url(null!=notifyUsrl?URLEncoder.encode(notifyUsrl,"utf-8"):"");//	是	String	后台回调通知地址(urlencode编码)
//        cSgetTokenVo.setReserve();//	否	String	预留备注留言字段
//        cSgetTokenVo.setReserved1();//	否	String	预留字段1
//        cSgetTokenVo.setReserved2();//	否	String	预留字段2
        long time11 = System.currentTimeMillis() / 1000;
        cSgetTokenVo.setTimestamp(time11);//	是	Int(10)	十位时间戳

        String sign = this.getParameter(this.getDeclaredFields(cSgetTokenVo),key);
        log.info("CS获取收银台支付token    (收款接口)输入加密前,sign：{}", sign);
        cSgetTokenVo.setSign(DigestUtils.md5Hex(sign));//	是	String(32)	签名字符(查看sign签名说明)
        log.info("CS获取收银台支付token    (收款接口)输入加密前,params：{}", JSONObject.toJSONString(cSgetTokenVo));


        String paramsStr = JSONObject.toJSONString(cSgetTokenVo);
        String params = this.base64(DESUtil.encrypt(paramsStr, key));//加密参数
        Map<String, String> trr = new HashMap<>();
        trr.put("mcode", mcode);//商户唯一标识
        trr.put("params", params);
        log.info("CS获取收银台支付token    (收款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl,JSONObject.toJSONString(trr));
        String resultString = "";
        try {
            resultString = HttpClient4Util.doPost(apiUrl,JSONObject.toJSONString(trr));
            //{"msg":"收银台订单登记成功","code":0,"data":{"order_no":"INC2022122421242163407741","pay_url":"https://cashier.vnhotpay.com","mer_order_no":"cs12345","token":"dd0b570af9ec33cc35eba38d3ba6e3c6"}}]
            log.info("CS获取收银台支付token    (收款接口)返回,result：{}", resultString);
        } catch (Exception e) {
            log.info("CS获取收银台支付token    (收款接口)請求Exception：{}", e);
            throw e;
        }
        return resultString;
    }

    //七、	订单查询接口    (收款接口)
    @Override
    public JSONObject queryOrder(String orderNo) throws Exception {

        CSgetOrderVo cSgetOrderVo = new CSgetOrderVo();
        cSgetOrderVo.setBusiness_type("10004");//	是	String(5)	业务编码
        cSgetOrderVo.setMer_order_no(orderNo);//	是	String(20)	商户订单号
        long time11 = System.currentTimeMillis() / 1000;
        cSgetOrderVo.setTimestamp(time11);//	是	Int(10)	十位时间戳
        String sign = this.getParameter(this.getDeclaredFields(cSgetOrderVo),key);
        log.info("CS订单查询接口    (收款接口)输入加密前,sign：{}", sign);
        cSgetOrderVo.setSign(DigestUtils.md5Hex(sign));//	是	String(32)	签名字符(查看sign签名说明)
        log.info("CS订单查询接口    (收款接口)输入加密前,params：{}", JSONObject.toJSONString(cSgetOrderVo));


        String paramsStr = JSONObject.toJSONString(cSgetOrderVo);
        String params = this.base64(DESUtil.encrypt(paramsStr, key));//加密参数
        Map<String, String> trr = new HashMap<>();
        trr.put("mcode", mcode);//商户唯一标识
        trr.put("params", params);
        log.info("C订单查询接口    (收款接口)帶請求參數输入,apiUrl：{},params：{}", apiUrl,JSONObject.toJSONString(trr));
        try {
            String resultString = HttpClient4Util.doPost(apiUrl,trr);
            log.info("CS订单查询接口    (收款接口)返回,result：{}", resultString);
        } catch (Exception e) {
            log.info("CS订单查询接口    (收款接口)請求Exception：{}", e);
            throw e;
        }
        return null;
    }

}
