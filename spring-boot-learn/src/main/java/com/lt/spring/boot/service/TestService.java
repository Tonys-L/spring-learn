package com.lt.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.spring.boot.dao.TestDao;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-11 16:50:47
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
@Service
public class TestService {
	@Autowired
	private TestDao testDao;
}
