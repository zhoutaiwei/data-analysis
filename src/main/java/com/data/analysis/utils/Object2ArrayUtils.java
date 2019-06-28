package com.data.analysis.utils;

import com.data.analysis.entity.CompanyCaseEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class Object2ArrayUtils {
    /**
     * 将json对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] object2ArrayUtils(CompanyCaseEntity entity){
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


}
