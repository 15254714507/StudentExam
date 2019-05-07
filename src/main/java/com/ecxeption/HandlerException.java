package com.ecxeption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author 孔超
 * @date 2019/5/2
 * */
public class HandlerException implements HandlerExceptionResolver{
	/**
	 * @param ERROR_MESSAGE_VO 错误信息回显
	 * */
	private static final String ERROR_MESSAGE_VO="errorMessageVO";
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView model= new ModelAndView();
		CustomException custom =null;
		if(ex instanceof CustomException){
			custom = (CustomException)ex;
		}else{
			custom = new CustomException("未知错误");	
		}
		String message = custom.getMessage();
		model.addObject(ERROR_MESSAGE_VO, message);
		model.setViewName("error");
		return model;
	
	}

}
