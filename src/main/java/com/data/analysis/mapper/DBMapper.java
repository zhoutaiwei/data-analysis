package com.data.analysis.mapper;

import com.data.analysis.entity.CompanyCaseEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DBMapper {

    @InsertProvider(type = Provider.class,method = "batchInsert")
    public int insertData(@Param("list") List<CompanyCaseEntity> entitys);

}
