package com.lt.springlearn.springcloudlearneurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudLearnEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLearnEurekaServerApplication.class, args);
    }

}

