package com.lt.spring.data.redis.custom.cache;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-18 10:26:34
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public interface Cache {
	String getCacheName();

	<T> T get(Object key, Class<T> type);

	void put(Object key, Object value);

	void evict(Object key);

	void clear();
}
