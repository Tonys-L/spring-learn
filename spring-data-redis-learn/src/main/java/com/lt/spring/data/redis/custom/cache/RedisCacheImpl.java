package com.lt.spring.data.redis.custom.cache;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-18 13:45:20
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class RedisCacheImpl implements Cache{

	@Override
	public String getCacheName() {
		return null;
	}

	@Override
	public <T> T get(Object key, Class<T> type) {
		return null;
	}

	@Override
	public void put(Object key, Object value) {

	}

	@Override
	public void evict(Object key) {

	}

	@Override
	public void clear() {

	}
}
