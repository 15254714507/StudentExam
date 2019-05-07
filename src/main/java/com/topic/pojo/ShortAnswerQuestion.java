package com.topic.pojo;

/**
 * @author 孔超
 * @data 2019.4.30
 * 
 * */
public class ShortAnswerQuestion {
	private Integer id;
	private String topicTwo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopicTwo() {
		return topicTwo;
	}

	public void setTopicTwo(String topicTwo) {
		this.topicTwo = topicTwo;
	}

	@Override
	public String toString() {
		return "ShortAnswerQuestion [id=" + id + ", topicTwo=" + topicTwo + "]";
	}
	
}
