package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 案件流程
 */
@Data
@ToString
public class Ajlc {
    private String   ajlcId; //案件流程ID  案件流程唯一标识
    private String   body; //内容
    private String   caseCause; //案由
    private String   caseNo; //案号
    private String   court; //法院名称
    private String   organizer; //组织者  组织者/承办单位
    private String   pname; //当事人名称  企业名称/姓名
    private String   sortTime; //案件时间  立案、 结案、 归档、 审理
    private String   dataType; //数据类型
    private String   ajlcStatusS; //审理状态  结案/归档/审理/报结/排期/立案受理/中止审理
    private String   matchRatio;//个人匹配度
    private String   eventLevel; //五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String   caseNoKword; //代字  民初、民终等
    private String   courtTypeS; //法院类型  全国四级法院/海事法院/军事法院等
}
