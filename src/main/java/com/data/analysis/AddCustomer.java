package com.data.analysis;

import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.utils.HttpClientUtils;
import com.data.analysis.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
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
            inputStream = new FileInputStream("D:\\gitee\\data-analysis\\classes\\artifacts\\data_analysis_jar\\monitor_list");
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

       //     while (sc.hasNextLine()) {
                String line = "洪洞县三友电器厨具超市";
                String rt = String.valueOf(System.currentTimeMillis());
                paramMap.put("rt",rt);
                monitorName.put("pname",line);
                arg.put("monitorName", monitorName.toJSONString());
                paramMap.put("args",arg.toJSONString());
                String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
                paramMap.put("sign",sign);
                JSONObject result =getDataByHttp (baseUrl,paramMap);

      //      }
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
    public static JSONObject getDataByHttp(String uri,  Map<String, String> param) {
        //构建请求url
        String resultStr = null;
        JSONObject result = null;
        try {
            String url = uri;
            //发送get 请求获取数据
            resultStr = HttpClientUtils.doGet(url, param);
            count++;
            log.info("處理數{}",count);

            result = JSONObject.parseObject(resultStr);
            String code = result.getString("code");
            String msg = result.getString("msg");
            //判断是否返回成功
            if (!DataTypeConstant.SUCCESS_CODE.equals(code)&&!"已存在该监控名单".equals(msg)) {
                 String argsStr =  param.get("args");
                JSONObject args =  JSONObject.parseObject(argsStr);
                String name = args.getString("monitorName");
                log.info("添加数据不成功,参数为：{},返回结果为：{}",name,resultStr);
                return null;
            }else if(DataTypeConstant.SUCCESS_CODE.equals(code)){
                String argsStr =  param.get("args");
                JSONObject args =  JSONObject.parseObject(argsStr);
                String name = args.getString("monitorName");
                log.info("添加数据成功,參數為：",name);

            }

        } catch (Exception e) {
          //  log.error("數據異常{}",e);
        }
        return result;
    }
}
