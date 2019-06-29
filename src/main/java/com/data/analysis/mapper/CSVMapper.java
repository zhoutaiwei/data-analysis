package com.data.analysis.mapper;

import com.csvreader.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 写入CSV文件
 */
@Repository
@Slf4j
public class CSVMapper {

    @Value("${csv.file.company-case-path}")
    private String companyCasePath;
    @Value("${csv.file.litigation-related-path}")
    private String litigationRelatedPath;


    @Value("${csv.file.company-case-title}")
    private String companyCaseTitle;


    @Value("${csv.file.litigation-related-title}")
    private String litigationRelatedTitle;

    /**
     * 写入涉案数据
     * @param values
     */
    @Async
    public void  writeLitigationRelatedCSVFile(List<String[]> values){
        writeCSVFile(litigationRelatedPath,litigationRelatedTitle,values);
    }


    /**
     * 写入公司案件数据
     */
    @Async
    public void  writeCompanyCaseCSVFile(List<String[]> values){
        writeCSVFile(companyCasePath,companyCaseTitle,values);
    }


    /**
     * 负责写入文件
     * @param path
     * @param title
     * @param values
     */
    public void writeCSVFile(String path,String title,List<String[]> values){

        CsvWriter cw = null;
        String[] header = title.split(",");
        try {
            cw = new CsvWriter(path, ',', Charset.forName("GBK"));
            File file = new File(path);
            //如果文件不存在则创建文件并制定行头
            if (!file.exists()) {
                file.createNewFile();
                cw.writeRecord(header);
                cw.close();
            }
            //追加文件内容
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "GBK"), 1024);
            cw = new CsvWriter(out, ',');
            for (String[] value : values) {
                cw.writeRecord(value);
            }
        } catch (IOException e) {
            log.error("找不到CVS文件",e);
        } finally {
            if (cw != null) {
                cw.close();
            }
        }

    }
}
