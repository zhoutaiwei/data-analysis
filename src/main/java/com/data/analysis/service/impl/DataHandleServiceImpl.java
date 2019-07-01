package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.mapper.DBMapper;
import com.data.analysis.service.DataHandleService;
import com.data.analysis.utils.Object2ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class DataHandleServiceImpl implements DataHandleService {

    @Autowired
    CSVMapper csvMapper;
    @Autowired
    DBMapper dbMapper;
    @Autowired
    CompanyQueryServiceImpl dataService;
    @Autowired
    Object2ArrayUtils object2ArrayUtils;



    /**
     * 数据处理
     * @param pageNo
     */
    @Override
    public void handleTask(final int pageNo) {
        JSONObject result = dataService.getStandardDataByPageNo(pageNo);
        if(result!=null&& DataTypeConstant.SUCCESS_CODE.equals(result.getString("code"))){
            JSONArray jsonArray = result.getJSONArray("allList");
            List<String []> csvEntitys=new ArrayList<>();
            List<LitigationRelatedEntity> dbEntitys = new ArrayList<>();
            //将数据放到指定集合中
            dataHandle(jsonArray,csvEntitys,dbEntitys);

            csvMapper.writeEnvProtectionCSVFile(csvEntitys);

            dbMapper.insertdEnvProtection(dbEntitys);
            log.info("第{}页数据写入csv文件结束，写入数据库结束",pageNo);
        }else {
            log.info("第{}页数据获取失败",pageNo);
        }
    }

    /**
     * 对返回数据进行处理
     * @param jsonArray
     * @param csvEntitys
     * @param dbEntitys
     */
    public void dataHandle( JSONArray jsonArray,List<String []> csvEntitys,List<LitigationRelatedEntity> dbEntitys){
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //将json转为对象，
            LitigationRelatedEntity entity = JSONObject.toJavaObject(jsonObject, LitigationRelatedEntity.class);
            //将数组添加到集合中，用于写入csv文件
            csvEntitys.add(object2ArrayUtils.LItigationRelatedObject2Array(entity));
            //将对象加入集合，用于写入数据库
            //指定数据的创建时间和创建人
            entity.setCreateTime(new Date());
            entity.setCreatedBy("admin");
            dbEntitys.add(entity);
        }
    }
}
