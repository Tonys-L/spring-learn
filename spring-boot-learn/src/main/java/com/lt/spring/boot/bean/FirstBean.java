package com.lt.spring.boot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-21 17:33:38
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Component
public class FirstBean implements CommandLineRunner ,Ordered {
	Logger logger = LoggerFactory.getLogger(FirstBean.class);
	@Override
	public void run(String... strings) throws Exception {
		logger.info("实现了CommandLineRunner run方法将会在SpringApplication.run 执行成功后调用");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
