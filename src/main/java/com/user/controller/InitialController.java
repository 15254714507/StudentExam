package com.user.controller;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.login.pojo.User;
import com.user.service.InitialService;

/**
 * @author 孔超
 * @date 2019/5/2
 * 
 * */
@Controller
public class InitialController {
	@Autowired
	private InitialService initialService;
	/**
	 * @param STUDENT_CODING 学生账号第一位
	 * @param USER_VO 学生信息展示对象
	 * @param USER_DTO 存在ServletContext里的map对象的键值
	 * @param IMAGE_PATH 图片在项目中的相对地址
	 * */
	private static final String STUDENT_CODING = "1";
	private static final String USER_VO = "UserVO";
	private static final String USER_DTO = "UserDTO";
	private static final String IMAGE_PATH = "uploadimage/";
	/**
	 * @param request 获取session，获取当前对象的信息
	 * @return 没有当前对象就跳转回登录页面，有并且是学生就到/Student/People.jsp否则就到老师/Teacher/People.jsp
	 * */
	@RequestMapping(value = "jumpPersonal" ,method = RequestMethod.POST)
	public String  jumpPersonal(HttpServletRequest request){
		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute(USER_VO);
		  //判定是学生还是老师，1开头的账号是学生，2开头的账号是老师
		  if(user.getUser().substring(0, 1).equals(STUDENT_CODING)){
			  return "/Student/People";
		  }else{			  
			  return "/Teacher/People";
		  }
		
	}
	/**
	 * @param newUser 前端信息修改后的对象
	 * @param file 图片上传时的文件
	 * @param request 获取session，再获取此账号的信息
	 * @return 学生返回/Student/StudLogin.jsp，老师返回/Teacher/TeacherLogin
	 * */
	@RequestMapping(value = "changMesg" ,method=RequestMethod.POST)
	public String  changMesg(@ModelAttribute User newUser,MultipartFile file, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		User userDO = (User) session.getAttribute(USER_VO);	
		boolean falg = userDO.getOne().equals(newUser.getOne()) && userDO.getOne1().equals(newUser.getOne1()) && userDO.getTwo().equals(newUser.getTwo()) 
					   && userDO.getTwo1().equals(newUser.getTwo1()) && userDO.getThree().equals(newUser.getThree()) && userDO.getThree1().equals(newUser.getThree1()) && file == null;
		// 是否信息被修改
		if(falg){
			if(userDO.getUser().substring(0, 1).equals(STUDENT_CODING)){
				  return "/Student/StudLogin";
			  }else{
				  return "/Teacher/TeacherLogin";
			  }
		}else{
			if(file.isEmpty() == false){
				StringBuffer imagePath = new StringBuffer();
				String originalName = file.getOriginalFilename();
				int index = originalName.lastIndexOf(".");
				// 图片名称用UUID重新写入
				String newFileName = UUID.randomUUID()+originalName.substring(index, originalName.length());
				// 服务器的地址
				ServletContext application = session.getServletContext();
				String path = application.getRealPath("/");
				imagePath.append(path).append(IMAGE_PATH).append(newFileName);
				File imagFile = new File(imagePath.toString());
				file.transferTo(imagFile);
				userDO.setImage_path(IMAGE_PATH);
				userDO.setImage_name(newFileName);
				// StringBuffer 清空数据
				imagePath.setLength(0);
				
				imagePath.append(request.getContextPath()).append("/").append(userDO.getImage_path()).append(userDO.getImage_name());
				session.setAttribute("userImageVO",  imagePath.toString());			
				newUser.setImage_path(IMAGE_PATH);
				newUser.setImage_name(newFileName);
				
			}
			userDO.setOne(newUser.getOne());
			userDO.setOne1(newUser.getOne1());
			userDO.setTwo(newUser.getTwo());
			userDO.setTwo1(newUser.getTwo1());
			userDO.setThree(newUser.getThree());
			userDO.setThree1(newUser.getThree1());
			session.setAttribute(USER_VO, userDO);
			if(userDO.getUser().substring(0, 1).equals(STUDENT_CODING)){
				initialService.updateStudentMessage(newUser);
				return "/Student/StudLogin";
			}else{
				initialService.updateTeacherMessage(newUser);
				return "/Teacher/TeacherLogin";
			  }
		}
	
	}
	/**
	 * @param request 获取session，移除当前对象
	 * */
	@RequestMapping(value = "exitNumber" )
	public String  exitNumber(HttpServletRequest request){
		  HttpSession session = request.getSession();
		  User userDO = (User) session.getAttribute(USER_VO);
		  ConcurrentHashMap<String, String> map = (ConcurrentHashMap<String, String>) request.getServletContext().getAttribute(USER_DTO);
		  //判断map是否存在
		  if(map == null) {}else {
			  map.remove(userDO.getUser());
		  }
		  session.removeAttribute(USER_VO);
		  return "redirect:/Login.jsp";  
	}	
	
}
