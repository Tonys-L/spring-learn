package com.lt.spring.data.redis.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-09 15:44:12
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Component
public class CustomKeyGenerator implements KeyGenerator {
	public Object generate(Object target, Method method, Object... params) {
		StringBuilder key = new StringBuilder(target.getClass().getName() + "." + method.getName()+"(");
		if (params != null) {
			for (Object param : params) {
				key.append(param);
				key.append(",");
			}
		}
		key.deleteCharAt(key.length() - 1);
		return key.append(")").toString();
	}
}
