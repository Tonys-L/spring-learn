package com.lt.spring.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-03-22 17:08:40
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */

/**
 *使用@ConfigurationProperties 需要在pom中添加 spring-boot-configuration-processor 依赖
 * spring 会在META-INF中生成 spring-configuration-metadata.json文件文件中定义的 CustomProperties的meta-data
 * 在application.properties中输入custom会给出提示(在IDEA中项目需要添加spring支持)
 * 默认只在application.properties中读取属性
 * 可以用@PropertySource("classpath:/application-redis.properties")指定特定文件
 * 配置@PropertySource后 会在application.properties 和 @PropertySource 指定的文件中读取,如果有同名属性 以application.properties为主
 * 在application.properties中指定 spring.profiles.active=redis 后，会使用application-redis.properties中的配置覆盖application.properties中的配置
 */
@ConfigurationProperties(prefix = "custom")
@PropertySource("classpath:/application-redis.properties")
@Component
public class CustomProperties {
	private String projName;
	private String author;
	private String version;
	private SubConfig subConfig;

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public SubConfig getSubConfig() {
		return subConfig;
	}

	public void setSubConfig(SubConfig subConfig) {
		this.subConfig = subConfig;
	}

	/**
	 *SubConfig需要定义成静态
	 */
	public static class SubConfig{
		private String subName;
		private String remark;

		public String getSubName() {
			return subName;
		}

		public void setSubName(String subName) {
			this.subName = subName;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
	}
}
