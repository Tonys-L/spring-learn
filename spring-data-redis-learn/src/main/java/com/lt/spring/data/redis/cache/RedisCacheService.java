package com.lt.spring.data.redis.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lt.spring.data.redis.Person;
import com.lt.spring.data.redis.cache.annotation.CacheableL;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-09 15:07:24
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Service
@Cacheable
public class RedisCacheService {
	//@CustomCacheable(value = "person1",key = "'getP'+#id", sync = true)
	@Cacheable(value = "person", key = "'get'+#id",sync = true)
	public Person getPerson(String id, String name) {
		System.out.println("invoke getPerson");
		return new Person("L", "T");
	}

	@CacheableL(value = "person",operateClass = RedisUtil.class,method = "test", key="custom" )
	public List<Person> getPersons(String id,String name) {
		System.out.println("invoke getPersons");
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("11","22"));
		personList.add(new Person("22","22"));
		personList.add(new Person("33","22"));
		personList.add(new Person("44","22"));
		personList.add(new Person("55","22"));
		return personList;
	}
	//key = "'com.lt.spring.data.redis.cache.RedisCacheService.getPerson('+#id+','+#name+')'"
	@CacheEvict(value = "person",key = "'com.lt.spring.data.redis.cache.RedisCacheService.getPerson('+#id+','+#name+')'")
	public void savePerson(String id,String name) {
		System.out.println("savePerson");
	}

	@CachePut(value = "getPerson")
	public Person updatePerson() {
		return new Person("T", "L");
	}



}
