package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

/**
 * 曝光台
 */
@ToString
@Data
public class Bgt {
    private String  bgtId; //曝光台ID  曝光台唯一标识
    private String  address; //地址
    private String  body; //内容
    private String  caseCause; //案由
    private String  caseNo; //案号
    private String  court; //法院名称
    private String  idcardNo; //身份证号码
    private String  pname; //当事人名称  企业名称/姓名
    private String  proposer; //申请人  提案人
    private String   sortTime; //立案时间
    private String   yiju; //依据
    private String   dataType; //数据类型
    private String   matchRatio;//个人匹配度
    private String   eventLevel; //五级分类  警告：-2，负向：-1，中性：0，正向：1，利好：2
    private String   execMoney; //标的金额
    private String   caseNoKword; //代字  执
    private String   courtTypeS; //法院类型  全国四级法院/海事法院/军事法院等
}
