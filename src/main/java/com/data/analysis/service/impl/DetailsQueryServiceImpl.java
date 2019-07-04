package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.service.CompanyQueryService;
import com.data.analysis.service.DetailsQueryService;
import com.data.analysis.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DetailsQueryServiceImpl implements DetailsQueryService {
    @Autowired
    CompanyQueryService companyQueryService;

    /**
     * baseURI
     */
    private  String baseUrl = "http://monitor.fahaicc.com/request";


    @Override
    public void  getEPDetailsQueryData(String entityId,String dataType) {
        baseUrl=baseUrl+dataType;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("authCode",DataTypeConstant.authCOde);
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        String sign = SignUtil.getSign(DataTypeConstant.authCOde,rt);
        paramMap.put("sign",sign);
        paramMap.put("id",entityId);
        JSONObject result = companyQueryService.getDataByHttp(baseUrl,paramMap);
        System.out.println(result.toJSONString());
        //构建参数
/*        Map<String, String> paramMap = new HashMap<>();
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        String uid = DataTypeConstant.uid;
        paramMap.put("uid",uid);
        String sign = SignUtil.getSign(DataTypeConstant.uid,DataTypeConstant.authCOde,rt);
        paramMap.put("sign",sign);
        paramMap.put("api","result");
        paramMap.put("action","detailed");
        JSONObject args = new JSONObject();
        args.put("resultDataType",dataType);
       // args.put("resultEntryId",entityId);
        args.put("range","20");
        args.put("pageno","3");
        paramMap.put("args",args.toJSONString());
        JSONObject result = companyQueryService.getDataByHttp(baseUrl,paramMap);
        if(result!=null) {
            JSONArray results = result.getJSONArray("allList");
            //将数据写入文件
            writeFile(dataType, results);
        }*/
    }

    /**
     * 根据数据类型写入文件中
     * @param dataType
     * @param results
     */
    @Override
    public void writeFile(String dataType, JSONArray results) {
        for (int i=0;i<results.size();i++){

        }
        switch (dataType){
            case DataTypeConstant.EPBPARTY:
                break;
            case DataTypeConstant.EPBPARTY_JKQY:
                break;
            case DataTypeConstant.EPBPARTY_ZXJC:
                break;
            case DataTypeConstant.SATPARTY_QS:
                break;
            case DataTypeConstant.SATPARTY_CHUFA:
                break;
            case DataTypeConstant.SATPARTY_FZC:
                break;
            case DataTypeConstant.SATPARTY_XIN:
                break;
            case DataTypeConstant.SATPARTY_REG:
                break;
            case DataTypeConstant.SATPARTY_XUKE:
                break;
            case DataTypeConstant.CPWS:
                break;
            case DataTypeConstant.KTGG:
                break;
            case DataTypeConstant.ZXGG:
                break;
            case DataTypeConstant.SHIXIN:
                break;
            case DataTypeConstant.FYGG:
                break;
            case DataTypeConstant.AJLC:
                break;
            case DataTypeConstant.BGT:
                break;
            case DataTypeConstant.SIFACDK:
                break;
            default:
                break;

        }
    }


}
