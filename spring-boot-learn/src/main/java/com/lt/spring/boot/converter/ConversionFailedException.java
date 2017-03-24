package com.lt.spring.boot.converter;

import org.springframework.core.convert.ConversionException;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-24 15:46:08
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public class ConversionFailedException extends ConversionException{
	public ConversionFailedException(String message) {
		super(message);
	}

	public ConversionFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
