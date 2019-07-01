package com.data.analysis.entity.revenue_related;

import lombok.Data;
import lombok.ToString;

/**
 * 纳税信用等级
 */
@Data
@ToString
public class Satparty_xin {
    private String    satparty_xinId; // 纳税信用等级ID  纳税信用等级唯一标识
    private String    authority; // 局（政府单位）
    private String    body; // 内容
    private String    eventResult; // 事件结果（级别）  A：A级信用 B：B级信用 M：M级信用 C：C级信用 D：D级信用
    private String    legalRepresentative; // 企业法定代表人
    private String    pname; // 企业名称
    private String    postTime; // 发布时间
    private String    sortTime; // 评定时间
    private String    taxpayerId; // 税务登记号
    private String     title; // 标题
    private String     dataType; // 数据类型
    private String     eventLevel; // 五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
}
