package com.lt.spring.boot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-08-29 18:49:07
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Service
public class TaskService {
	private Map<Integer, ScheduledFuture> taskMap = new HashMap<>();
	@Resource
	private TaskScheduler taskScheduler;

	//@Scheduled(cron = "30 18 11 * * ?")
	public void test() {
		System.out.println("删除任务1");
		ScheduledFuture scheduledFuture = taskMap.remove(1);
		scheduledFuture.cancel(true);
	}

	@PostConstruct
	public void init() {
		System.out.println("初始化任务");
		/*for (int i = 0; i < 60; i++) {
			final int taskId = i;
			ScheduledFuture scheduledFuture = taskScheduler.schedule(() -> System.out.println("执行任务" + taskId+":"+new Date()), new CronTrigger(taskId  + " * * * * ?"));
			taskMap.put(taskId, scheduledFuture);
		}
		for (int i = 0; i < 60; i++) {
			final int taskId = i;
			ScheduledFuture scheduledFuture = taskScheduler.schedule(() -> System.out.println("执行任务++" + taskId+":"+new Date()), new CronTrigger(taskId  + " * * * * ?"));
			taskMap.put(taskId, scheduledFuture);
		}*/
		ScheduledFuture scheduledFuture = taskScheduler.schedule(() -> {
					System.out.println("执行任务" + new Date());
				},
				new CronTrigger("30 5 18 * * ?"));
		ScheduledFuture scheduledFuture1 = taskScheduler.schedule(() -> {
					System.out.println("执行任务" + new Date());
				},
				new CronTrigger("30 2 18 * * ?"));
	}

}
