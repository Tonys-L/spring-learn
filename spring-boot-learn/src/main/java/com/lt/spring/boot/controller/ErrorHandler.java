package com.lt.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-06-08 15:27:52
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@ControllerAdvice("com.lt.spring.boot.controller")
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		Map<String, Object> params = new HashMap<>();
		params.put("status", status.value());
		params.put("msg", ex.getMessage());
		return new ResponseEntity<>(params, status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

}
