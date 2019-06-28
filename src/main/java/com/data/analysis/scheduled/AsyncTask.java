package com.data.analysis.scheduled;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.mapper.DBMapper;
import com.data.analysis.service.HttpService;
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
    HttpService dataService;
    @Autowired
    Object2ArrayUtils object2ArrayUtils;
    @Autowired
    CSVMapper csvMapper;
    @Autowired
    DBMapper dbMapper;

    /**
     * 异步执行多线程
     * @return
     * @throws Exception
     */
    @Async("taskExecutor")
    public void  doTask(int pageNo)  {
        long start = System.currentTimeMillis();

        JSONObject result = dataService.GetDataByHttp(pageNo);
        if(result!=null){
            JSONArray jsonArray = result.getJSONArray("allList");
            List<String []> csvEntitys=new ArrayList<>();
            List<CompanyCaseEntity> dbEntitys = new ArrayList<>();
            for (int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //将json转为对象，
                CompanyCaseEntity entity = JSONObject.toJavaObject(jsonObject, CompanyCaseEntity.class);
                //将数组添加到集合中，用于写入csv文件
                csvEntitys.add(object2ArrayUtils.object2ArrayUtils(entity));
                //将对象加入集合，用于写入数据库
                //指定数据的创建时间和创建人
                entity.setCreateTime(new Date());
                entity.setCreatedBy("admin");
                dbEntitys.add(entity);
            }
            csvMapper.writeCSVFile(csvEntitys);

            dbMapper.insertData(dbEntitys);
            log.info("第{}页数据写入csv文件结束，写入数据库结束",pageNo);
        }else {
            log.info("第{}页数据获取失败",pageNo);
        }
        long end = System.currentTimeMillis();
        log.info("当前线程号："+Thread.currentThread().getId()+"--耗时:" + (end - start) + "毫秒");
    }
}
