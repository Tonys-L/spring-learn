package com.lt.spring.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * 功能：Spring 事件支持 需要继承ApplicationEvent，通过ApplicationEventPublisher发布事件
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-27 10:35:46
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public class CustomEvent extends ApplicationEvent {
	private String context;
	private String type;

	public CustomEvent(Object source, String context, String type) {
		super(source);
		this.context = context;
		this.type = type;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
