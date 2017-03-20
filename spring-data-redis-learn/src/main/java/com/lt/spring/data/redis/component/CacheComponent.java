package com.lt.spring.data.redis.component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-18 15:06:47
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Component
public class CacheComponent{
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, String, Object> hashOps;
	private SetOperations<String, Object> setOps;
	private ValueOperations<String, Object> valueOps;
	private ZSetOperations<String, Object> zSetOps;
	private ListOperations<String, Object> listOps;

	@PostConstruct
	public void init() {
		this.hashOps = redisTemplate.opsForHash();
		this.setOps = redisTemplate.opsForSet();
		this.valueOps = redisTemplate.opsForValue();
		this.zSetOps = redisTemplate.opsForZSet();
		this.listOps = redisTemplate.opsForList();
	}

	/**
	 *String 操作
	 * @param key
	 * @param value
	 */
	public void set(String key,String value) {
		valueOps.set(key,value);
	}

	public <T> T get(String key,Class<T> cls) {
		return (T)valueOps.get(key);
	}

	public <T> List<T> mGet(Collection<String> keys, Class<T> cls) {
		return (List<T>) valueOps.multiGet(keys);
	}

	public void sAdd(String key,Object... values) {
		setOps.add(key, values);
	}

	public <T> Set<T> sMembers(String key) {
		return (Set<T>) setOps.members(key);
	}

	public <T> T sPop(String key,Class<T> cls) {
		return (T) setOps.pop(key);
	}

	/**
	 * Hash 操作
	 */

	public void hPut(String key,String hashKey,Object value) {
		hashOps.put(key,hashKey,value);
	}

	public Boolean hExists(String key,String hashKey) {
		return hashOps.hasKey(key, hashKey);
	}

	public <T> T hGet(String key,String hashKey,Class<T> cls) {
		return (T) hashOps.get(key, hashKey);
	}

	public Object hGet(String key, String hashKey) {
		return hashOps.get(key, hashKey);
	}

	public List<Object> hGetAll(String key) {
		return hashOps.values(key);
	}

	/*private HashOperations<String, String, Object> hashOperation() {
		return redisTemplate.opsForHash();
	}

	private SetOperations<String, Object> setOperation() {
		return redisTemplate.opsForSet();
	}

	private ValueOperations<String, Object> valueOperation() {
		return redisTemplate.opsForValue();
	}

	private ZSetOperations<String, Object> zSetOperations() {
		return redisTemplate.opsForZSet();
	}

	private ListOperations<String, Object> listOperations() {
		return redisTemplate.opsForList();
	}*/
}
