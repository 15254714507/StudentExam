package com.ecxeption;
/**
 * @author 孔超
 * @date 2019/5/2
 * */
public class CustomException extends Exception{
	private String message;
	public CustomException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
