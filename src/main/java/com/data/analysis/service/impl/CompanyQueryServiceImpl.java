package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.service.CompanyQueryService;
import com.data.analysis.utils.HttpClientUtils;
import com.data.analysis.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.getInteger;

@Slf4j
@Service
public class CompanyQueryServiceImpl implements CompanyQueryService {

    /**
     * 获取公司案件的URI
     */
    private final String baseUrl = "http://monitor.fahaicc.com/request";





    @Override
    public JSONObject getStandardDataByPageNo(final int pageNo) {
      //构建参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("authCode",DataTypeConstant.authCOde);
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        paramMap.put("api","result");
        paramMap.put("uid",DataTypeConstant.uid);
        JSONObject json = new JSONObject();
       // json.put("resultDataType", "cpws");
       // json.put("pname", "守权商贸公司");
        json.put("pageno", pageNo);
        json.put("customerGroupId", 4096);
        json.put("range", 10);
      //  String sign = SignUtil.getSign(DataTypeConstant.uid,authCOde,"epb",rt,json.toJSONString());
        String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
        paramMap.put("sign",sign);
        paramMap.put("args", json.toJSONString());
        JSONObject result = getDataByHttp(baseUrl,paramMap);
        return result;

    }

    @Override
    public int getTotalPage() {
        JSONObject result = getStandardDataByPageNo(1);
        if (result == null) {
            log.info("获取环保标准数据失败！");
            return 0;
        }
        return result.getInteger("totalPageNum");
    }




    public JSONObject getDataByHttp(String uri,  Map<String, String> param) {
        //构建请求url
        String url = uri;
        //发送get 请求获取数据
        String resultStr = HttpClientUtils.doGet(url, param);
        JSONObject result = JSONObject.parseObject(resultStr);
        String code = result.getString("code");
        //判断是否返回成功
        if (!DataTypeConstant.SUCCESS_CODE.equals(code)) {
            log.info("获取数据不成功,返回結果：",resultStr);
            return null;
        }
        return result;
    }

    public void addUpperCustomerGroupId(){
        String uri=baseUrl;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid",DataTypeConstant.uid);
        paramMap.put("api","branch");
        paramMap.put("authCode",DataTypeConstant.authCOde);
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        JSONObject json = new JSONObject();
        json.put("action", "add");
        json.put("upperCustomerGroupId", "0");
        json.put("groupName", "平安集团");
        json.put("description", "");
        paramMap.put("args",json.toJSONString());

        String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
        paramMap.put("sign",sign);
        JSONObject result = getDataByHttp(baseUrl,paramMap);
    }

    public void addCustomerGroup(){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("uid",DataTypeConstant.uid);
        paramMap.put("api","item");
        paramMap.put("authCode",DataTypeConstant.authCOde);
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        JSONObject json = new JSONObject();
        json.put("action", "add");
        json.put("customerGroupId", 4096);
        json.put("monitorItemType", "C");
        json.put("static", 0);
        json.put("monitorName", "[\"pname\":\"守权商贸公司\"}");
        paramMap.put("args",json.toJSONString());

        String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
        paramMap.put("sign",sign);
        JSONObject result = getDataByHttp(baseUrl,paramMap);
    }
}
