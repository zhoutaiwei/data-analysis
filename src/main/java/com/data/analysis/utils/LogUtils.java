package com.data.analysis.utils;

import com.csvreader.CsvWriter;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.scheduled.TimeScheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class LogUtils {
    static String  topic="URL,状态,请求耗时,错误信息,请求发送时间";

    @Value("${csv.file.log-path}")
    String path;
    @Autowired
    FileUtils fileUtils;
    /**
     * 记录请求情况
     * URL 状态 时间 错误信息 请求发送时间
     */
    @Async
    public  void writeLog(String url,Integer  status,Long requestTime,String message,String requestDate){
//获取任务执行时的时间，用于拼接文件路径
        Long currentTime = TimeScheduled.currentTime;
        //获取月份
        String month = CSVMapper.getMonthByDateStamp(currentTime);
        path = path.replace("#month",month);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String logName = format.format(new Date(TimeScheduled.currentTime));
        path=path.replace("#log",logName);
        CsvWriter cw = null;
        String[] header = topic.split(",");
        try {
            File file = new File(path);
            if(!file.exists()){
                fileUtils.createFile(path,header,file);
            }
            //追加文件内容
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "GBK"), 1024);
            cw = new CsvWriter(out, ',');
            cw.writeRecord(new String[]{url,status+"",requestTime+"",message,requestDate});
        } catch (IOException e) {
            log.error("找不到CVS文件",e);
        } finally {
            if (cw != null) {
                cw.close();
            }
        }
    }
}
