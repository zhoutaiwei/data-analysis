package com.data.analysis.entity.litigation_related;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PartyDictionary {

    private  String cpwsId;//判决文书
    private  String partyType; //当事人类型
    private  String pname;//当事人名称
    private  String birthday;//当事人出生日期
    private  String partyPosition;//当事人立场
    private  String title;//当事人称号
}
