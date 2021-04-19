package com.hongtian.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongtian.entity.dto.req.ZaxqSbsjResponseItem;
import com.hongtian.entity.dto.req.ZaxqSbsjResponseParent;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityToXmlUtil {
    private static Logger logger = LoggerFactory.getLogger(EntityToXmlUtil.class);
    private static String url = "http://41.188.131.157:8230/PSPC/SC/Community/FaceCapture";
    private static String Registerurl = "http://41.188.131.157:8230/PSPC/SC/System/Register";
    private static String KeepAliveurl = "http://41.188.131.157:8230/zhian/PSPC/SC/System/KeepAlive";
    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 生成xml方法
     */
    public static String getXml(Object object) {
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点rss
            Element rss = document.addElement("complexType");
            // 3、向rss节点添加version属性
            rss.addAttribute("name", object.getClass().getName());
            // 4、生成子节点及子节点内容
            Element channel = rss.addElement("sequence");
            Class cls = object.getClass();
            //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
            Element title = null;
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                try {
                    title = channel.addElement("element");
                    title.addAttribute("name", f.getName());
                    title.addAttribute("type", f.getGenericType().toString());
                    title.setText(f.get(object).toString());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    logger.error("发生错误", e);
                }
            }
            return document.asXML();
        } catch (Exception e) {
            logger.error("生成rss.xml失败", e);
            return null;
        }
    }

    public static HttpEntity<String> getHead(String value) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("User-Identify", "33020000009030000001");
        HttpEntity<String> formEntity = new HttpEntity<String>(value, headers);
        return formEntity;
    }

    public static void KeepAlive() {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        String strResponse = null;
        Boolean flag = false;
        Map<String, Map<String, String>> registerRequest = getRequestBh();
        String keepRequestResult = JSON.toJSONString(registerRequest);
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(KeepAliveurl);
            httpPost.setHeader("Content-type", "application/json");
            RequestConfig.Builder builder = RequestConfig.custom();
            builder.setSocketTimeout(300000);
            builder.setConnectTimeout(500000);
            httpPost.setEntity(new StringEntity(keepRequestResult, "UTF-8"));
            httpPost.setConfig(builder.build());
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == statusCode) {
            } else {
                logger.warn("保活失败");

            }
        } catch (Exception e) {
            logger.warn("传输异常", e);
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean doPostProcessor(String url, String xmlParam) {
        KeepAlive();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        String strResponse = null;
        Boolean flag = false;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Identify", "33020000009030000001");
            /*httpPost.setHeader("Connection","Close");*/
            RequestConfig.Builder builder = RequestConfig.custom();
            builder.setSocketTimeout(300000);
            builder.setConnectTimeout(500000);
            httpPost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            /*builder.setRedirectsEnabled(false);*/
            httpPost.setConfig(builder.build());
            response = httpClient.execute(httpPost);
            org.apache.http.HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == statusCode) {
                strResponse = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                parseReult(strResponse);
                return true;
            } else {
                strResponse = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                logger.error("传输失败:{}.",strResponse);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("传输异常");
            return false;
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Boolean doPostDigest(String url, String username, String password, String entityString) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost httpPost = null;
        String strResponse = null;
        Boolean flag = false;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type", "application/json");
            /*httpPost.setHeader("Cache-Control","no-cache");
            httpPost.setHeader("Connection","Close");*/
            RequestConfig.Builder builder = RequestConfig.custom();
            builder.setSocketTimeout(3000);
            builder.setConnectTimeout(5000);
            JSONObject jsonObject = new JSONObject();
            httpPost.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            /*builder.setRedirectsEnabled(false);*/
            httpPost.setConfig(builder.build());
            response = httpClient.execute(httpPost);
            org.apache.http.HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (401 == statusCode) {
                strResponse = EntityUtils.toString(responseEntity);
                Header[] headers = response.getHeaders("WWW-Authenticate");
                HeaderElement[] elements = headers[0].getElements();
                String realm = null;
                String qop = null;
                String nonce = null;
                String opaque = null;
                String method = "POST";
                String uri = "/zhian/PSPC/SC/System/Register";
                for (HeaderElement element : elements) {
                    if (element.getName().equals("Digest realm")) {
                        realm = element.getValue();
                    } else if (element.getName().equals("qop")) {
                        qop = element.getValue();
                    } else if (element.getName().equals("nonce")) {
                        nonce = element.getValue();
                    } else if (element.getName().equals("opaque")) {
                        opaque = element.getValue();
                    }
                }

                /*int a =0;*/
                int nc = 0000001;
                String cnonce = RandomStringUtils.randomAlphanumeric(32);
                String response1 = null;
                String a1 = username + ":" + realm + ":" + password;
                String a2 = method + ":" + uri;
                String backString = response.getFirstHeader("WWW-Authenticate").getValue();
                try {
                    response1 = string2Md5(string2Md5(a1) + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + string2Md5(a2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                httpPost.addHeader("Authorization", backString + ",username=\"" + username + "\"" + ",realm=\"" + realm + "\"" + ",nonce=\"" + nonce + "\""
                        + ",uri=\"" + uri + "\"" + ",qop=\"" + qop + "\"" + ",nc=\"" + nc + "\"" + ",cnonce=\"" + cnonce + "\"" + ",response=\"" + response1 + "\"" + ",opaque=\"" + opaque + "\"");
                httpPost.setEntity(new StringEntity(entityString, "UTF-8"));
                response = httpClient.execute(httpPost);
                org.apache.http.HttpEntity entity = response.getEntity();
                int statusCode1 = response.getStatusLine().getStatusCode();
                if (HttpStatus.SC_OK == statusCode1) {
                    strResponse = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                    flag = true;
                    return flag;
                } else {
                    strResponse = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                    logger.error("鉴定失败");
                    return flag;
                }

            } else {
                strResponse = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
                logger.error("第一次鉴定非401" + strResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("认证失败");
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;

    }

    public static Map<String, Map<String, String>> getRequestBh() {
        Map<String, String> map = new HashMap<>();
        map.put("ZHAFXQXTBS", "33020000009030000001");
        map.put("Version", "1.0.0");
        Map<String, Map<String, String>> mapMap = new HashMap<>();
        mapMap.put("KeepAliveObject", map);
        return mapMap;
    }

    //测试接收方部分代码
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = null;
        String result = "";
        StringBuffer sbf = new StringBuffer();
        InputStream is = request.getInputStream();
        reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        String strRead = null;
        while ((strRead = reader.readLine()) != null) {
            sbf.append(strRead);
            sbf.append("\r\n");
        }
        reader.close();
        result = sbf.toString();
        System.out.println("result:" + result);
    }

    public static String string2Md5(String str) {
        StringBuilder sb = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(str.getBytes());
            sb = new StringBuilder();
            for (byte b : digest) {
                int len = b & 0xff;
                if (len <= 15) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(len));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void parseReult(String strResponse) {
        try{
            ZaxqSbsjResponseParent zaxqSbsjResponseParent = JSON.parseObject(strResponse, ZaxqSbsjResponseParent.class);
            List<ZaxqSbsjResponseItem> list =
                    zaxqSbsjResponseParent.getResponseStatusListObject().getResponseStatusObject();
            int success = 0;
            int fail = 0;
            for(int i = 0; i < list.size(); i++) {
                ZaxqSbsjResponseItem resp = list.get(i);
                if ("0".equals(resp.getZTM())) {
                    success++;
                }else {
                    fail++;
                }
            }
            logger.warn("上传结果：success:{},fail:{}",success,fail);
        }catch (Exception e) {
            logger.error("解析返回结果时出错！{}",strResponse);
//            e.printStackTrace();
        }

    }
}
