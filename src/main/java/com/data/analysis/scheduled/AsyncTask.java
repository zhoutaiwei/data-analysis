package com.data.analysis.scheduled;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.mapper.DBMapper;
import com.data.analysis.service.DataHandleService;
import com.data.analysis.service.impl.HttpServiceImpl;
import com.data.analysis.utils.Object2ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class AsyncTask {


    @Autowired
    DataHandleService dataHandleService;


    /**
     * 异步执行多线程
     * @return
     * @throws Exception
     */
    @Async("taskExecutor")
    public void  doTask(String dataType,int pageNo)  {
        long start = System.currentTimeMillis();
        switch (dataType){
            case DataTypeConstant.COMPANY_CASE:
                dataHandleService.handleCompanyCateTask(pageNo);
                break;
            case DataTypeConstant.LITIGATION_RELATED:
                dataHandleService.litigationRelatedTask(pageNo);
                break;
        }



        long end = System.currentTimeMillis();
        log.info("当前线程号："+Thread.currentThread().getId()+"--耗时:" + (end - start) + "毫秒");
    }

}
