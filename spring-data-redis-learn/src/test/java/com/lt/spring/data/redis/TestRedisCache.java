package com.lt.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.spring.data.redis.cache.RedisCacheService;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-09 15:06:18
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-cache-redis.xml")
public class TestRedisCache {
	@Autowired
	private RedisCacheService redisCacheService;
	@Test
	public void testGetPerson() {
		//System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		System.out.println(redisCacheService.getPerson("2","2"));
	}

	@Test
	public void testSavePerson() {
		//redisCacheService.getPerson("2","2");
		redisCacheService.savePerson("1","2");
	}

	@Test
	public void testUpdatePerson() {
		redisCacheService.updatePerson();
	}

	@Test
	public void testGetPersons() {
		System.out.println(redisCacheService.getPersons("a","b").size());
	}

}
