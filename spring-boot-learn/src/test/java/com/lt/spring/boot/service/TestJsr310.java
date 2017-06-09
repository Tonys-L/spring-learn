package com.lt.spring.boot.service;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-04-05 10:24:49
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public class TestJsr310 {
	@Test
	public void testClock() throws NoSuchFieldException {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(clock.getZone());
		System.out.println(Instant.now());
		System.out.println(Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai")).millis());
		System.out.println(Clock.system(ZoneId.of("Asia/Shanghai")).millis());
		System.out.println(Clock.system(ZoneId.of("Europe/Paris")).millis());
		System.out.println(LocalDateTime.now(ZoneId.of("Europe/Paris")));
		System.out.println(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
		//System.out.println(Clock.systemDefaultZone().withZone(ZoneId.of("Y")).millis());
		System.out.println(System.currentTimeMillis());

		LocalDateTime d3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println(d3);
		ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(now2);
	}
}
