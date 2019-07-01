package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 司法查冻扣
 */
@Data
@ToString
public class Sifacdk {
    private String   sifacdkId; //司法查冻扣ID  司法查冻扣唯一的标识
    private String   body; //正文
    private String   sortTime; //审结时间  yyyy/mm/dd
    private String   eventDate; //事件日期  yyyy/mm/dd
    private String   objectName; //标的名称
    private String   court; //审理法院
    private String   pname; //当事人
    private String   title; //标题
    private String   action; //资产类别
    private String    caseNo; //案号
    private String    objectType; //标的类型  1，资金；2，车辆；3，房产；4，林产；5，专利；6，商标；7，不动产；
    private String    postTime; //发布时间  yyyy/mm/dd
    private String    money; //金额（元）
    private String    eventLevel; //五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String    dataType; //数据类型
}
