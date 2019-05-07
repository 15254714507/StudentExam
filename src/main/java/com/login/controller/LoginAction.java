package com.login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.login.pojo.StudentUser;
import com.login.pojo.User;
import com.login.service.LoginService;
/**
 * 
 * @author 孔超
 * @date 2019/5/1
 * */
@Controller
public class LoginAction {
	@Autowired
    private  LoginService loginService ;
	/**
	 * @param STUDENT_CODING 学生账号首第一个数
	 * */
	private static final String STUDENT_CODING = "1";
	/** 
	 * @param USER_VO 学生展示信息对象的键值
	 * */
	private static final String USER_VO = "UserVO";
	/**
	 * @param USER_DTO 存储在ServletContext中map的键值 
	 * */
	private static final String USER_DTO = "UserDTO";
	/**
	  * @param IMAGE_VO 学生头像键值
	 * */
	private static final String IMAGE_VO = "userImageVO";
	/**
	 * @param ERROR_MESSAGE_VO 错误信息回显
	 * */
	private static final String ERROR_MESSAGE_VO="errorMessageVO";
	/**
	  * @param CHANG_PASS_VO 指定学生修改密码的个人信息的键值
	 * */
	private static final String CHANG_PASS_VO="ChangePassVO";
	/**
	 * @param VERIFICATION_CODE 验证码字符串的键值
	 * */
	private static final String VERIFICATION_CODE = "data";
	
	/**
	 * @param user 绑定前端传过来的登录信息
	 * @param model 当登录失败时把错误信息返回
	 * @param request 获得session对象，保存用户信息
	 * @return 成功进入WEB-INF下/Student/StudLogin，失败回/Login.jsp
	 * */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String queryUser(@ModelAttribute User user, Model model, HttpServletRequest request)throws Exception{
	    HttpSession session = request.getSession();
	    ServletContext servletContext = request.getSession().getServletContext();
	    // 给AOP拦截功能提供map集合，里面有账号和sessionId
	    ConcurrentHashMap<String, String> map = null; 
	    // 为什么判断等于？学生1开头，老师2开头
	    if(user != null && user.getUser().substring(0, 1).equals(STUDENT_CODING)){
		    StudentUser studentDO = loginService.getStudentUser(user);
		    if(studentDO != null){
				session.setAttribute(USER_VO, studentDO);
				String sessionId = session.getId();
				if(servletContext.getAttribute(USER_DTO) == null){
					map = new ConcurrentHashMap<String, String>(100);
					map.put(studentDO.getUser(), sessionId);
					servletContext.setAttribute(USER_DTO, map);
				}else{
					map =((ConcurrentHashMap<String, String>)servletContext.getAttribute(USER_DTO));
					map.put(studentDO.getUser(), sessionId);
					servletContext.setAttribute(USER_DTO, map);	
				}
				//学生姓名的键值
				String userNameVO = "userNameVO";
				session.setAttribute(userNameVO, studentDO.getName() + "(" + studentDO.getUser() + ")");
				final boolean flag=studentDO.getImage_name() == null || studentDO.getImage_path() == null || studentDO.getImage_name().equals("") || studentDO.getImage_path().equals("");
				StringBuffer imageLocation = new StringBuffer();
				if(flag){
					//默认图片地址
					String imageDefaultAddress = "/uploadimage/1.jpg";
					imageLocation.append(request.getContextPath()).append(imageDefaultAddress)  ;					
				}else{
					imageLocation.append(request.getContextPath()).append("/").append(studentDO.getImage_path()).append(studentDO.getImage_name())  ;				    
				}
				session.setAttribute(IMAGE_VO, imageLocation.toString());
				return "/Student/StudLogin";
			 
		   }
		 
	   }
	   String errorMessageVO = "账号或密码输入错误";
	   model.addAttribute(ERROR_MESSAGE_VO, errorMessageVO);
	   return "forward:/Login.jsp";	  
  }
    
    /**
     * @return 修改密码跳转到WEB-INF下的Login/Retrieve.jsp
     * 
     * */
    @RequestMapping(value = "/update/forwardControl.action")
    public String forwardControl(){
	    return "/Login/Retrieve";
  }
  
