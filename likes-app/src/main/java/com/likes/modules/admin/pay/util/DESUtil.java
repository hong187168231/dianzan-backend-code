package com.likes.modules.admin.pay.util;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Security;

public class DESUtil {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    private static final String MCRYPT_TRIPLEDES = "DESede";

    private static final String TRANSFORMATION = "DESede/CBC/PKCS7Padding";

    //解密
    public static String decrypt(String data,String key) {
        if (data == null) return null;
        String result = null;
        try {
            byte[] dataByte = new BASE64Decoder().decodeBuffer(data) ;
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(MCRYPT_TRIPLEDES);
            SecretKey sec = keyFactory.generateSecret(spec);
            IvParameterSpec IvParameters = new IvParameterSpec(getIVString(key).getBytes());
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, sec, IvParameters);
            result = new String(cipher.doFinal(dataByte), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.replaceAll("(\r\n|\n)", "");
    }

    //加密
    public static String encrypt(String data,String key) {
        String result = null;
        try {
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(MCRYPT_TRIPLEDES);
            SecretKey sec = keyFactory.generateSecret(spec);
            IvParameterSpec IvParameters = new IvParameterSpec(getIVString(key).getBytes());
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, sec, IvParameters);
            byte[] res = cipher.doFinal(data.getBytes("UTF-8"));
            result = new BASE64Encoder().encodeBuffer(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.replaceAll("(\r\n|\n)", "");
    }



    public static String getIVString(String key) {
        if(StringUtils.isNotBlank(key)){
            return key.substring(0,8) ;
        }
        return null ;
    }



    public static void main(String[] args) {
        String key = "d2fb04d8103613b8d391ebc2d34228bd" ;
        String result = DESUtil.encrypt("{\"business_type\":\"10005\",\"sign\":\"00aea3fc3c5a3d4623cae749ea1ac70f\",\"pay_type\":\"OnlineBank\",\"timestamp\":1654668613}",key) ;
        BASE64Encoder encoder = new BASE64Encoder();
        String data = encoder.encode(result.getBytes());
        System.out.println("BASE64加密：" + data);
        System.out.println(result);
        System.out.println(DESUtil.decrypt(result,key));
    }
}
