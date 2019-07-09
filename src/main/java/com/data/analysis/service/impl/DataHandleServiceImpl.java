package com.data.analysis.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.analysis.constant.DataTypeConstant;
import com.data.analysis.entity.CompanyCaseEntity;
import com.data.analysis.entity.LitigationRelatedEntity;
import com.data.analysis.mapper.CSVMapper;
import com.data.analysis.mapper.DBMapper;
import com.data.analysis.service.DataHandleService;
import com.data.analysis.service.DetailsQueryService;
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
    @Autowired
    DetailsQueryService detailsQueryService;


    /**
     * 数据处理
     * @param pageNo
     */
    @Override
    public void handleTask(final int pageNo) {
        //获取全量的基础数据，然后根据resultEntryId获取详细数据
        JSONObject result = dataService.getStandardDataByPageNo(pageNo);
        if(result!=null&& DataTypeConstant.SUCCESS_CODE.equals(result.getString("code"))){
            try {
                JSONArray jsonArray = result.getJSONArray("allList");
                List<String []> csvEntitys=new ArrayList<>();
                for (int i=0;i<jsonArray.size();i++){
                    JSONObject json = jsonArray.getJSONObject(i);
                    String entryId = json.getString("resultEntryId");
                    String dataType = json.getString("resultDataType");

                    detailsQueryService.getEPDetailsQueryData(entryId,dataType);
                }
            } catch (Exception e) {
                log.info("获取基础数据失败",e);
            }


            log.info("第{}页数据写入csv文件结束",pageNo);
        }else {
            log.info("第{}页数据获取失败",pageNo);
        }
    }
}
