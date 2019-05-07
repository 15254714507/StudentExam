package com.user.pojo;
import java.time.LocalDate;

/**
 * @author 孔超
 * @date 2019/5/6
 * */
public class ExamArrange {
	private String user;
	private String subjects;
	private LocalDate startdate;
	private LocalDate deadline;
	private String state;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ExamArrange [user=" + user + ", subjects=" + subjects + ", startdate=" + startdate + ", deadline="
				+ deadline + ", state=" + state + "]";
	}
	
}
