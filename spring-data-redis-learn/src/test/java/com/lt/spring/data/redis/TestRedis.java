package com.lt.spring.data.redis;

import redis.clients.jedis.Jedis;

import org.junit.Test;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-15 17:17:51
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class TestRedis {
	@Test
	public void test() {
		Jedis jedis = new Jedis("localhost");
		jedis.set("jtest", "1");
		System.out.println("connection ok!");
	}
}
