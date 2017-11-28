package com.lt.spring.boot.service;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import io.searchbox.indices.mapping.PutMapping;

import java.io.IOException;
import java.time.Clock;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.lt.spring.boot.dao.DocArticleDao;
import com.lt.spring.boot.entity.DocArticleEntity;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-27 15:05:53
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestServiceTest {
	@Resource
	private TestService testService;
	@Resource
	private DocArticleDao docArticleDao;
	@Resource
	private JestClient jestClient;

	
	@Test
	public void testEvent() throws Exception {
		testService.testEvent();
		System.out.println(1);
	}

	public void testJsr310() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock);
	}

	@Test
	public void tests() throws IOException {

		/*String settings = "\"settings\" : {" +
				"        \"number_of_shards\" : 5," +
				"        \"number_of_replicas\" : 1" +
				"    }";
		Settings.builder().loadFromSource(settings, XContentType.JSON);*/
		//jestClient.execute(new CreateIndex.Builder("easypm").build());
		PutMapping putMapping = new PutMapping.Builder(
				"easypm",
				"doc_article3",
				"{" +
						"    \"doc_article3\": {" +
						"        \"properties\": {" +
						"            \"content\": {" +
						"                \"type\": \"text\"," +
						"                \"analyzer\": \"ik_max_word\"," +
						"                \"search_analyzer\": \"ik_max_word\"," +
						"                \"include_in_all\": \"true\"," +
						"                \"boost\": 8" +
						"            }" +
						"        }" +
						"    }" +
						"}"
		).build();
		JestResult jestResult = jestClient.execute(putMapping);
		System.out.println(jestResult.getJsonString());
	}

	@Test
	public void initData() throws IOException {
		Iterable<DocArticleEntity> docArticleEntities = docArticleDao.findAll();
		for (DocArticleEntity dae :
				docArticleEntities) {
			Index index = new Index.Builder(dae).index("easypm").type("doc_article1").build();
			jestClient.execute(index);
		}
	}

}