package com.data.analysis.entity.revenue_related;

import lombok.Data;
import lombok.ToString;

/**
 * 税务许可
 */
@Data
@ToString
public class Satparty_xuke {
    private String    satparty_xukeId; // 税务许可ID  税务许可唯一标识
    private String    authority; // 局（政府单位）  税务局
    private String    body; // 内容
    private String    eventName; // 事件名称
    private String    legalRepresentative; // 企业法定代表人
    private String    pname; // 企业名称
    private String    postTime; // 发布时间
    private String    sortTime; // 评定时间
    private String    taxpayerId; //税务登记号
    private String     title; // 标题
    private String     dataType; // 数据类型
    private String     eventLevel; // 五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
}
