package com.lt.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lt.spring.boot.converter.DateConverter;

/**
 * 功能：
 * 继承WebMvcConfigurerAdapter可以修改Spring Boot 自动给Spring MVC 添加的一些默认配置
 * 例如：MessageConverter,Converter,Formatter，Interceptor等
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 10:53:23
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */

@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

	/**这里会覆盖默认的 String->Date 转换器
	 * 这里添加自定义的日期转换对象，解决前台传递 2012-10-10 10:10:20 格式的日期时转换异常
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new DateConverter());
	}
}
