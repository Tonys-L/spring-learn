package com.lt.spring.boot.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-11-25 11:45:31
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	@Nullable
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("开始初始化Bean:" + beanName);
		return bean;
	}

	@Nullable
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("完成初始化Bean:" + beanName);
		return bean;
	}
}
