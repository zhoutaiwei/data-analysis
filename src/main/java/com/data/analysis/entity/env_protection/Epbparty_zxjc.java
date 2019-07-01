package com.data.analysis.entity.env_protection;

import lombok.Data;
import lombok.ToString;

/**
 * 企业自行检测结果
 */
@ToString
@Data
public class Epbparty_zxjc {
    private String   epbparty_zxjcId; //企业自行检测结果ID  环保企业自行监测结果唯一标识
    private String   creditNo; // 企业ID/组织机构代码/统一社会信用代码
    private String   dealWay; //污染物排放方式
    private String   dealWhere; // 排放方向
    private String   density; // 监测结果
    private String   eventResult; // 事件结果
    private String   monitorWay; // 监测方式
    private String   pname; // 企业名称
    private String   pollutant; // 监测指标/污染项目
    private String    sortTime; // 监测时间
    private String    standard; // 标准限值
    private String    station; // 监测点位名称
    private String    dataType; // 数据类型
}
