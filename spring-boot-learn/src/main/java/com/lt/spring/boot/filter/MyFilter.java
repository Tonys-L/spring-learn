package com.lt.spring.boot.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能：异步Filter Servlet使用了 async 这里也必须使用 async 否则会抛出异常
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 16:47:20
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class MyFilter extends HttpFilter {
	Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.info("------开始执行Filter------");
		chain.doFilter(request, response);
		logger.info("------结束执行Filter------");
	}

	@Override
	public void destroy() {

	}
}
