package com.lt.spring.boot.service;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.PutMapping;

import java.io.IOException;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-09-12 15:28:04
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Service
public class JestService {
	@Resource
	private JestClient jestClient;


	public JestResult create() {
		try {
			jestClient.execute(new CreateIndex.Builder("my_index").build());
			PutMapping putMapping = new PutMapping.Builder(
					"my_index",
					"my_type",
					"{ \"my_type\" : { \"properties\" : { \"message\" : {\"type\" : \"string\", \"store\" : \"yes\"} } } }"
			).build();
			return jestClient.execute(putMapping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String search() {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("message", "sss"));
		Search search = new Search.Builder(searchSourceBuilder.toString())
				.addIndex("my_index").addType("my_type").build();
		try {
			return jestClient.execute(search).getJsonString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
