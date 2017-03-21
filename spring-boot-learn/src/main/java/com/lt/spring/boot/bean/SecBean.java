package com.lt.spring.boot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-21 17:36:39
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Order(value = 1)
@Component
public class SecBean implements ApplicationRunner {
	Logger logger = LoggerFactory.getLogger(SecBean.class);
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		logger.info("实现ApplicationRunner run方法会在SpringApplication.run 执行完后调用");
	}
}
