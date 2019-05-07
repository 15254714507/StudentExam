package com.interceptor;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.login.pojo.User;
/**
 * @author 孔超
 * @date 2019/5/2
 * */
public class HandlerInterceptor1 implements HandlerInterceptor{
	/**
	 * @param USER_DTO 存储在ServletContext中map的键值
	 * */
	private static final String USER_DTO = "UserDTO";
	/**
	 *  @param ERROR_MESSAGE_VO 错误信息展示
	 * */
	private static final String ERROR_MESSAGE_VO = "errorMessageVO";
	/**
	 * @param ALLOW_MIDDLE_URL 网址中间有这个就允许通过
	 * */
	private static final String ALLOW_MIDDLE_URL = "/update/";
	/**
	 * @param ALLOW_LAST_URL 网址末端有这个就允许通过
	 * */
	private static final String ALLOW_LAST_URL = "login.action";
	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURI().indexOf(ALLOW_MIDDLE_URL) >= 0 || request.getRequestURI().indexOf(ALLOW_LAST_URL) >= 0){
			return true;
		}else{
			HttpSession session =request.getSession();
			User user = (User) session.getAttribute("UserVO");
			ConcurrentHashMap<String, String> map = (ConcurrentHashMap<String, String>) session.getServletContext().getAttribute(USER_DTO);
			if(session.getId().equals(map.get(user.getUser()))){
				return true;
			}else{
				session.setAttribute(ERROR_MESSAGE_VO, "此账号在别处登录");
				String path = request.getContextPath();
				response.sendRedirect(path + "/Login.jsp");
				return false;
			}	
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
