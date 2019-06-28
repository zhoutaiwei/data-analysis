package com.data.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import sun.applet.Main;

//开启定时任务
@EnableScheduling
@SpringBootApplication
@EnableAsync

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
