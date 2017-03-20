package com.lt.spring.data.redis.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.cache.interceptor.CacheOperationInvoker;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 16:34:28
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class CustomCacheInterceptor extends CacheAspectSupport implements  Serializable {
	public Object intercept(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Method method = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod();

		CacheOperationInvoker aopAllianceInvoker = new CacheOperationInvoker() {
			public Object invoke() {
				try {
					return proceedingJoinPoint.proceed();
				}
				catch (Throwable ex) {
					throw new ThrowableWrapper(ex);
				}
			}
		};

		try {
			return execute(aopAllianceInvoker, proceedingJoinPoint.getThis(), method, proceedingJoinPoint.getArgs());
		}
		catch (CacheOperationInvoker.ThrowableWrapper th) {
			throw th.getOriginal();
		}
	}
}
