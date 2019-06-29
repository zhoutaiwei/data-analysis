package com.data.analysis.mapper;

import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DBMapper {
    /**
     * 将涉案数据插入数据库
     * @param entitys
     * @return
     */
    @InsertProvider(type = Provider.class,method = "insertCompanyCase")
     int insertCompanyCase(@Param("list") List<CompanyCaseEntity> entitys);

    /**
     * 将涉诉数据插入数据库
     * @param entitys
     * @return
     */
    @InsertProvider(type = Provider.class,method = "insertLitigationRelated")
    int insertLitigationRelated(@Param("list") List<LitigationRelatedEntity> entitys);

    /**
     * 将涉税数据插入数据库
     * @param entitys
     * @return
     */
    @InsertProvider(type = Provider.class,method = "insertRevenueRelated")
    int inserRevenueRelated(@Param("list") List<LitigationRelatedEntity> entitys);

    /**
     * 将涉税数据插入数据库
     * @param entitys
     * @return
     */
    @InsertProvider(type = Provider.class,method = "insertdEnvProtection")
    int insertdEnvProtection(@Param("list") List<LitigationRelatedEntity> entitys);
}
