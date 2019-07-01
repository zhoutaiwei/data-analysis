package com.data.analysis.entity.litigation_related;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.ToString;

/**
 * 审判文书
 */
@Data
@ToString
public class Cpws {
    //裁判文书ID,裁判文书唯一标识
    private String cpwsId;
    //内容
    private String body;
    //案由
    private String caseCause;
    //案号
    private String caseNo;
    //法院名称
    private String court;
    //审判员
    private String judge;
    //判决结果
    private String judgeResult;
    //审结时间
    private String sortTime;
    //标题
    private String title;
    //审理程序,一审/二审/再审/执行
    private String trialProcedure;
    // 依据
    private String yiju;
    //数据类型
    private String dataType;
    //当事人,参照当事人数据字典
    private JSONArray partys;
    //法院等级
    private String courtRank;
    //五级分类,警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String eventLevel;
    //法院类型,全国四级法院/海事法院/军事法院等
    private String courtTypeS;
    //代字,民初、民终等
    private String caseNoKword;
    //文书类型,民事判决书/民事裁定书等
    private String caseTypeS;

}
