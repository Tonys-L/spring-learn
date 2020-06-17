package com.lt.mssimpleconsumermovie.controller;

import com.lt.mssimpleconsumermovie.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        System.out.println(userServiceUrl);
        return restTemplate.getForObject(userServiceUrl + id, User.class);
    }
}
