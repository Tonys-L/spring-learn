package com.lt.spring.boot.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 功能：仅仅是包装了一下ApplicationEventPublisher
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-27 10:44:50
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware, ApplicationEventPublisher {
	private ApplicationEventPublisher eventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		eventPublisher = applicationEventPublisher;
	}

	@Override
	public void publishEvent(ApplicationEvent event) {
		eventPublisher.publishEvent(event);
	}

	@Override
	public void publishEvent(Object o) {
		eventPublisher.publishEvent(o);
	}
}
