package com.lt.spring.data.redis.cache;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisOperations;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 11:27:18
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class DecorateRedisCache extends RedisCache {
	public DecorateRedisCache(String name, byte[] prefix, RedisOperations<?, ?> redisOperations, long expiration) {
		super(name, prefix, redisOperations, expiration);
	}

	public DecorateRedisCache(String name, byte[] prefix, RedisOperations<?, ?> redisOperations, long expiration, boolean allowNullValues) {
		super(name, prefix, redisOperations, expiration, allowNullValues);
	}
}
