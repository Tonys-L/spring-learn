package com.lt.spring.data.redis;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lt.spring.data.redis.cache.RedisCacheService;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-10 11:43:21
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class Main {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring-cache-redis.xml");
		final RedisCacheService redisCacheService = beanFactory.getBean("redisCacheService",RedisCacheService.class);
		redisCacheService.savePerson("1","2");
		int count = 10000;
		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				public void run() {
					redisCacheService.getPerson("1", "2");
				}
			},String.valueOf(i)).start();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
}
