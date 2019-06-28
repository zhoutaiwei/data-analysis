package com.data.analysis.scheduled;

import com.data.analysis.service.HttpService;
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
    HttpService dataService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    AsyncTask asyncTask;
    // 定义每过10秒执行任务
    @Scheduled(fixedRate = 100000)
    public void reportCurrentTime() throws Exception {
        log.info("开始执行处理任务...");
        long start = System.currentTimeMillis();
        //获取总页数
        Integer totalCount = dataService.getTotalCount();
        if(totalCount<=0){
            log.info("调用接口返回结果失败！获取数据总页数失败。");
            return;
        }
        //开始调度多线程任务
        for(int i=1;i<=totalCount;i++) {
            asyncTask.doTask(i);
        }

        long end = System.currentTimeMillis();
        log.info("本次任务共耗时:{} 毫秒",end-start);
    }
}
