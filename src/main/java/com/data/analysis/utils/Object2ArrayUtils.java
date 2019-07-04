package com.data.analysis.utils;

import com.alibaba.fastjson.JSONArray;
import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import com.data.analysis.entity.env_protection.Epbparty;
import com.data.analysis.entity.env_protection.Epbparty_jkqy;
import com.data.analysis.entity.env_protection.Epbparty_zxjc;
import com.data.analysis.entity.litigation_related.*;
import com.data.analysis.entity.revenue_related.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Object2ArrayUtils {

    /**
     * 将Satparty_xuke对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_xukeObject2Array(Satparty_xuke entity){
        String satparty_xukeId = entity.getSatparty_xukeId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventResult = entity.getEventName();
        String legalRepresentative = entity.getLegalRepresentative();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String authorityRank = entity.getEventLevel();
        return new String[]{satparty_xukeId,authority,body,eventResult,legalRepresentative,pname,postTime,sortTime
                ,taxpayerId,title,dataType,authorityRank};
    }

    /**
     * 将Satparty_xin对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_xinObject2Array(Satparty_xin entity){
        String satparty_xinId = entity.getSatparty_xinId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventResult = entity.getEventResult();
        String legalRepresentative = entity.getLegalRepresentative();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String authorityRank = entity.getEventLevel();
        return new String[]{satparty_xinId,authority,body,eventResult,legalRepresentative,pname,postTime,sortTime
                ,taxpayerId,title,dataType,authorityRank};
    }

    /**
     * 将satparty_reg对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_regObject2Array(Satparty_reg entity){
        String satparty_regId = entity.getSatparty_regId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventName = entity.getEventName();
        String eventResult = entity.getEventResult();
        String legalRepresentative = entity.getLegalRepresentative();
        String lrIdcard = entity.getLrIdcard();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String authorityRank = entity.getEventLevel();
        return new String[]{satparty_regId,authority,body,eventName,eventResult,legalRepresentative,lrIdcard,pname,postTime,sortTime
                ,taxpayerId,title,dataType,authorityRank};
    }

    /**
     * 将satparty_qs对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_qsObject2Array(Satparty_qs entity){
        String satparty_qsId = entity.getSatparty_qsId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventName = entity.getEventName();
        String legalRepresentative = entity.getLegalRepresentative();
        String lrIdcard = entity.getLrIdcard();
        String money = entity.getMoney();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxCategory = entity.getTaxCategory();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String authorityRank = entity.getAuthorityRank();
        return new String[]{satparty_qsId,authority,body,eventName,legalRepresentative,lrIdcard,money,pname,postTime,sortTime,taxCategory
                ,taxpayerId,title,dataType,authorityRank};
    }

    /**
     * 将 satparty_fzc对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_fzcObject2Array(Satparty_fzc entity){
        String satparty_fzcId = entity.getSatparty_fzcId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventName = entity.getEventName();
        String eventResult = entity.getEventResult();
        String legalRepresentative = entity.getLegalRepresentative();
        String lrIdcard = entity.getLrIdcard();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        return new String[]{satparty_fzcId,authority,body,eventName,eventResult,legalRepresentative,lrIdcard,pname,postTime,sortTime
                ,taxpayerId,title,dataType,eventLevel};
    }
    /**
     * 将satparty_chufa对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] satparty_chufaObject2Array(Satparty_chufa entity){
        String satparty_chufaId = entity.getSatparty_chufaId();
        String authority = entity.getAuthority();
        String body = entity.getBody();
        String eventResult = entity.getEventResult();
        String legalRepresentative = entity.getLegalRepresentative();
        String lrIdcard = entity.getLrIdcard();
        String money = entity.getMoney();
        String pname = entity.getPname();
        String postTime = entity.getPostTime();
        String sortTime = entity.getSortTime();
        String taxpayerId = entity.getTaxpayerId();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        return new String[]{satparty_chufaId,authority,body,eventResult,legalRepresentative,lrIdcard,money,pname,postTime,sortTime
                ,taxpayerId,title,dataType,eventLevel};
    }
    /**
     * 将zxgg对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] zxggObject2Array(Zxgg entity){
        String zxggId = entity.getZxggId();
        String address = entity.getAddress();
        String body = entity.getBody();
        String caseNo = entity.getCaseNo();
        String closeDate = entity.getCloseDate();
        String court = entity.getCourt();
        String execMoney = entity.getExecMoney();
        String idcardNo = entity.getIdcardNo();
        String pname = entity.getPname();
        String proposer = entity.getProposer();
        String sortTime = entity.getSortTime();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        String caseNoKword = entity.getCaseNoKword();
        String courtTypeS = entity.getCourtTypeS();
        return new String[]{zxggId,address,body,caseNo,closeDate,court,execMoney,idcardNo,pname,proposer,sortTime,title,dataType,eventLevel,
                caseNoKword,courtTypeS};
    }

    /**
     * 将sifacdk对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] sifacdkObject2Array(Sifacdk entity){
        String sifacdkId = entity.getSifacdkId();
        String body = entity.getBody();
        String sortTime = entity.getSortTime();
        String eventDate = entity.getEventDate();
        String objectName = entity.getObjectName();
        String court = entity.getCourt();
        String pname = entity.getPname();
        String title = entity.getTitle();
        String action = entity.getAction();
        String caseNo = entity.getCaseNo();
        String objectType = entity.getObjectType();
        String postTime = entity.getPostTime();
        String money = entity.getMoney();
        String eventLevel = entity.getEventLevel();
        String dataType = entity.getDataType();
        return new String[]{sifacdkId,body,sortTime,eventDate,objectName,court,pname,title,action,caseNo,objectType,postTime,money,eventLevel,
                dataType};
    }
    /**
     * 将shixin对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] shixinObject2Array(Shixin entity){
        String shixinId = entity.getShixinId();
        String age = entity.getAge();
        String caseNo = entity.getCaseNo();
        String court = entity.getCourt();
        String jtqx = entity.getJtqx();
        String pname = entity.getPname();
        String idcardNo = entity.getIdcardNo();
        String postTime = entity.getPostTime();
        String province = entity.getProvince();
        String sortTime = entity.getSortTime();
        String yiwu = entity.getYiwu();
        String yjCode = entity.getYjCode();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        String lxqk = entity.getLxqk();
        String caseNoKword = entity.getCaseNoKword();
        String courtTypeS = entity.getCourtTypeS();
        return new String[]{shixinId,age,caseNo,court,jtqx,pname,idcardNo,postTime,province,sortTime,yiwu,yjCode,dataType,eventLevel,
                lxqk,caseNoKword,courtTypeS};
    }

    /**
     * 将ktgg对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] ktggObject2Array(Ktgg entity){
        String ktggId = entity.getKtggId();
        String body = entity.getBody();
        String caseCause = entity.getCaseCause();
        String caseNo = entity.getCaseNo();
        String court = entity.getCourt();
        String defendant = entity.getDefendant();
        String plaintiff = entity.getPlaintiff();
        String pname = entity.getPname();
        String sortTime = entity.getSortTime();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        String caseNoKword = entity.getCaseNoKword();
        String courtTypeS = entity.getCourtTypeS();
        return new String[]{ktggId,body,caseCause,caseNo,court,defendant,plaintiff,pname,sortTime,title,dataType,eventLevel,
                caseNoKword,courtTypeS};
    }

    /**
     * 将fygg对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] fyggObject2Array(Fygg entity){
        String fyggId = entity.getFyggId();
        String body = entity.getBody();
        String court = entity.getCourt();
        String layout = entity.getLayout();
        String pname = entity.getPname();
        String sortTime = entity.getSortTime();
        String title = entity.getTitle();
        String dataType = entity.getDataType();
        String ggType = entity.getGgType();
        String eventLevel = entity.getEventLevel();
        String caseNo = entity.getCaseNo();
        String caseNoKword = entity.getCaseNoKword();
        return new String[]{fyggId,body,court,layout,pname,sortTime,title,dataType,ggType,eventLevel,caseNo,caseNoKword};
    }


    /**
     * 将cpws对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] cpwsObject2Array(Cpws entity){
        String bgtId = entity.getCpwsId();
        String body = entity.getBody();
        String caseCause = entity.getCaseCause();
        String caseNo = entity.getCaseNo();
        String court = entity.getCourt();
        String idcardNo = entity.getJudge();
        String pname = entity.getJudgeResult();
        String sortTime = entity.getSortTime();
        String title = entity.getTitle();
        String trialProcedure = entity.getTrialProcedure();
        String yiju = entity.getYiju();
        String dataType = entity.getDataType();
        JSONArray partys = entity.getPartys();
        String courtRank = entity.getCourtRank();
        String eventLevel = entity.getEventLevel();
        String courtTypeS = entity.getCourtTypeS();
        String caseNoKword = entity.getCaseNoKword();
        String caseTypeS = entity.getCaseTypeS();
        return new String[]{bgtId,body,caseCause,caseNo,court,idcardNo,pname,sortTime,title,trialProcedure,yiju,dataType,
                partys.toJSONString(),courtRank,eventLevel,courtTypeS,caseNoKword,caseTypeS};
    }

    /**
     * 将bgt对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] bgtObject2Array(Bgt entity){
        String bgtId = entity.getBgtId();
        String address = entity.getAddress();
        String body = entity.getBody();
        String caseCause = entity.getCaseCause();
        String caseNo = entity.getCaseNo();
        String court = entity.getCourt();
        String idcardNo = entity.getIdcardNo();
        String pname = entity.getPname();
        String proposer = entity.getProposer();
        String sortTime = entity.getSortTime();
        String yiju = entity.getYiju();
        String dataType = entity.getDataType();
        String eventLevel = entity.getEventLevel();
        String execMoney = entity.getExecMoney();
        String caseNoKword = entity.getCaseNoKword();
        String courtTypeS = entity.getCourtTypeS();
        return new String[]{bgtId,address,body,caseCause,caseNo,court,idcardNo,pname,proposer,sortTime,yiju,dataType,
                eventLevel,execMoney,caseNoKword,courtTypeS};
    }



    /**
     * 将ajlc对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] ajlcObject2Array(Ajlc entity){
        String ajlcId = entity.getAjlcId();
        String body = entity.getBody();
        String caseCause = entity.getCaseCause();
        String caseNo = entity.getCaseNo();
        String court = entity.getCourt();
        String organizer = entity.getOrganizer();
        String pname = entity.getPname();
        String sortTime = entity.getSortTime();
        String dataType = entity.getDataType();
        String ajlcStatusS = entity.getAjlcStatusS();
        String eventLevel = entity.getEventLevel();
        String caseNoKword = entity.getCaseNoKword();
        String courtTypeS = entity.getCourtTypeS();
        return new String[]{ajlcId,body,caseCause,caseNo,court,organizer,pname,sortTime,dataType,ajlcStatusS,eventLevel,
                caseNoKword,courtTypeS};
    }


    /**
     * 将epbparty_zxjc对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] epbparty_zxjcObject2Array(Epbparty_zxjc entity){
        String epbparty_zxjcId = entity.getEpbparty_zxjcId();
        String creditNo = entity.getCreditNo();
        String dealWay = entity.getDealWay();
        String dealWhere = entity.getDealWhere();
        String density = entity.getDensity();
        String eventResult = entity.getEventResult();
        String monitorWay = entity.getMonitorWay();
        String pname = entity.getPname();
        String pollutant = entity.getPollutant();
        String sortTime = entity.getSortTime();
        String standard = entity.getStandard();
        String station = entity.getStation();
        String dataType = entity.getDataType();
        return new String[]{epbparty_zxjcId,creditNo,dealWay,dealWhere,density,eventResult,monitorWay,pname,pollutant,
                sortTime,standard,station,dataType};
    }


    /**
     * 将Epbparty_jkqy对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] epbparty_jkqyObject2Array(Epbparty_jkqy entity){
        String eventName = entity.getEventName();
        String eventType = entity.getEventType();
        String dataType = entity.getDataType();
        String epbparty_jkqyId = entity.getEpbparty_jkqyId();
        String pname = entity.getPname();
        return new String[]{eventName,eventType,dataType,epbparty_jkqyId,pname};
    }

    /**
     * 将Epbparty对象中的值转为数组，与CVS文件的title顺序一致
     */
    public String[] epbpartyObject2Array(Epbparty entity){

        String authority = entity.getAuthority();
        String body = entity.getBody();
        String caseNo = entity.getCaseNo();
        String dataType = entity.getDataType();
        String epbpartyId = entity.getEpbpartyId();
        String eventLevel = entity.getEventLevel();
        String eventName = entity.getEventName();
        String eventResult = entity.getEventResult();
        String eventYiju = entity.getEventYiju();
        String legalRepresentative = entity.getLegalRepresentative();
        String money = entity.getMoney();
        String pname = entity.getPname();
        Date postTime = entity.getPostTime();
        Long sortTime = entity.getSortTime();
        String title = entity.getTitle();
        return new String[]{authority,body,caseNo,dataType,epbpartyId,eventLevel,eventName,eventResult,eventYiju,
                legalRepresentative,money,pname,postTime.toString(),sortTime.toString(),title};
    }


}
