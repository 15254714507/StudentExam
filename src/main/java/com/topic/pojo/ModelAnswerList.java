/**
 * 
 */
package com.topic.pojo;

import java.util.List;

/**
 * @author 孔超
 * @date 2019年5月4日 
 */
public class ModelAnswerList {
	private String user;
	private String subject;
	private List<ModelAnswer> list;
	
	/**
	 * @param user 学生id
	 * @param subject 考试科目
	 * @param list 答案集合
	 */
	public ModelAnswerList(String user, String subject, List<ModelAnswer> list) {
		super();
		this.user = user;
		this.subject = subject;
		this.list = list;
	}
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
	public List<ModelAnswer> getList() {
		return list;
	}
	public void setList(List<ModelAnswer> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ModelAnswerList [user=" + user + ", subject=" + subject + ", list=" + list + "]";
	}
	
}
