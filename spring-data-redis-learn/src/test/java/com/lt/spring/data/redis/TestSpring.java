package com.lt.spring.data.redis;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-16 10:43:00
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class TestSpring {

	@Test
	public void test() {
		ClassPathResource classPathResource = new ClassPathResource("spring-context.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		Person person = defaultListableBeanFactory.getBean("person",Person.class);
		System.out.println(person);

	}

	@Test
	public void test1() {
		FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:\\MyProject\\spring-data-reids-learn\\src\\main\\resources\\spring-context.xml");
		Person person = (Person) fileSystemXmlApplicationContext.getBean("person");
	}
}
