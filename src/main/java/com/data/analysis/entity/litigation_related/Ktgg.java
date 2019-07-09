package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 开庭公告
 */
@Data
@ToString
public class Ktgg {
    private String  ktggId; //开庭公告ID 开庭公告唯一的标识
    private String  body; //内容
    private String  caseCause; //案由
    private String  caseNo; //案号
    private String  court; //法院名称
    private String  defendant; //被告
    private String  plaintiff; //原告
    private String  pname; //当事人
    private String  sortTime; //开庭时间
    private String  title; //标题
    private String  dataType; //数据类型
    private String  eventLevel; //五级分类 警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String   matchRatio;//个人匹配度
    private String  caseNoKword ; //代字 民初、民终等
    private String  courtTypeS; //法院类型 全国四级法院/海事法院/军事法院等
}
