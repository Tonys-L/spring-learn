package com.lt.msdiscoveryeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsDiscoveryEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDiscoveryEurekaServerApplication.class, args);
    }

}
