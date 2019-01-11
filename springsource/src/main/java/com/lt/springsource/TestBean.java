package com.lt.springsource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ：Tony.L
 * @version ：2019 Version：1.0
 * @create ：2019/01/08 13:58
 */
public class TestBean {
    private String test = "test";

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
        TestBean testBean = beanFactory.getBean(TestBean.class);
        System.out.println(testBean.getTest());
    }
}
