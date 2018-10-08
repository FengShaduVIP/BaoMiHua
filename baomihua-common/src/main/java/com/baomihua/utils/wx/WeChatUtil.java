package com.baomihua.utils.wx;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeChatUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatUtil.class);
    //从微信后台拿到APPID和APPSECRET 并封装为常量
    private static final String APPID = "wxe09763a06d980f09";
    private static final String APPSECRET = "3a6005a4c7589ca9e93297c72f7eaf4d";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static String ACCESS_TOKEN = null;
    //刷新access_token 100分钟刷新一次,服务器启动的时候刷新一次（access_token有效期是120分钟，我设置的是每100分钟刷新一次）

    @Scheduled(initialDelay = 1000, fixedDelay = 100*60*1000)
    public static void getAccessToken() {
        try {
            String requestUrl = ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
            JSONObject jsonObject = httpsRequest(requestUrl,"GET",null);
            if(jsonObject.getString("access_token")!=null){
                try {
                    Map<String,String> map = new HashMap<String,String>();
                    ACCESS_TOKEN = jsonObject.getString("access_token");
                    map.put("access_token",jsonObject.getString("access_token"));
                } catch(Exception e){
                    e.printStackTrace();
                } finally {

                }
            }
            else{
                LOGGER.info("定时刷新access_token失败，微信返回的信息是"+jsonObject.toJSONString());
            }
        }
        catch (Exception e){
            LOGGER.info("更新access_token的过程当中发生了异常，异常的信息是"+e.getMessage());
        }
    }

    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //HttpURLConnection  con= url.openConnection();
            conn.setSSLSocketFactory(ssf);
            //2017年9月15日16:21:40
            //新设置的，可能是一直在链接导致的程序死亡
            conn.setConnectTimeout(10 * 1000);
            conn.setReadTimeout(50 * 1000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();

            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}" + ce);
        } catch (Exception e) {
            System.out.println("https请求异常：{}" + e);
            //log.error("https请求异常：{}", e);
        }
        return jsonObject;
    }



}
