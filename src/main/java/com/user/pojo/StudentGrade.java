package com.user.pojo;
/**
 * @author 孔超
 * @date 2019/5/2
 * */
public class StudentGrade {
	private String user;
	private String subject;
	private Integer selectgrade;
	private Integer shortgrade;
	private Integer sumgrade;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getSelectgrade() {
		return selectgrade;
	}
	public void setSelectgrade(Integer selectgrade) {
		this.selectgrade = selectgrade;
	}
	public Integer getShortgrade() {
		return shortgrade;
	}
	public void setShortgrade(Integer shortgrade) {
		this.shortgrade = shortgrade;
	}
	public Integer getSumgrade() {
		return sumgrade;
	}
	public void setSumgrade(Integer sumgrade) {
		this.sumgrade = sumgrade;
	}
	@Override
	public String toString() {
		return "StudentGrade [user=" + user + ", subject=" + subject + ", selectgrade=" + selectgrade + ", shortgrade="
				+ shortgrade + ", sumgrade=" + sumgrade + "]";
	}
	
	
}
