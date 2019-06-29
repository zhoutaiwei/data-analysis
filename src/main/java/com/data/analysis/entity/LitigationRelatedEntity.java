package com.data.analysis.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class LitigationRelatedEntity {

    //公司名称
    private String body;
    //数据类型
    private String dataType;

    private String entryId;
    private Long sortTime;
    private String sortTimeString;
    private String title;
    //创建人
    private String createdBy;
    //创建时间

    private Date createTime;
    //更新人
    private String updatedBy;
    //更新时间

    private Date updateTime;

}
