package com.lt.spring.boot.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-11-25 11:31:57
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Component
public class CustomLifeCycle implements InitializingBean, DisposableBean {
	@Override
	public void destroy() throws Exception {
		System.out.println("destory");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
}
