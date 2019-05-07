package com.topic.pojo;

import java.util.List;

/**
 * @author 孔超
 * @date 2019/5/4
 * 
 * */
public class ExamQuestion {
	private String user;
	private String subject;
	private List<ChoiceQuestion> choiceQuestion;
	private List<ShortAnswerQuestion> shortAnswerQuestion;
	
	
	/**
	 * @param user 学生id
	 * @param subject  科目
	 * @param choiceQuestion 选择题集合
	 * @param shortAnswerQuestion 简答题集合
	 */
	public ExamQuestion(String user, String subject, List<ChoiceQuestion> choiceQuestion,
			List<ShortAnswerQuestion> shortAnswerQuestion) {
		super();
		this.user = user;
		this.subject = subject;
		this.choiceQuestion = choiceQuestion;
		this.shortAnswerQuestion = shortAnswerQuestion;
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
	public List<ChoiceQuestion> getChoiceQuestion() {
		return choiceQuestion;
	}
	public void setChoiceQuestion(List<ChoiceQuestion> choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}
	public List<ShortAnswerQuestion> getShortAnswerQuestion() {
		return shortAnswerQuestion;
	}
	public void setShortAnswerQuestion(List<ShortAnswerQuestion> shortAnswerQuestion) {
		this.shortAnswerQuestion = shortAnswerQuestion;
	}
	@Override
	public String toString() {
		return "ExamQuestion [user=" + user + ", subject=" + subject + ", choiceQuestion=" + choiceQuestion
				+ ", shortAnswerQuestion=" + shortAnswerQuestion + "]";
	}
	
	
}
