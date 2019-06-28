package com.data.analysis.mapper;

import com.data.analysis.entity.CompanyCaseEntity;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class Provider {

    /**
     * 拼接插入语句
     * @param map
     * @return
     */
    public String batchInsert(Map map) {

        List<CompanyCaseEntity> students = (List<CompanyCaseEntity>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO company")
        .append("(anyou,case_no,court,result_amount," +
                "result_data_type,result_entry_id,result_level," +
                "result_name,result_summary,result_ymd," +
                "created_by,create_time)")
        .append("VALUES ");
        MessageFormat mf = new MessageFormat("(" +
                "#'{'list[{0}].anyou}, " +
                "#'{'list[{0}].caseNo}, " +
                "#'{'list[{0}].court}, " +
                "#'{'list[{0}].resultAmount}, " +
                "#'{'list[{0}].resultDataType}," +
                "#'{'list[{0}].resultEntryId}, " +
                "#'{'list[{0}].resultLevel}, " +
                "#'{'list[{0}].resultName}, " +
                "#'{'list[{0}].resultSummary}, " +
                "#'{'list[{0}].resultYmd}, " +
                "#'{'list[{0}].createdBy}, " +
                "#'{'list[{0}].createTime})");
        for (int i = 0; i < students.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < students.size() - 1) sb.append(",");
        }
        return sb.toString();
    }

}
