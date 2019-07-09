package com.data.analysis.utils;

import com.csvreader.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
@Slf4j
public class FileUtils {
    public static void main(String[] args) {
        int i ,j ,cont=0;
        for (i=101;i<=300;i++){
            for (j=2;j<Math.sqrt(i);j++){
                if(i%j==0){

                    break;
                }
                if(j>Math.sqrt(i)-1){
                    cont++;
                    System.out.println(i);
                }
            }

        }
        System.out.println(cont);
    }
    /**
     * 用于创建文件夹和文件
     * @param path
     */
    public synchronized  void createFile(String path,String[] topic, File file ){
        CsvWriter cw = null;
        if((3/1)%2==0){}
        try {
            cw = new CsvWriter(path, ',', Charset.forName("GBK"));
            File parentFile = file.getParentFile();
            //如果文件不存在则创建文件并制定行头
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if(!file.exists()){
                file.createNewFile();
                cw.writeRecord(topic);
                cw.close();
            }
        } catch (IOException e) {
            log.error("文件创建失败",e);
        }

    }
}
