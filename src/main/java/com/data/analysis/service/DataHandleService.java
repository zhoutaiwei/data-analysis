package com.data.analysis.service;

public interface DataHandleService {


    /**
     * 处理公司案件数据，对数据进行入库和写入文件
     * @param pageNo
     */
    void handleCompanyCateTask(int pageNo);

    /**
     * 处理涉诉数据，对数据进行入库和写入文件
     * @param pageNo
     */
    void litigationRelatedTask(int pageNo);

    /**
     * 处理涉税数据，对数据进行入库和写入文件
     * @param pageNo
     */
    void revenueRelatedTask(int pageNo);
    /**
     * 处理环保数据，对数据进行入库和写入文件
     * @param pageNo
     */
    void envProtectionTask(final int pageNo);


}
