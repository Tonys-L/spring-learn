package com.lt.spring.data.redis.cache.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 10:08:39
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Cacheable(value = "person")
public @interface CustomCacheable {
	@AliasFor("cacheNames")
	String[] value() default {};

	String[] targetClass() default{};
	@AliasFor("value")
	String[] cacheNames() default {};

	String keyGenerator() default "";

	String cacheManager() default "";

	String cacheResolver() default "";

	String condition() default "";

	String key() default "";

	boolean sync() default false;

	String unless() default "";
}
