package com.data.analysis.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DetailsQueryServiceTest {
    @Autowired
    DetailsQueryService service;

    @Test
    public void getEPDetailsQueryData() {
       service.getEPDetailsQueryData("c2019310106minchu7802_t20190722","ktgg");

    }

}
