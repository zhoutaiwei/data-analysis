package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 执行公告
 */
@Data
@ToString
public class Zxgg {
    private String  zxggId ; //执行公告ID  执行公告唯一标识
    private String  address ; //地址
    private String  body ; //内容
    private String  caseNo ; //案号
    private String  closeDate; // 终本日期
    private String  court ; //法院名称
    private String  execMoney ; //执行金额  执行标的
    private String  idcardNo ; //身份证号码
    private String  pname ; //名称  被执行企业名称/姓名
    private String  proposer ; //申请人  提案人
    private String  sortTime ; //立案日期
    private String  title ; //标题
    private String  dataType; // 数据类型
    private String   matchRatio;//个人匹配度
    private String  eventLevel ; //五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String  caseNoKword; // 代字  执恢、执等
    private String  courtTypeS; // 法院类型  全国四级法院/海事法院/军事法院等
}
