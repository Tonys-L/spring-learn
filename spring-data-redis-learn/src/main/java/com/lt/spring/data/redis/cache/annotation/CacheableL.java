package com.lt.spring.data.redis.cache.annotation;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-17 11:33:59
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheableL {

	String value() default "";

	Class operateClass();

	String method() default "";

	String key() default "";
}
