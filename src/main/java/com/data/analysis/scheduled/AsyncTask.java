package com.data.analysis.scheduled;

import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.service.DataHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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
        dataHandleService.handleTask(pageNo);
       /* switch (dataType){
            case DataTypeConstant.COMPANY_CASE:
                dataHandleService.handleCompanyCateTask(pageNo);
                break;
            case DataTypeConstant.LITIGATION_RELATED:
                dataHandleService.litigationRelatedTask(pageNo);
                break;
            case DataTypeConstant.REVENUE_RELATED:
                dataHandleService.revenueRelatedTask(pageNo);
                break;
            case DataTypeConstant.ENV_PROTECTION:
                dataHandleService.envProtectionTask(pageNo);
                break;
            default:
                log.info("没有此模块！！！");
        }*/
        long end = System.currentTimeMillis();
        log.info("当前线程号："+Thread.currentThread().getId()+"--耗时:" + (end - start) + "毫秒");
    }

}
