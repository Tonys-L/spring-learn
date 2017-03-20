package com.lt.spring.data.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 11:41:34
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Component
public class RedisUtil {
	@Autowired
	private RedisTemplate redisTemplate;

	public String test() {

		return "sdfsdfsdfsdf";
	}


}
