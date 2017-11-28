package com.lt.spring.boot.dao;

import org.springframework.stereotype.Repository;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-06-09 14:57:58
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Repository("testDao1")
public class TestDao1 implements IDao {
	@Override
	public String find() {
		return this.getClass().getName();
	}

	@Override
	public String findAll() {
		return null;
	}
}
