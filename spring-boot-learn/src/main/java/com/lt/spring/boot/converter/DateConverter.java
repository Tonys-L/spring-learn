package com.lt.spring.boot.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 功能：自定义日期转换器
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 15:23:56
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public class DateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String s) {
		if (s == null) {
			return null;
		} else {
			s = s.replaceAll("-", "/");
			return new Date(s);
		}
	}
}
