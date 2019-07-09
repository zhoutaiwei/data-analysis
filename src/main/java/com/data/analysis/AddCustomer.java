package com.data.analysis;

import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.utils.HttpClientUtils;
import com.data.analysis.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Slf4j
public class AddCustomer {



    private static  final String baseUrl = "http://monitor.fahaicc.com/request";

    public static void main(String[] args) {
        /*if(args==null||args.length<=0){
            log.info("请传入文件路径");
            return;
        }*/
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
           // inputStream = new FileInputStream("D:\\gitee\\data-analysis\\classes\\artifacts\\data_analysis_jar\\monitor_list");
            inputStream = new FileInputStream("C:\\Users\\希希\\Desktop\\fh.txt");
            sc = new Scanner(inputStream, "UTF-8");
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("uid",DataTypeConstant.uid);
            paramMap.put("api","item");
            paramMap.put("authCode",DataTypeConstant.authCOde);

            JSONObject monitorName = new JSONObject();
            JSONObject arg = new JSONObject();
            arg.put("action", "add");
            arg.put("customerGroupId", 4096);
            arg.put("monitorItemType", "C");
            arg.put("static", 0);

          while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String rt = String.valueOf(System.currentTimeMillis());
                paramMap.put("rt",rt);
                monitorName.put("pname",line);
                arg.put("monitorName", monitorName.toJSONString());
                paramMap.put("args",arg.toJSONString());
                String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
                paramMap.put("sign",sign);
                JSONObject result =new AddCustomer().getDataByHttp (baseUrl,paramMap);

            }
        } catch (Exception e) {
           log.error("数据插入失败",e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("文件读取有误，",e);
                }
                }
                sc.close();
            }
    }


    static int count =1;

    public  JSONObject getDataByHttp(String uri,  Map<String, String> param) {
        //构建请求url
        String resultStr = null;
        JSONObject result = null;
        try {
            String url = uri;
            //发送get 请求获取数据
            resultStr = doGet(url, param);
            count++;
            log.info("處理數{}",count);

            result = JSONObject.parseObject(resultStr);
            String code = result.getString("code");
            String msg = result.getString("msg");
            //判断是否返回成功

            String argsStr =  param.get("args");
            JSONObject args =  JSONObject.parseObject(argsStr);
            String name = args.getString("monitorName");
            if (!DataTypeConstant.SUCCESS_CODE.equals(code)&&!"已存在该监控名单".equals(msg)) {
                log.info("添加数据不成功,参数为：{},返回结果为：{}",name,resultStr);
                return null;
            }else if(DataTypeConstant.SUCCESS_CODE.equals(code)){
                log.info("添加数据成功,參數為：{}",name);
            }else if (!DataTypeConstant.SUCCESS_CODE.equals(code)&&"已存在该监控名单".equals(msg)) {
                log.info("已存在该监控名单,{}",name);
            }

        } catch (Exception e) {
            log.error("數據異常{}",e);
        }
        return result;
    }

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录

    private static RequestConfig requestConfig = null;

    static
    {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
    }

    public  String doGet(String url, Map<String, String> param) {

        // 创建Httpclient对象
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String resultString = "";
        CloseableHttpResponse response = null;
        //请求url
        String requestUrl="";
        //请求状态
        int status =0;
        //请求耗时
        Long  timeConsuming=0L;
        //错误消息
        String errorMessage = "";
        //请求时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String requestDate="";
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // log.info("请求路径：{}",URLDecoder.decode(uri.toASCIIString(), "UTF-8"));
            requestUrl = URLDecoder.decode(uri.toASCIIString(), "UTF-8");
            long startTime = System.currentTimeMillis();
            requestDate = format.format(new Date());
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            //指定重试次数
            httpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(3,true));
            // 执行请求
            response = httpClient.execute(httpGet);
            long endTime = System.currentTimeMillis();
            //请求耗时
            timeConsuming = endTime-startTime;
            //相应状态
            status = response.getStatusLine().getStatusCode();
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                try {
                    JSONObject jsonObject = JSONObject.parseObject(resultString);
                    String code = jsonObject.getString("code");
                    //如果失败则记录错误信息
                    if(!DataTypeConstant.SUCCESS_CODE.equals(code)){
                        errorMessage=resultString;
                    }
                } catch (Exception e) {
                    log.error("json解析错误",e);
                }
            }
        } catch (Exception e) {
            //500代表请求失败
            status=500;
            errorMessage = e.getMessage();
            log.error("請求異常：{}",e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
