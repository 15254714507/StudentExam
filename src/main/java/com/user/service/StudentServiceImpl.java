package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.topic.pojo.ChoiceQuestion;
import com.topic.pojo.ExamQuestion;
import com.topic.pojo.ModelAnswer;
import com.topic.pojo.ModelAnswerList;
import com.topic.pojo.ShortAnswerQuestion;
import com.topic.pojo.StudentTest;
import com.user.mapper.StudentMapper;
import com.user.pojo.ExamArrange;
import com.user.pojo.StudentGrade;
import com.user.unit.Page;

/**
 * @author 孔超
 * @date 2019/5/5
 * */
@Transactional(rollbackFor=Exception.class)
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper ;
	@Override
	public  Page<ExamArrange> comingSoon(String user)throws Exception{
		int totalCount =studentMapper.countComingTotal(user);
		Page<ExamArrange> page=new Page<ExamArrange>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		//如果条数小于1就直接跳过数据库查询
		if(totalCount > 0) {
			List<ExamArrange> dataList=studentMapper.listComingExamArrange(page);
			page.setDataList(dataList);
		}
		return page;
		
	}
	
	@Override
	public Page<ExamArrange> comingSoonSkip(Page<ExamArrange> page, int type)throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<ExamArrange> dataList=studentMapper.listComingExamArrange(page);
		page.setDataList(dataList);
		return page;
	}
	
	@Override
	public Page<ExamArrange> underwayExam(String user) throws Exception {
		int totalCount =studentMapper.countUnderwayTotal(user);
		Page<ExamArrange> page=new Page<ExamArrange>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		//如果条数小于1就直接跳过数据库查询
		if(totalCount > 0) {
			List<ExamArrange> dataList=studentMapper.listUnderwayExamArrange(page);
			page.setDataList(dataList);
		}
		return page;
	}
	@Override
	public Page<ExamArrange> underwayExamSkip(Page<ExamArrange> page, int type) throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<ExamArrange> dataList=studentMapper.listUnderwayExamArrange(page);
		page.setDataList(dataList);
		return page;
	}
	
	@Override
	public ExamQuestion getExamQuestion(String user, String subject) throws Exception {
		//这有个疑问，应该先判定这个人是否已经考过了，但是退出又重新进的
		ExamQuestion examQuestion = null;
		int number = studentMapper.countExamQuestion(user, subject);
		if(number > 0) {
			//把试卷库和答案库里的试卷都删除
			try {
				studentMapper.deleteExamQuestion(user, subject);
				studentMapper.deleteExamAnswer(user, subject);
	        } catch (Exception ex) {
	        	System.out.println("删除试卷失败，检查数据库连接是否正常。数据库是否出问题了");
	        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	            throw ex;
	        }
		}
		//获取试卷
		List<ChoiceQuestion> choic =studentMapper.listChoiceQuestion(subject);
		List<ShortAnswerQuestion> shortAnswer=studentMapper.listShortAnswerQuestion(subject);
		//获取试题的答案放进答案表里
		List<ModelAnswer> s1=studentMapper.listChoiceModelAnswer(choic);
		s1.addAll(studentMapper.listShortModelAnswer(shortAnswer));
		examQuestion = new ExamQuestion(user, subject, choic, shortAnswer);
		ModelAnswerList modelAnswerList =  new ModelAnswerList(user, subject, s1);
		try {
			//把试卷放进试卷表
			studentMapper.insertQuestions(examQuestion);
			//把标准答案放进答案表
			studentMapper.insertModelAnswers(modelAnswerList);
        } catch (Exception ex) {
        	System.out.println("修改信息失败，检查数据库连接是否正常。数据库是否出问题了");
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }
		return examQuestion;
	}
	@Override
	public void submitTest(StudentTest studentTest) throws Exception {
	
		StudentTest studentModelAnswer =studentMapper.getModelAnswer(studentTest.getUser(), studentTest.getSubject());
		int choiceSum =studentModelAnswer.equalsClass(studentTest);
		//写进学生成绩对象再传进数据库
		StudentGrade studentGrade = new StudentGrade();
		studentGrade.setUser(studentTest.getUser());
		studentGrade.setSubject(studentTest.getSubject());
		studentGrade.setSelectgrade(choiceSum*4);
		//提交后再修改考试状态
		try {
			studentMapper.updateState(studentTest.getUser(), studentTest.getSubject());
			studentMapper.insertGrade(studentGrade);
			studentMapper.insertStudentTest(studentTest);
        } catch (Exception ex) {
        	System.out.println("修改信息失败，检查数据库连接是否正常。数据库是否出问题了");
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        }	
	}

	@Override
	public Page<ExamArrange> timePassed(String user) throws Exception {
		int totalCount =studentMapper.countPassedTotal(user);
		Page<ExamArrange> page = new Page<ExamArrange>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage() - 1) * page.getPageSize());
		page.setEnd(page.getBegin() + page.getPageSize());
		//条数小于1直接不去数据库返回一个空的数据的页的对象
		if(totalCount > 0) {
			List<ExamArrange> dataList=studentMapper.listPassedExamArrange(page);
			page.setDataList(dataList);
		}
		return page;
	}
	
	@Override
	public Page<ExamArrange> timePassedSkip(Page<ExamArrange> page, int type)
			throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<ExamArrange> dataList=studentMapper.listPassedExamArrange(page);
		page.setDataList(dataList);
		return page;
		
	}
	
	@Override
	public Page<StudentGrade> studentAllGrade(String user) throws Exception {
		int totalCount =studentMapper.countAllGradeTotal(user);
		Page<StudentGrade> page=new Page<StudentGrade>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		if(totalCount > 0) {
			List<StudentGrade> dataList=studentMapper.listAllGrade(page);
			page.setDataList(dataList);
		}
		return page;
		
	}
	
	@Override
	public Page<StudentGrade> studentAllGradeSkip(Page<StudentGrade> page, int type) throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<StudentGrade> dataList=studentMapper.listAllGrade(page);
		page.setDataList(dataList);
		return page;
		
	}
	
	@Override
	public Page<StudentGrade> studentSearhLoginGradeSkip(String user,String content) throws Exception {
		int totalCount =studentMapper.countSearchGradeTotal(user, content);
		Page<StudentGrade> page=new Page<StudentGrade>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		page.setContent(content);
		if(totalCount > 0) {
			List<StudentGrade> dataList=studentMapper.listSearchGrade(page);
			page.setDataList(dataList);
		}
		return page;
	}
	
	@Override
	public Page<StudentGrade> studentSearhGradeSkip(Page<StudentGrade> page,
			String content, int type) throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		page.setContent(content);
		List<StudentGrade> dataList=studentMapper.listSearchGrade(page);
		page.setDataList(dataList);
		return page;
	}
	
	@Override
	public Page<StudentGrade> failGrade(String user) throws Exception {
		int totalCount =studentMapper.countFailGradeTotal(user);
		Page<StudentGrade> page=new Page<StudentGrade>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		if(totalCount > 0) {
			List<StudentGrade> dataList=studentMapper.listFailGrade(page);
			page.setDataList(dataList);
		}
		return page;
	}
	@Override
	public Page<StudentGrade> failGradeSkip(Page<StudentGrade> page, int type)
			throws Exception {
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<StudentGrade> dataList=studentMapper.listFailGrade(page);
		page.setDataList(dataList);
		return page;
	}

	@Override
	public Page<StudentGrade> passGrade(String user) throws Exception {
		int totalCount =studentMapper.countPassGradeTotal(user);
		Page<StudentGrade> page=new Page<StudentGrade>(10);
		page.setTotalCount(totalCount);
		page.setUser(user);
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		if(totalCount > 0) {
			List<StudentGrade> dataList=studentMapper.listPassGrade(page);
			page.setDataList(dataList);
		}
		return page;
	}
	
	@Override
	public Page<StudentGrade> passGradeSkip(Page<StudentGrade> page, int type)
			throws Exception {
		
		page.setCurrentPage(type);
		page.setBegin((type-1)*page.getPageSize());
		page.setEnd(page.getBegin()+page.getPageSize());
		List<StudentGrade> dataList=studentMapper.listPassGrade(page);
		page.setDataList(dataList);
		return page;
	}
	
	
	

	

}
