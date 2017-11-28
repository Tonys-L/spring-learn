package com.lt.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.TaskUtils;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-08-29 18:46:55
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {
	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(1);
		threadPoolTaskScheduler.setErrorHandler(TaskUtils.getDefaultErrorHandler(true));
		return threadPoolTaskScheduler;
	}
}
