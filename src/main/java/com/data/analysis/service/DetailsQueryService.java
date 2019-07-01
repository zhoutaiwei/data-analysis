package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 环保数据服务接口
 */
public interface DetailsQueryService {
    /**
     * 获取环保详情数据
     * @param dataType
     * @return
     */
    public JSONObject getEPDetailsQueryData(String entityId);


    public  void writeFileAndDB(String dataType,JSONObject result);


}
