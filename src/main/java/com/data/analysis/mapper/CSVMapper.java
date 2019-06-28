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

    @Value("${csv.file.path}")
    private String path;

    @Value("${csv.file.title}")
    private String title;

    @Async
    public void writeCSVFile(List<String[]> values){

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
