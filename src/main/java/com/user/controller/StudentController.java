package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.login.pojo.User;
import com.topic.pojo.ExamQuestion;
import com.topic.pojo.StudentTest;
import com.user.pojo.ExamArrange;
import com.user.pojo.StudentGrade;

import com.user.service.StudentService;
import com.user.unit.Page;
/**
 * @author 孔超
 * @date 2019/5/5
 * 
 * */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	/**
	 * @param USER_VO 学生展示信息对象的键值
	 * */
	private static final String USER_VO = "UserVO";
	/**
	 *  @param PAGE_VO 分页展示的对象的键值
	 * */
	private static final String PAGE_VO = "page";
	/**
	 * @param SEARCH_VO 搜索条件的键值
	 * */
	private static final String SEARCH_VO = "search";
	
	/**
	 * @request 获得session对象
	 * @return 返回session对象
	 * */
	private User getUser(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(USER_VO);
		return user;
	}
	/**
	 * @param request 把新的分页对象放在session里
	 * @return 返回ComingSoonTest.jsp，把分页数据首页展示出来
	 * */
	@RequestMapping(value = "comingSoon",method = RequestMethod.POST)
	public String comingSoon(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<ExamArrange> page = studentService.comingSoon(user.getUser());
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/ComingSoonTest" ;		
	}
	
	/**
	 * @param type 前端传过来的选择第几页数据观看
	 * @param request 把指定的即将考试的页数的page存进session
	 * @return 返回到ComingSoonTest.jsp
	 * */
	@RequestMapping(value = "comingSoonSkip")
	public String comingSoonSkip(@RequestParam("type") int type, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Page<ExamArrange> page = (Page<ExamArrange>)session.getAttribute(PAGE_VO);
		if(page.getCurrentPage() != type){
			Page<ExamArrange> newPage = studentService.comingSoonSkip(page, type);
			session.setAttribute(PAGE_VO, newPage);
		}
		return "/Student/ComingSoonTest";	
	}
	/**
	 * @param request 把新的分页对象放在session里
	 * @return 返回UnderwayExamTest.jsp，把分页数据首页展示出来
	 * */
	@RequestMapping(value = "underwayExam", method = RequestMethod.POST)
	public String underwayExam(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<ExamArrange> page = studentService.underwayExam(user.getUser());
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/UnderwayExamTest";
		
	}	
	/**
	 * @param type 前端传过来的选择第几页数据观看
	 * @param request 把指定的正在考试的页数的page存进session
	 * @return 返回到UnderwayExamTest.jsp
	 * */
	@RequestMapping(value = "underwayExamSkip")
	public String underwayExamSkip(@RequestParam("type") int type, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Page<ExamArrange> page = (Page<ExamArrange>)session.getAttribute(PAGE_VO);
		if(page.getCurrentPage() != type){
			Page<ExamArrange> newPage = studentService.underwayExamSkip(page, type);	
			session.setAttribute(PAGE_VO, newPage);
		}
		
		return "/Student/UnderwayExamTest";
	}
	/**
	 * @param subject 考试的科目
	 * @param request 把试卷存进session中
	 * @return 前往考试的页面Test.jsp
	 * */
	@RequestMapping(value = "beginExam")
	public String beginExam(@RequestParam("subject") String subject, HttpServletRequest request)throws Exception{
		User user = this.getUser(request);
		ExamQuestion examQuestion = studentService.getExamQuestion(user.getUser(), subject);
		request.getSession().setAttribute("examQuestion", examQuestion);
		return "/Student/Test";	
	}
	/**
	 * @param studentTest 绑定的学生答案试卷
	 * @request 获得学生此次考试的学号和考试科目
	 * @return 返回学生开始页面StudLogin.jsp
	 * 
	 * */
	@RequestMapping(value = "submitTest",method = RequestMethod.POST)
	public String submitTest(@ModelAttribute StudentTest studentTest, HttpServletRequest request)throws Exception{
		User user = this.getUser(request);
		ExamQuestion examQuestion = (ExamQuestion) request.getSession().getAttribute("examQuestion");
		studentTest.setUser(user.getUser());
		studentTest.setSubject(examQuestion.getSubject());
		studentService.submitTest(studentTest);
		return "/Student/StudLogin";	
	}
	
	/**
	 * @param 把考试时间已过，没参加的考试分页首页数据给session
	 * @return 查询考试已过的页面TimePassedTest.jsp
	 * 
	 * */
	@RequestMapping(value = "timePassed",method = RequestMethod.POST)
	public String timePassed(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<ExamArrange> page = studentService.timePassed(user.getUser());
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/TimePassedTest";
	}
	/**
	 * @param type 前端传过来的选择第几页数据观看
	 * @param request 把指定的正在考试的页数的page存进session
	 * @return 返回到TimePassedTest.jsp
	 * */
	@RequestMapping(value = "timePassedSkip")
	public String timePassedSkip(@RequestParam("type") int type, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Page<ExamArrange> page = (Page<ExamArrange>)session.getAttribute("page");
		if(page.getCurrentPage() != type){
			Page<ExamArrange> newPage = studentService.timePassedSkip(page, type);
			session.setAttribute(PAGE_VO, newPage);
		}
		
		return "/Student/TimePassedTest";
	}
	/**
	 * @param request 学生的全部成绩(参加考试的)分页首页给session
	 * @return Grade.jsp
	 * */
	@RequestMapping(value = "studentAllGrade",method = RequestMethod.POST)
	public String studentGrade(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<StudentGrade> page = studentService.studentAllGrade(user.getUser());
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/Grade";
		
	}
		/**
		 * @param content 前端搜索的关键字
		 * @param type 第几页
		 * @param request 把分页好的数据给session
		 * @return 返回Grade.jsp
		 * */
	@RequestMapping(value = "studentAllGradeSkip", method = RequestMethod.POST)
	public String studentAllGradeSkip(@RequestParam("content") String content, @RequestParam("type") int type, HttpServletRequest request) throws Exception{
		//这个地方用到session地方很多，就不直接this.getUser()了
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(USER_VO);
		Page<StudentGrade> page = (Page<StudentGrade>)session.getAttribute("page");
		String searchCondition = (String) session.getAttribute(SEARCH_VO);
		if(content == null || content.trim() == ""){
			if(searchCondition == null || searchCondition.equals("")){
				if(page.getCurrentPage() != type){
					Page<StudentGrade> newPage = studentService.studentAllGradeSkip(page, type);					
					session.setAttribute(PAGE_VO, newPage);
				}
			}else{
				page=studentService.studentAllGrade(user.getUser());
				session.removeAttribute(SEARCH_VO);
				session.setAttribute(PAGE_VO, page);
			}
				
		}else{
			if(searchCondition == null || searchCondition.equals("")){
				Page<StudentGrade> newPage = studentService.studentSearhLoginGradeSkip(user.getUser(), content);	
				session.setAttribute(PAGE_VO, newPage);
				session.setAttribute(SEARCH_VO, content);
			}else if(searchCondition.equals(content.trim())){
				if(page.getCurrentPage() != type){
					Page<StudentGrade> newPage = studentService.studentSearhGradeSkip(page, content, type);
					session.setAttribute(PAGE_VO, newPage);
				}
			}else{
				Page<StudentGrade> newPage = studentService.studentSearhLoginGradeSkip(user.getUser(), content);
				session.setAttribute(PAGE_VO, newPage);
				session.setAttribute(SEARCH_VO, content);
			}
		}
			return "/Student/Grade";
	}
		/**
		 * @param request 把不及格成绩的分页的首页数据给session
		 * @return 前往不及格数据页面FailGrade
		 * 
		 * */
	@RequestMapping(value = "failGrade",method = RequestMethod.POST)
	public String failGrade(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<StudentGrade> page = studentService.failGrade(user.getUser());	
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/FailGrade";
		}
		/**
		 * @param type 第几页
		 * @param request 把指定第type页的数据给session
		 * @return 返回FailGrade.jsp 
		 * */
	@RequestMapping(value = "failGradeSkip", method = RequestMethod.POST)
	public String failGradeSkip(@RequestParam("type") int type, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Page<StudentGrade> page = (Page<StudentGrade>)session.getAttribute(PAGE_VO);
		if(page.getCurrentPage() != type){
			Page<StudentGrade> newPage = studentService.failGradeSkip(page, type);
			session.setAttribute(PAGE_VO, newPage);
		}	
		return "/Student/FailGrade";
	}
		/**
		 * @param request 把及格成绩的分页的首页数据给session
		 * @return 前往及格数据页面PassGrade.jsp
		 * */
	@RequestMapping(value = "passGrade",method = RequestMethod.POST)
	public String passGrade(HttpServletRequest request) throws Exception{
		User user = this.getUser(request);
		Page<StudentGrade> page = studentService.passGrade(user.getUser());
		request.getSession().setAttribute(PAGE_VO, page);
		return "/Student/PassGrade";	
	}
		/**
		 * @param type 第几页
		 * @param request 把指定第type页的数据给session
		 * @return 返回PassGrade.jsp  
		 * */
	@RequestMapping(value = "passGradeSkip", method = RequestMethod.POST)
	public String passGradeSkip(@RequestParam("type") int type, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Page<StudentGrade> page = (Page<StudentGrade>)session.getAttribute(PAGE_VO);
		if(page.getCurrentPage() != type){
			Page<StudentGrade> newPage = studentService.passGradeSkip(page, type);
			session.setAttribute(PAGE_VO, newPage);
		}
		return "/Student/PassGrade";
	}
}
