package com.lt.spring.boot.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 功能：通过实现ApplicationListener接口注册事件监听器，通过泛型指定监听的事件类型
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-27 10:48:15
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Component
public class CustomListener implements ApplicationListener<CustomEvent> {
	Logger logger = LoggerFactory.getLogger(CustomListener.class);

	@Override
	public void onApplicationEvent(CustomEvent customEvent) {
		logger.info("事件触发");
	}
}
