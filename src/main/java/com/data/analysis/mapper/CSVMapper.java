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

    @Value("${csv.file.epbparty-path}")
    private String epbpartyPath;
    @Value("${csv.file.epbparty-jkqy-path}")
    private String epbpartyJkqyPath;
    @Value("${csv.file.epbparty-zxjc-path}")
    private String epbpartyZxjcPath;
    @Value("${csv.file.satparty-qs-path}")
    private String satpartyQsPath;
    @Value("${csv.file.satparty-chufa-path}")
    private String  satpartyChufaPath;
    @Value("${csv.file.satparty-xin-path}")
    private String satpartyXinPath;
    @Value("${csv.file.satparty-reg-path}")
    private String satpartyRegPath;
    @Value("${csv.file.satparty-xuke-path}")
    private String satpartyXukePath;
    @Value("${csv.file.cpws-path}")
    private String cpwsPath;
    @Value("${csv.file.ktgg-path}")
    private String ktggPath;
    @Value("${csv.file.zxgg-path}")
    private String zxggPath;
    @Value("${csv.file.shixin-path}")
    private String shixinPath;
    @Value("${csv.file.fygg-path}")
    private String fyggPath;
    @Value("${csv.file.ajlc-path}")
    private String ajlcPath;
    @Value("${csv.file.bgt-path}")
    private String bgtPath;
    @Value("${csv.file.sifacdk-path}")
    private String sifacdkPath;

    @Value("${csv.file.epbparty-title}")
    private String epbpartyTitle;
    @Value("${csv.file.epbparty-jkqy-title}")
    private String epbpartyJkqyTitle;
    @Value("${csv.file.epbparty-zxjc-title}")
    private String epbpartyZxjcTitle;
    @Value("${csv.file.satparty-qs-title}")
    private String satpartyQsTitle;
    @Value("${csv.file.satparty-chufa-title}")
    private String  satpartyChufaTitle;
    @Value("${csv.file.satparty-xin-title}")
    private String satpartyXinTitle;
    @Value("${csv.file.satparty-reg-title}")
    private String satpartyRegTitle;
    @Value("${csv.file.satparty-xuke-title}")
    private String satpartyXukeTitle;
    @Value("${csv.file.cpws-title}")
    private String cpwsTitle;
    @Value("${csv.file.ktgg-title}")
    private String ktggTitle;
    @Value("${csv.file.zxgg-title}")
    private String zxggTitle;
    @Value("${csv.file.shixin-title}")
    private String shixinTitle;
    @Value("${csv.file.fygg-title}")
    private String fyggTitle;
    @Value("${csv.file.ajlc-title}")
    private String ajlcTitle;
    @Value("${csv.file.bgt-title}")
    private String bgtTitle;
    @Value("${csv.file.sifacdk-title}")
    private String sifacdkTitle;


    public void  writeEpbparty(String[] values){
        writeCSVFile(epbpartyPath,epbpartyTitle,values);
    }
    public void  writeEpbpartyJkqy(String[] values){
        writeCSVFile(epbpartyJkqyPath,epbpartyJkqyTitle,values);
    }
    public void  writeEpbpartyZxjc(String[] values){
        writeCSVFile(epbpartyZxjcPath,epbpartyZxjcTitle,values);
    }
    public void  writeSatpartyQs(String[] values){
        writeCSVFile(satpartyQsPath,satpartyQsTitle,values);
    }
    public void  writeSatpartyChufa(String[] values){
        writeCSVFile(satpartyChufaPath,satpartyChufaTitle,values);
    }
    public void  writeSatpartyXin(String[] values){
        writeCSVFile(satpartyXinPath,satpartyXinTitle,values);
    }
    public void  writeSatpartyReg(String[] values){
        writeCSVFile(satpartyRegPath,satpartyRegTitle,values);
    }
    public void  writeSatpartyXuke(String[] values){
        writeCSVFile(satpartyXukePath,satpartyXukeTitle,values);
    }
    public void  writeCpws(String[] values){
        writeCSVFile(cpwsPath,cpwsTitle,values);
    }
    public void  writeKtgg(String[] values){
        writeCSVFile(ktggPath,ktggTitle,values);
    }
    public void  writeZxgg(String[] values){
        writeCSVFile(zxggPath,zxggTitle,values);
    }
    public void  writeShixin(String[] values){
        writeCSVFile(shixinPath,shixinTitle,values);
    }
    public void  writeFygg(String[] values){
        writeCSVFile(fyggPath,fyggTitle,values);
    }
    public void  writeAjlc(String[] values){
        writeCSVFile(ajlcPath,ajlcTitle,values);
    }
    public void  writeBgt(String[] values){
        writeCSVFile(bgtPath,bgtTitle,values);
    }
    public void  writeSifacdk(String[] values){
        writeCSVFile(sifacdkPath,sifacdkTitle,values);
    }
    /**
     * 负责写入文件
     * @param path
     * @param title
     * @param values
     */
    public void writeCSVFile(String path,String title,String[] values){

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
                cw.writeRecord(values);
        } catch (IOException e) {
            log.error("找不到CVS文件",e);
        } finally {
            if (cw != null) {
                cw.close();
            }
        }

    }
}
