package com.data.analysis.entity.revenue_related;

import lombok.Data;
import lombok.ToString;

/**
 * 涉税处罚公示
 */
@Data
@ToString
public class Satparty_chufa {
    private String    satparty_chufaId; // 涉税处罚公示ID  涉税处罚公示唯一标识
    private String    authority; // 局（政府单位）  税务局
    private String    body; // 内容
    private String    eventResult; // 事件结果
    private String    legalRepresentative; // 企业法定代表人
    private String    lrIdcard; // 法人身份证号码
    private String    money; // 处罚金额
    private String    pname; // 企业名称
    private String    postTime; // 发布时间
    private String     sortTime; // 处罚时间
    private String     taxpayerId; // 税务登记号
    private String     title; // 标题
    private String     dataType; // 数据类型
    // 五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2  15  eventName  事件名称  1，罚款；2，没收非法所得；3，
    // 限期整改；4，违反税管法；5，其他；6；基本类型组合
    private String     eventLevel;

}
