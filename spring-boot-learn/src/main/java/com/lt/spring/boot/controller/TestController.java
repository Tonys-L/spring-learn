package com.lt.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.spring.boot.entity.Person;
import com.lt.spring.boot.service.TestService;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-11 16:52:39
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@RestController
@RequestMapping("/")
public class TestController {
	Logger log = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private TestService testService;
	@RequestMapping("hello")
	public String hello() {
		log.info("111");
		System.out.println(testService);
		return "hello";
	}

	@RequestMapping("person")
	public Person person() {
		return new Person("L", "T");
	}
}
