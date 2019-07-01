package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface CompanyQueryService {


    /**
     * 获取环保标准数据
     * @param pageNo
     * @return
     */
    JSONObject getStandardDataByPageNo(int pageNo);

    /**
     * 获取环保标准数据的总页数
     * @return
     */
    int getTotalPage();


    /**
     * 用於調用http接口
     * @param uri
     * @param param
     * @return
     */
    JSONObject getDataByHttp(String uri, Map<String, String> param);
}
