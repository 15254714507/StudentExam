package com.login.pojo;
/**
 * @author 孔超
 * @date 2019.4.30
 * 
 * */
public class User {
	private String user;
	private String pass;
	private String name;
	private Integer age;
	private String identity;
	private String one;
	private String one1;
	private String two;
	private String two1;
	private String three;
	private String three1;
	private String image_name;
	private String image_path;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getOne1() {
		return one1;
	}
	public void setOne1(String one1) {
		this.one1 = one1;
	}
	public String getTwo() {
		return two;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public String getTwo1() {
		return two1;
	}
	public void setTwo1(String two1) {
		this.two1 = two1;
	}
	public String getThree() {
		return three;
	}
	public void setThree(String three) {
		this.three = three;
	}
	public String getThree1() {
		return three1;
	}
	public void setThree1(String three1) {
		this.three1 = three1;
	}

	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pass=" + pass + ", name=" + name + ", age=" + age + ", identity=" + identity
				+ ", one=" + one + ", one1=" + one1 + ", two=" + two + ", two1=" + two1 + ", three=" + three
				+ ", three1=" + three1 + ", image_name=" + image_name + ", image_path=" + image_path + "]";
	}
	
	
}
