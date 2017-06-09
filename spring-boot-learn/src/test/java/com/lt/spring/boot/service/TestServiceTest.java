package com.lt.spring.boot.service;

import java.time.Clock;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-27 15:05:53
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestServiceTest {
	@Resource
	private TestService testService;

	@Test
	public void testEvent() throws Exception {
		testService.testEvent();
		System.out.println(1);
	}

	public void testJsr310() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock);
	}

}