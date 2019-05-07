package com.topic.pojo;
/**
 * @author 孔超
 * @date 2019.4.30
 * 
 * */
public class ChoiceQuestion {
	private Integer id;
	private String topicOne;
	private String oneA;
	private String oneB;
	private String oneC;
	private String oneD;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopicOne() {
		return topicOne;
	}
	public void setTopicOne(String topicOne) {
		this.topicOne = topicOne;
	}
	public String getOneA() {
		return oneA;
	}
	public void setOneA(String oneA) {
		this.oneA = oneA;
	}
	public String getOneB() {
		return oneB;
	}
	public void setOneB(String oneB) {
		this.oneB = oneB;
	}
	public String getOneC() {
		return oneC;
	}
	public void setOneC(String oneC) {
		this.oneC = oneC;
	}
	public String getOneD() {
		return oneD;
	}
	public void setOneD(String oneD) {
		this.oneD = oneD;
	}
	@Override
	public String toString() {
		return "ChoiceQuestion [id=" + id + ", topicOne=" + topicOne + ", oneA=" + oneA + ", oneB=" + oneB + ", oneC="
				+ oneC + ", oneD=" + oneD + "]";
	}
	
}
