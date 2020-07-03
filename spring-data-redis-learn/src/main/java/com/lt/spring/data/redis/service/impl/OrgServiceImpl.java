package com.lt.spring.data.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lt.spring.data.redis.component.CacheComponent;
import com.lt.spring.data.redis.custom.cache.Cache;
import com.lt.spring.data.redis.entity.Org;
import com.lt.spring.data.redis.service.OrgService;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-18 14:56:07
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class OrgServiceImpl implements OrgService {
	private Cache cache;
	@Autowired
	private CacheComponent cacheComponent;

	@Override
	public void addOrg(Org org) {
		cacheComponent.sAdd("org",org);
	}

}
