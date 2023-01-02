package com.likes.common.util.cs;


import cn.hutool.http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClient4Util {
    private static final PoolingHttpClientConnectionManager connMgr;
    private static final RequestConfig requestConfig;
    private final static Map map = new HashMap<String, Object>();
    private static final int MAX_TIMEOUT = 5000;
    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(20000);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    /**
     * Java请求API接口案例
     *
     * @param apiUrl api接口地址
     * @param json 请求参数json对象
     * @return
     * @throws Exception
     */
    public static String doPost(String apiUrl, Object json) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");//解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");

            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    httpClient.close();
                    log.error("关闭http流发生异常", ex);
                }
            }
            httpClient.close();
        }
        return httpStr;
    }

    /**
     * Java请求API接口案例
     * @param apiUrl
     * @param paramsMap
     * @return
     * @throws Exception
     */
    public static String doPost(String apiUrl, Map<String, String> paramsMap) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        try {
            httpPost.setConfig(requestConfig);

            //不复用TCP SOCKET
//            httpPost.setHeader("connection", "close");
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            List<BasicNameValuePair> list = new ArrayList<>();
            for (String key : paramsMap.keySet()) {
                list.add(new BasicNameValuePair(key, String.valueOf(paramsMap.get(key))));
            }
            // 创建请求内容
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, StandardCharsets.UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    httpClient.close();
                    log.error("关闭http流发生异常", ex);
                }
            }
            httpClient.close();
        }
        return httpStr;
    }

}