    /**
     * @param request获得session对象，把验证码的字符保存在VERIFICATION_CODE里
     * @param response 返回验证码图片
     * 
     * */
    @RequestMapping(value = "/update/image.action" )
    public void image(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Random ran = new Random();
		String randStr = "0123456789abcdefghijklmnopqrstuvwsyz";
		BufferedImage img = new BufferedImage(80, 40, BufferedImage.TYPE_INT_BGR);
		Graphics grap = img.getGraphics();
		grap.fillRect(0, 0, 80, 40);
		final int linellaeNumber = 10;
		for(int i = 0;i < linellaeNumber; ++i){
			int x1 = ran.nextInt(20);
			int y1 = ran.nextInt(40);
			int x2 = ran.nextInt(60) + 20;
		    int y2 = ran.nextInt(40);
			grap.setColor(new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)));
			grap.drawLine(x1, y1, x2, y2);
		}
		grap.translate(5, 5);
		StringBuffer buffer = new StringBuffer();
		final int letterNumber = 4; 
	    for(int i = 0; i < letterNumber; ++i){
		    char ch = randStr.charAt(ran.nextInt(randStr.length()));
		    String str = String.valueOf(ch);
		    int type = 0;
		    if(ran.nextBoolean()){
			    str = str.toUpperCase();
			    type = Font.ITALIC;
		    }else{
			    type = Font.PLAIN;
		    }
		    grap.setFont(new Font("微软雅黑", type, 18));
		    if(i == 0){
				grap.setColor(new Color(48, 154, 233));
			}
			if(i == 1){
				grap.setColor(new Color(68, 213, 199));
			}
			if(i == 2){
				grap.setColor(new Color(21, 40, 213));
			}
			if(i == 3){
				grap.setColor(new Color(175, 58, 122));				
			}
			grap.drawString(str, i*18, 25);
			buffer.append(str);
	    }
	    HttpSession session = request.getSession();
	    session.setAttribute(VERIFICATION_CODE, buffer.toString().toLowerCase());
	    grap.dispose();
	    //验证码图片的格式
	    String imageFormat = "JPEG";
	    ImageIO.write(img, imageFormat, response.getOutputStream()); 
    }
  
	/** 
	 * @param request获得session，再获得保存在session里的验证码
	 * @return 返回json字符，里面是验证码字符串
	 * */
	@ResponseBody
	@RequestMapping(value = "/update/verify.action", method = RequestMethod.POST, produces="application/json;charset=UTF-8" )
    public String verify(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
		String value = session.getAttribute(VERIFICATION_CODE).toString();	  
		return value;	 
  }
  
	/**
	 * @param user 绑定前端用户想修改密码的账号
	 * @param model 没有此账号就返回错误信息
	 * @param request 获得session对象，把此账号的信息放在session里，
	 * @return 有则进入ChangePass.jsp，没有则返回Retrieve.jsp
	 * */
    @RequestMapping(value = "/update/retrieve.action", method = RequestMethod.POST)
    public String retrieve(@ModelAttribute User user,Model model,HttpServletRequest request)throws Exception{
	    HttpSession session = request.getSession();
	    if(user != null && user.getUser().substring(0,1).equals(STUDENT_CODING)){
		    StudentUser studentDO = loginService.getStudentMessage(user);		  
			if(studentDO != null){
				session.setAttribute(CHANG_PASS_VO, studentDO);
				return "Login/ChangePass";
			 }
	    }
	    String errorMessageVO = "无此账号，请重新输入";
	    model.addAttribute(ERROR_MESSAGE_VO, errorMessageVO);
		return "Login/Retrieve";	  
  }
    /**
     * *
     * @param newUser 和前端上传的对象绑定
     * @param request 获得session,成功吧session里的ChangePassVO删除，失败返回修改页面
     * @param model   把用户填写的密保信息回填
     * @return 成功返回到Login.jsp，失败返回到Login/ChangePass
     * @throws Exception
     */
    @RequestMapping(value = "/update/updatePass.action", method = RequestMethod.POST, produces="application/json;charset=UTF-8" )
    public String changePass(@ModelAttribute User newUser, HttpServletRequest request, Model model)throws Exception{
	    HttpSession session = request.getSession();
	 	User userDTO = (User) session.getAttribute(CHANG_PASS_VO);
	 	boolean flag = userDTO.getOne1().equals(newUser.getOne1().trim()) && userDTO.getTwo1().equals(newUser.getTwo1().trim()) && userDTO.getThree1().equals(newUser.getThree1().trim());
	 	if(flag){
	 		if(userDTO.getPass().equals(newUser.getPass().trim())){
	 			//数据回显
	 			String newUserVO = "newUserVO";
	 			model.addAttribute(newUserVO, newUser);
	 			String errorMessageVO = "请不要输入以前的旧密码";
	 			model.addAttribute(ERROR_MESSAGE_VO, errorMessageVO);
		 		return "Login/ChangePass";
	 		 }
	 		if(userDTO.getUser().substring(0,1).equals(STUDENT_CODING)){	
	 			loginService.updateStudentMessage(newUser);
	 			session.removeAttribute(CHANG_PASS_VO);
	 		 } 
	 		 return "redirect:/Login.jsp";
	 	}else{
	 		String errorMessageVO = "密保问题回答不正确";
	 		model.addAttribute(ERROR_MESSAGE_VO, errorMessageVO);
	 		return "Login/ChangePass";
	 	}
 
	  }
	}
