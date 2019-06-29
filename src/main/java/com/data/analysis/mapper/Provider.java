package com.data.analysis.mapper;

import com.data.analysis.entity.CompanyCaseEntity;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class Provider {

    /**
     * 拼接CompanyCase插入语句
     * @param map
     * @return
     */
    public String insertCompanyCase(Map map) {

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

    /**
     * 拼接LitigationRelated插入语句
     * @param map
     * @return
     */
    public String insertLitigationRelated(Map map) {
        List<CompanyCaseEntity> students = (List<CompanyCaseEntity>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO litigation_related")
                .append("(body,data_type,entry_id,sort_time,sort_time_string,title,created_by,create_time)")
                .append("VALUES ");
        MessageFormat mf = new MessageFormat("(" +
                "#'{'list[{0}].body}, " +
                "#'{'list[{0}].dataType}, " +
                "#'{'list[{0}].entryId}, " +
                "#'{'list[{0}].sortTime }, " +
                "#'{'list[{0}].sortTimeString}," +
                "#'{'list[{0}].title}, " +
                "#'{'list[{0}].createdBy}, " +
                "#'{'list[{0}].createTime})");
        for (int i = 0; i < students.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < students.size() - 1) sb.append(",");
        }
        return sb.toString();
    }

}
