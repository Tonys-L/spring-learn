package com.lt.spring.boot.context;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 16:41:34
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public class MyServletContextInitializer implements ServletContextInitializer {
	Logger logger = LoggerFactory.getLogger(MyServletContextInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("这里可以初始化ServletContext{}", new Date());
	}
}
