package com.data.analysis.utils;

import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class Object2ArrayUtils {
    /**
     * 将CompanyCase对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] CompanyCaseObject2Array(CompanyCaseEntity entity){
        String anyou = entity.getAnyou();
        String no = entity.getCaseNo();
        String court = entity.getCourt();
        String amount = entity.getResultAmount().toString();
        String type = entity.getResultDataType();
        String entryId = entity.getResultEntryId();
        String level = entity.getResultLevel().toString();
        String name = entity.getResultName();
        String summary = entity.getResultSummary();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String resultYmd = format.format(entity.getResultYmd());
        String[] array = {anyou,no,court,amount,type,entryId,level,name,summary,resultYmd};
        return array;
    }

    /**
     * 将LitigationRelated对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] LItigationRelatedObject2Array(LitigationRelatedEntity entity){
        String company = entity.getBody();
        String type = entity.getDataType();
        String id = entity.getEntryId();
        String sortTime = entity.getSortTime().toString();
        String sortTimeString = entity.getSortTimeString();
        String title = entity.getTitle();
        String[] array = {company,type,id,sortTime,sortTimeString,title};
        return array;
    }

}
