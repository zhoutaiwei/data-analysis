package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;

public interface HttpService {
    /**
     * 获取公司案件
     * @param pageNo
     * @return
     */
    JSONObject getCompanyCase(int pageNo);
    /**
     * 获取公司案件返回的总页数
     * @return
     */
    int getCompanyCaseTotalPage();

    /**
     * 获取涉诉标准数据
     * @param pageNo
     * @return
     */
    JSONObject getLitigationRelated(int pageNo);

    /**
     * 获取涉诉标准数据的总页数
     * @return
     */
    int getLitigationRelatedTotalPage();
}
