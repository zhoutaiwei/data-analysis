package com.data.analysis.entity.env_protection;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 环保处罚
 */
@ToString
@Data
public class Epbparty {
    private String   epbpartyId; // 环保处罚ID  环保处罚唯一标识
    private String   authority; // 局（政府单位）
    private String   body; // 内容
    private String   caseNo; // 案号
    private String   eventResult; // 事件结果
    private String   eventYiju; // 事件依据
    private String   legalRepresentative; // 企业法定代表人
    private String   money; // 处罚金额
    private String   pname; // 企业名称
    private Date postTime; // 发布时间
    private Long   sortTime; // 处罚时间
    private String   title; // 标题
    private String   dataType; // 数据类型
    private String   eventLevel; // 五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String   eventName; // 事件名称（类型）  1、罚款；2、整改；3、停产；4、环保税；5、行政拘留；6、行政处罚；7、完善备案；8、投诉举报；9、其他；
}
