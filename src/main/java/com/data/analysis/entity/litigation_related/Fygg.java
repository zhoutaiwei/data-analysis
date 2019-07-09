package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 法院公告
 */
@Data
@ToString
public class Fygg {
    private String   fyggId; //法院公告  法院公告唯一标识
    private String   body; //内容
    private String   court; //法院名称
    private String   layout; //版面
    private String   pname; //当事人名称  企业名称/姓名
    private String   sortTime; //立案时间
    private String   title; //标题
    private String   dataType; //数据类型
    private String   matchRatio;//个人匹配度
    private String   ggType; //公告类型
    private String    eventLevel; //五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String    caseNo; //案号
    private String    caseNoKword; //代字  民初、民终等
}
