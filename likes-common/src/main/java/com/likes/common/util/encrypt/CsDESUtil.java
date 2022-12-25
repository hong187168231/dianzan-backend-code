package com.likes.common.util.encrypt;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class CsDESUtil {

    private static final String MCRYPT_TRIPLEDES = "DESede";

    private static final String TRANSFORMATION = "DESede/CBC/PaddingPKCS7";

    //解密
    public static String decrypt(String data, String key) {
        if (data == null) return null;
        String result = null;
        try {
            byte[] dataByte = new BASE64Decoder().decodeBuffer(data);
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
    public static String encrypt(String data, String key) {
        if (data == null) return null;
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
        if (StringUtils.isNotBlank(key)) {
            return key.substring(0, 8);
        }
        return null;
    }


    public static void main(String[] args) {
        String key = "7040b14dca5916bd92627d51f0059c37";
        String result = CsDESUtil.encrypt("MFBZd1FodHdPVlFpekw0dzlrM3VkTWJ4Qm04cnlYR1hDWFMrTW1wWGhVKzJxVktkOGV3QmY3eCtWNXdQVW9lWE5HZllaL0FxVDJDZUZWZVpxZ3V0V0MxaWpSN2w0V1d2VVI4N2Z5TnJseXg0amNVb0pwd1FzZHJ3NSttSjRYSHNmcDBkc01uUFlISG5pS0xQOU1ya2o0QU1sYmI0VUNRcEdRVHJKNVRQNytBL00yR0pQbXUwajhJc1NJQVR4VTRJVEdkNnY3QnNyVEdKZlVpTmdDc2Q2bHJ3dUUrYnpIV2ExQnJhWXcwY2pQZjF0MTRJV1hDVXBBU3NRempIc203dk1oNEZkWG1HUWJmUkRXcXViSEpqUDlXdkpud1o5TmpvSEtlZ0hUVGw0TFovNzlUQUwwZXVFeHVRS2wzUDQvaEVuY0M5dG5HT1Zyc1hiay8vcEVtVEdVVzZlR25CbjlMNg", key);
        System.out.println(result);
        System.out.println(CsDESUtil.decrypt("0PYwQhtwOVQizL4w9k3udMbxBm8ryXGXCXS+MmpXhU+2qVKd8ewBf7x+V5wPUoeXNGfYZ/AqT2CeFVeZqgutWC1ijR7l4WWvUR87fyNrlyx4jcUoJpwQsdrw5+mJ4XHsfp0dsMnPYHHniKLP9Mrkj4AMlbb4UCQpGQTrJ5TP7+A/M2GJPmu0j8IsSIATxU4ITGd6v7BsrTGJfUiNgCsd6lrwuE+bzHWaBDtQM8o+EeSAx+7zDAVsjAa3pnfEVnlfYkxfX3Q1nUMp8C/5J9nXo1KukJtCgNWJ7HE/U5YxQ6L0SvUP5Kzw/QbkeP5BEKE8CTwsMjROZkbeLsMEz61enhWVABNDc3GM", key));
    }
}
