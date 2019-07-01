package com.data.analysis.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class SignUtil {
    public static String getSign(String uid,String authCode, String api,String time,String args){
        String signKey =
                uid+"@"+authCode+"@"+api+"@"+time+"@"+args;
        return MD5(signKey);
    }
    //获取签名
    public static String getSign(String authCode, String time){
        String signKey = authCode+time;
        return MD5(signKey);
    }
    //获取签名
    public static String getSign(String uid,String authCode, String time){
        String signKey = uid+"@"+time+"@"+authCode;
        return MD5(signKey);
    }
    public static String MD5(String source){
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        return DigestUtils.md5Hex(source);
    }
    //通过 url 获得返回值
    public static String queryGET(String url){
        StringBuilder sb = new StringBuilder();
        try {
            URL url1 = new URL(url);
            //URI uri = new URI(url1.getProtocol(),url1.getHost(),url1.getPath(), url1.getQuery(),null);
            URI uri = new URI(url1.getProtocol(),"",
                    url1.getHost(), url1.getPort(),url1.getPath(),
                    url1.getQuery(), null);
            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("Cache-Control", "max-age=0");
            httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpGet.setHeader("Accept-Encoding", "gzip,deflate,sdch");
            httpGet.setHeader("Accept-Language", "enUS,en;q=0.8");
            httpGet.setHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
            httpGet.setHeader("Accept-Encoding", "gzip,deflate,sdch");
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                java.io.InputStream instreams = entity.getContent();
                BufferedReader bf = new BufferedReader(new InputStreamReader(instreams,"utf-8"));
                // 文件处理方式
                String line = null;
                while ((line = bf.readLine()) != null) {
                    sb.append(line + "\n");
                }
                httpGet.abort();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

