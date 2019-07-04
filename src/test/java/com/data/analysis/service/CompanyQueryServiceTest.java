package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CompanyQueryServiceTest {

    @Autowired
    CompanyQueryService httpService;

   @Test
    public void  litigationRelated(){
      log.info("返回结果为{}", httpService.getStandardDataByPageNo(3));
    }
    @Test
    public void  getCustomerGroupList(){
        httpService.getCustomerGroupList();
    }

}
