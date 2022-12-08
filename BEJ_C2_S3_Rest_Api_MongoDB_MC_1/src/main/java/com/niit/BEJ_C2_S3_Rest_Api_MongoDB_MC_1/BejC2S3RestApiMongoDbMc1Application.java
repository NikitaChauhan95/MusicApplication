package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BejC2S3RestApiMongoDbMc1Application {

    public static void main(String[] args) {
        SpringApplication.run(BejC2S3RestApiMongoDbMc1Application.class, args);
    }

}
