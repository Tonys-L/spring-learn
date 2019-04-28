package com.lt.mssimpleprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProviderUserApplication.class, args);
    }

}
