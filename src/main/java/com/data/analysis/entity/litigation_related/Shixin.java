package com.data.analysis.entity.litigation_related;


import lombok.Data;
import lombok.ToString;

/**
 * 失信公告
 */
@ToString
@Data
public class Shixin {
    private String  shixinId;//失信公告ID  失信公告唯一标识
    private String   age;//年龄
    private String   caseNo;//案号
    private String   court;//法院名称
    private String   jtqx;//具体情形  失信被执行人具体情形
    private String   pname;//名称  失信被执行企业名称/姓名
    private String   idcardNo;//身份证号码
    private String   postTime;//发布时间
    private String   province;//省份
    private String    sortTime;//立案时间
    private String    yiwu;//义务  生效法律文书确定的义务
    private String    yjCode;//依据文号  执行依据文号
    private String    dataType;//数据类型
    private String    eventLevel;//五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String    lxqk;//履行情况  失信被执行人履行情况；全部未履行/部分未履行/全部已履行等文字描述
    private String    caseNoKword;//代字  执等
    private String    courtTypeS;//法院类型  全国四级法院/海事法院/军事法院等
}
