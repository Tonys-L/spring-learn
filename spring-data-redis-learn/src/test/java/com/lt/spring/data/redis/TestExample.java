package com.lt.spring.data.redis;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能：
 *
 * @author：liutao(286269159@qq.com)
 * @create：2017-03-08 14:08:50
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class TestExample {
	@Autowired
	private Example example;
	@Test
	public void test() throws MalformedURLException {
		URL url = new URL("http://www.baidu.com");
		example.addLink("1234333",url);
	}

	@Test
	public void get() {
		example.getLisk();
	}

	@Test
	public void testString() {
		example.addString("str","ssss");
	}

	@Test
	public void testHash() {
		Person person = new Person();
		example.addHash("testHash",person);
	}

	@Test
	public void loadHash() {
		Person person = example.loadHash("testHash");
		System.out.println(person);
	}

	@Test
	public void addJsonHash() {
		example.addJsonHash("testJsonHash",new Person());
	}

	@Test
	public void loadJsonHash() {
		System.out.println(example.loadJsonHash("testJsonHash"));
	}

	@Test
	public void testPublish() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "11");
		example.publishMsg("chatroom",map);
		//example.publishMsg("chatroom","111111");
	}

	@Test
	public void testGetPerson() {
		System.out.println(example.getPerson("1"));
	}
}
