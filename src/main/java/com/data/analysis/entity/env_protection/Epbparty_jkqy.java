package com.data.analysis.entity.env_protection;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 重点监控
 */
@Data
@ToString
public class Epbparty_jkqy {
    private String   epbparty_jkqyId; // 重点监控id  重点监控唯一标识
    private String   eventName; // 监控名称
    private String   eventType; // 监控类型
    private String   pname; // 涉事企业
    private String   dataType; // 数据类型

}
