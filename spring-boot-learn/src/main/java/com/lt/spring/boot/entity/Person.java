package com.lt.spring.boot.entity;

import javax.validation.constraints.NotNull;

/**
 * 功能：
 *
 * @author：dell
 * @create：2017-03-11 17:28:43
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class Person {
	@NotNull
	private String firstname;
	private String lastname;

	public Person() {
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
}
