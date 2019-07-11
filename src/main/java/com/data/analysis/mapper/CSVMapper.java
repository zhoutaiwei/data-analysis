package com.data.analysis.mapper;

import com.csvreader.CsvWriter;
import com.data.analysis.scheduled.TimeScheduled;
import com.data.analysis.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 写入CSV文件
 */
@Repository
@Slf4j
public class CSVMapper {

    @Autowired
    FileUtils fileUtils;
    /**
     * 负责写入文件
     * @param path
     * @param title
     * @param values
     */

    public synchronized void writeCSVFile(String path,String title,String[] values){
        //获取任务执行时的时间，用于拼接文件路径
        Long currentTime = TimeScheduled.currentTime;
        //获取日
        String day=CSVMapper.getDayByDateStamp(currentTime);
        path = path.replace("#day",day);
        CsvWriter cw = null;
        String[] header = title.split(",");
        try {
            cw = new CsvWriter(path, ',', Charset.forName("GBK"));
            File file = new File( path);
            if(!file.exists()){
                fileUtils.createFile(path,header,file);
            }

            //追加文件内容
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "GBK"), 1024);
            cw = new CsvWriter(out, ',');
                cw.writeRecord(values);
        } catch (IOException e) {
            log.error("找不到CVS文件",e);
        } finally {
            if (cw != null) {
                cw.close();
            }
        }
    }

    /**
     * 根据时间戳获取年月
     * @param time
     * @return
     */
    public static String getMonthByDateStamp(Long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        return format.format(new Date(time));
    }
    /**
     * 根据时间戳获取日
     * @param time
     * @return
     */
    public static   String getDayByDateStamp(Long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date(time));
    }


}
