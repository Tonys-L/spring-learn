package com.lt.spring.boot.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lt.spring.boot.context.MyServletContextInitializer;
import com.lt.spring.boot.servlet.SecServlet;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 16:42:17
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Configuration
public class ServletConfig {
	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new MyServletContextInitializer();
	}

	/**
	 * 另一种添加Servlet的方法
	 * 添加Filter 和 Listener 的方法类似
	 * 使用ServletRegistrationBean, FilterRegistrationBean and ServletListenerRegistrationBean
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<SecServlet> secServlet() {
		ServletRegistrationBean<SecServlet> secServlet = new ServletRegistrationBean<>(new SecServlet());
		secServlet.addUrlMappings("/sec");
		return secServlet;
	}
}
