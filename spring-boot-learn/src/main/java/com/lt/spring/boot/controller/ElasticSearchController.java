package com.lt.spring.boot.controller;

import io.searchbox.client.JestResult;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.spring.boot.service.JestService;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-09-12 16:42:52
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@RestController
@RequestMapping("/es/")
public class ElasticSearchController {
	@Resource
	private JestService jestService;

	@GetMapping("create")
	public String create() {
		JestResult jestResult = jestService.create();
		return jestResult.getJsonString();
	}

	@GetMapping("search")
	public String search() {
		return jestService.search();
	}
}
