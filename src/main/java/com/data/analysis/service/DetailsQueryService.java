package com.data.analysis.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 环保数据服务接口
 */
public interface DetailsQueryService {
    /**
     * 获取环保详情数据
     * @param entityId
     * @return
     */
    public void getEPDetailsQueryData(String entityId,String dataType);


    public  void writeFile(String dataType,JSONArray results);


}
