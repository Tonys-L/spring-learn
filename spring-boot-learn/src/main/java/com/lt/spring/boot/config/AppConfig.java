package com.lt.spring.boot.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.lt.spring.boot.bean.App;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-22 17:27:37
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Configuration
public class AppConfig {
	@Autowired
	private CustomProperties customProperties;

	@Bean
	public App appBean() {
		App app = new App();
		app.setName(customProperties.getProjName());
		app.setAuthor(customProperties.getAuthor());
		return app;
	}
}
