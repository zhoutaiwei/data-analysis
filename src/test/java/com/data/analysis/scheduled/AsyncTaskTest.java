package com.data.analysis.scheduled;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

    @Autowired
    AsyncTask asyncTask;
    @Test
    public void oprate() throws Exception {
       /* for(int i=0;i<=10;i++) {
            asyncTask.doTask11();
        }*/
    }
}
