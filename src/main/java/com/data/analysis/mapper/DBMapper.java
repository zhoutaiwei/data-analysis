package com.data.analysis.mapper;

import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import com.data.analysis.entity.env_protection.Epbparty;
import com.data.analysis.entity.env_protection.Epbparty_jkqy;
import com.data.analysis.entity.env_protection.Epbparty_zxjc;
import com.data.analysis.entity.litigation_related.*;
import com.data.analysis.entity.revenue_related.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DBMapper {

    @Insert("insert into ep_bparty(epbparty_id,authority,body,case_no,event_result,event_basis,legal_representative,money,company_name," +
            "post_time,sort_time,title,data_type,event_level,event_name,create_time,created_by) values(#{epbpartyId},#{authority}," +
            "#{body},#{caseNo},#{eventResult},#{eventYiju},#{legalRepresentative},#{money},#{pname},#{postTime},#{sortTime}," +
            "#{title},#{dataType},#{eventLevel},#{eventName},#{createTime},#{createdBy})")
    int insertEpbparty(Epbparty epbparty);

    @Insert("insert into ep_bparty_jkqy(epbparty_jkqy_id,event_name,event_type,company_name,data_type,create_time,created_by) values(" +
            "#{epbparty_jkqyId},#{eventName},#{eventType},#{pname},#{dataType},#{createTime},#{createdBy})")
    int insertEpbpartyJkqy(Epbparty_jkqy jkqy);

    int insertEpbpartyZxjc(Epbparty_zxjc zxjc);

    int insertSatpartyQs(Satparty_qs qs);

    int insertSatpartyChufa(Satparty_chufa chufa);

    int insertSatpartyXin(Satparty_xin xin);

    int insertSatpartyReg(Satparty_reg reg);

    int insertSatpartyXuke(Satparty_xuke xuke);

    int insertCpws(Cpws cpws);

    int insertKtgg(Ktgg ktgg);

    int insertZxgg(Zxgg zxgg);

    int insertShixin(Shixin shixin);

    int insertFygg(Fygg fygg);

    int insertAjlc(Ajlc ajlc);

    int insertBgt(Bgt bgt);

    int insertSifacdk(Sifacdk sifacdk);

    /**
     * 将涉税数据插入数据库
     * @param entitys
     * @return
     */
    @InsertProvider(type = Provider.class,method = "insertdEnvProtection")
    int insertdEnvProtection(@Param("list") List<LitigationRelatedEntity> entitys);
}
