package com.lt.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.lt.spring.boot.entity.DocArticleEntity;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-09-13 14:27:55
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
public interface DocArticleDao extends CrudRepository<DocArticleEntity, String> {
}
