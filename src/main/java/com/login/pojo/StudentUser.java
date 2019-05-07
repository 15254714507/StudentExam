package com.login.pojo;

/**
 * @author 孔超
 * @date 2019.4.30
 * 
 * */
public class StudentUser extends User {
	
	
	private String professional;
	
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	@Override
	public String toString() {
		return "StudentUser [professional=" + professional + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
