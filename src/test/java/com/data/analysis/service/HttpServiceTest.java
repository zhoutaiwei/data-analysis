package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpServiceTest {

    @Autowired
    CompanyQueryService httpService;

    @Test
    public void  litigationRelated(){
        httpService.getLitigationRelated(1);
    }

    @Test
    public void  getRevenueRelated(){
        JSONObject related = httpService.getRevenueRelated(1);
        System.out.println(related);
    }
    @Test
    public void  getEnvProtection(){
        JSONObject related = httpService.getEnvProtection(1);
        System.out.println(related);
    }
}
