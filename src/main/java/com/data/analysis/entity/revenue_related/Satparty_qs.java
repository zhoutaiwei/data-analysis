package com.data.analysis.entity.revenue_related;

import lombok.Data;
import lombok.ToString;

/**
 * 欠税公告
 */
@ToString
@Data
public class Satparty_qs {
    private String    satparty_qsId; // 欠税公告ID  欠税公告唯一标识
    private String    authority; // 局（政府单位）  税务局
    private String    body; // 内容
    private String    eventName; // 事件名称
    private String    legalRepresentative; // 企业法定代表人
    private String    lrIdcard; // 法人身份证号码
    private String    money; // 欠税金额
    private String    pname; // 企业名称
    private String    postTime; // 发布时间
    private String     sortTime; // 欠税时间
    private String     taxCategory; // 税种
    private String     taxpayerId; // 税务登记号
    private String     title; // 标题
    private String     dataType; // 数据类型
    // 税务局等级  1：国税总局 2：省级（国税、地税） 3：地市级（国税、地税） 4：区县级（国税、地税）
    // 5：基层税务分局（所）（国税、地税） 6：其他   16  eventLevel  五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String     authorityRank;
    private String     eventLevel; // 五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2

}
