package com.data.analysis.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString
public class CompanyCaseEntity {
    //案由
    private String anyou;
    //案号
    private String caseNo;
    //法院
    private String court;
    //金额
    private Double resultAmount;
    //当前记录所属维度
    private String resultDataType;
    //当前记录ID
    private String resultEntryId;
    //监控结果等级
    private Integer resultLevel;
    //监控企业名
    private String resultName;
    //记录摘要
    private String resultSummary;
    //监控结果时间

    private Date  resultYmd;
    //创建人
    private String createdBy;
    //创建时间

    private Date createTime;
    //更新人
    private String updatedBy;
    //更新时间

    private Date updateTime;

}
