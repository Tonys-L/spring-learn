package com.lt.spring.data.redis;

import java.io.Serializable;

/**
 * 功能：
 *
 * @author：liutao(286269159@qq.com)
 * @create：2017-03-08 17:36:23
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class Person implements Serializable{
	private String firstname = "LL";
	private String lastname = "TT";

	public Person() {
		System.out.println("created");
	}

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return this.firstname+"_"+this.lastname;
	}
}
