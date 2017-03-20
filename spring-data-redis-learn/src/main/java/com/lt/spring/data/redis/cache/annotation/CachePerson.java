package com.lt.spring.data.redis.cache.annotation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 16:25:50
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Caching(
		cacheable = @Cacheable(value = "person",key = "#id"),
		put = @CachePut(value = "person",key="#id"),
		evict = @CacheEvict(value = "person",key = "#id")
)
public @interface CachePerson {
}
