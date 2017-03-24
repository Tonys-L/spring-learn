package com.lt.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-11 14:35:52
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
//Spring 推荐在主类上加@Configuration
//@Configuration
//使用exclude 排除自动引入的类
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.lt.spring.boot")
@SpringBootApplication //等价于 @Configuration @EnableAutoConfiguration @ComponentScan
//引入XML配置
//@ImportResource("classpath:XXX.xml")

public class Application {
	Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		System.setProperty("banner.location", "classpath:banner/banner.txt");
		SpringApplication application = new SpringApplication(Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.addListeners(new MyApplicationStartingEventListener(),
				new MyApplicationPreparedEventListener(),
				new MyApplicationEnvironmentPreparedEventListener(),
				new MyApplicationReadyEventListener(),
				new MyApplicationFailedEventListener()
				);
		application.run(args);
	}

	/**
	 * 应用启动事件
	 * 1.ApplicationStartingEvent
	 * 2.ApplicationEnvironmentPreparedEvent
	 * 3.ApplicationPreparedEvent
	 * 4.ApplicationReadyEvent
	 * 5.ApplicationFailedEvent
	 */

	private static class MyApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
		@Override
		public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
			System.out.println("MyStartingListener");
		}
	}

	private static class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
		@Override
		public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
			System.out.println("MyApplicationEnvironmentPreparedEventListener");
		}
	}

	private static class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
		@Override
		public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
			System.out.println("MyApplicationPreparedEventListener");
		}
	}

	private static class MyApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
		@Override
		public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
			System.out.println("MyApplicationReadyEventListener ");
		}
	}

	private static class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
		@Override
		public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
			System.out.println("MyApplicationFailedEventListener ");
		}
	}





}
