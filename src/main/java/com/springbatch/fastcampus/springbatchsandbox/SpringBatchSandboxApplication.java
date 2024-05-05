package com.springbatch.fastcampus.springbatchsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class SpringBatchSandboxApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBatchSandboxApplication.class, args);
//        SpringApplication.exit(run);
    }

}
