package com.lt.spring.data.redis.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.lt.spring.data.redis.cache.annotation.CacheableL;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 9:23:35
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class CacheInterceptor {
	public Object intercept(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println(123);
		Annotation[] annotations = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod().getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof CacheableL) {
				CacheableL cacheableL = (CacheableL) annotation;
				Class clzz = cacheableL.operateClass();
				String method = cacheableL.method();
				Method method1 = null;
				Object result = null;
				try {
					method1 = clzz.getMethod(method);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
				try {
					result = method1.invoke(clzz.newInstance());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
				System.out.println(result);
			}
		}
		try {
			return proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}
}
