package com.data.analysis.scheduled;

import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.service.impl.CompanyQueryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 定时调度类，用于定时调度多线程任务
 */
@Slf4j
@Component
public class TimeScheduled {

    @Autowired
    CompanyQueryServiceImpl dataService;

    @Autowired
    AsyncTask asyncTask;
    public static Long currentTime;

   //@Scheduled(fixedRate = 10*3600*1000,initialDelay = 10)
    @Scheduled(cron = "0 0 23 * * ?")
    //@Scheduled(cron = "0 50 9 * * ?")
    public void ExecuteCompanyCaseTask() throws Exception {
        log.info("开始执行处理任务...");
       currentTime = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        //获取总页数
        int totalCount = dataService.getTotalPage();
        //执行多线程任务
        executer(totalCount);
        long end = System.currentTimeMillis();
        log.info("本次任务共耗时:{} 毫秒",end-start);
    }

 /*   // 定义每过10秒执行处理涉诉标准数据数据任务
  //  @Scheduled(fixedRate = 100000)
    public void ExecuteLitigationRelatedTask() throws Exception {
        log.info("开始执行处理任务...");
        long start = System.currentTimeMillis();
        //获取总页数
        int totalCount = dataService.getLitigationRelatedTotalPage();
        //执行多线程任务
        executer(DataTypeConstant.LITIGATION_RELATED,totalCount);
        long end = System.currentTimeMillis();
        log.info("本次任务共耗时:{} 毫秒",end-start);
    }

    // 定义每过10秒执行处理涉税标准数据数据任务
   // @Scheduled(fixedRate = 100000)
    public void ExecuteRevenueRelatedTask() throws Exception {
        log.info("开始执行处理任务...");
        long start = System.currentTimeMillis();
        //获取总页数
        int totalCount = dataService.getRevenueRelatedTotalPage();
        //执行多线程任务
        executer(DataTypeConstant.REVENUE_RELATED,totalCount);
        long end = System.currentTimeMillis();
        log.info("本次任务共耗时:{} 毫秒",end-start);
    }
    // 定义每过10秒执行处理环保标准数据数据任务
//    @Scheduled(fixedRate = 100000)
    public void ExecuteEnvProtectiondTask() throws Exception {
        log.info("开始执行处理任务...");
        long start = System.currentTimeMillis();
        //获取总页数
        int totalCount = dataService.getEnvProtectionTotalPage();
        //执行多线程任务
        executer(DataTypeConstant.ENV_PROTECTION,totalCount);
        long end = System.currentTimeMillis();
        log.info("本次任务共耗时:{} 毫秒",end-start);
    }*/


    /**
     * //执行多线程任务
     * @param totalCount
     */
    public void executer(int totalCount){
        if(totalCount<=0){
            log.info("调用接口返回结果失败！获取数据总页数失败。");
            return;
        }
        //开始调度多线程任务
        for(int i=1;i<=totalCount;i++) {
            asyncTask.doTask(i);
        }
    }
}
