package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.service.CompanyQueryService;
import com.data.analysis.service.DetailsQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DetailsQueryServiceImpl implements DetailsQueryService {
    @Autowired
    CompanyQueryService companyQueryService;

    String uri ="https://api.fahaicc.com/v2/entry/epbparty";

    @Override
    public JSONObject getEPDetailsQueryData(String entityId) {
        //构建参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("authCode",DataTypeConstant.authCOde);
        String rt = String.valueOf(System.currentTimeMillis());
        paramMap.put("rt",rt);
        String autoCode = DataTypeConstant.authCOde;
        String uid = DataTypeConstant.uid;
        return companyQueryService.getDataByHttp(uri,paramMap);
    }

    /**
     * 根据数据类型写入不同的库
     * @param dataType
     * @param result
     */
    @Override
    public void writeFileAndDB(String dataType, JSONObject result) {
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
