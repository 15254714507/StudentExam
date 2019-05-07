package com.user.service;
import com.topic.pojo.ExamQuestion;
import com.topic.pojo.StudentTest;
import com.user.pojo.ExamArrange;
import com.user.pojo.StudentGrade;
import com.user.unit.Page;

/**
 * @author 孔超
 * @date 2019/5/4
 * */
public interface StudentService {
	 /**
	  * show 用学生的id来查询学生即将考试的科目数据(分页的首页)
	  * @param user 学生的id
	  * @return 返回分页的的即将考试的科目数据第一页
	  * */
	 Page<ExamArrange> comingSoon(String user)throws Exception;
	 /**
	  * show 根据指定的第几页type，来往page里添加指定页数的数据
	  * @param page 页的对象，里面存的是一页的数据
	  * @param type 第几页
	  * @return 返回页的对象
	  * */
	 Page<ExamArrange> comingSoonSkip (Page<ExamArrange> page,int type)throws Exception;
	 
	 /**
	  * show 用学生的id来查询学生正在考试的科目数据(分页的首页)
	  * @param user 学生的id
	  * @return 返回分页的的正在考试的科目数据第一页
	  * */
	 Page<ExamArrange> underwayExam(String user)throws Exception;
	/**
	 * show 根据指定的第几页type，来往page里添加指定页数的数据
	 * @param page 页的对象，里面存的是一页的数据
	 * @param type 第几页
	 * @return 返回页的对象
	 * */
	 Page<ExamArrange> underwayExamSkip(Page<ExamArrange> page,int type) throws Exception;
	 
	 /**
	  * show 根据学生的id和科目来获得他自己的考试试卷，分为两部分，选择题和简答题的获取
	    *             再把试卷放进一个试卷表，当用户再次断网重新老师准备，所以一开始要看看是否试卷库已经有了试卷
	    *             为了公平把试卷库里的试卷和答案库里的答案试卷都删除再重新随机拼一套试卷考试  
	  * @param user 学生id
	  * @param subject 学生考试科目
	  * @return 返回一个试卷对象
	  * */
	 ExamQuestion getExamQuestion(String user,String subject)throws Exception;
	 /**
	  * show 提交考试卷子，修改考试状态把未考(0)改成已考(1)，算出选择题的分数到分数表里
	  * @param studentTest 学生提交的试卷
	  * */
	 void submitTest(StudentTest studentTest)throws Exception;
	 /**
	  * show 查询考试时间已过但是自己还没有参加的考试
	  * @param user 学生的id
	  * @return 返回分页对象(首页)
	  * */
	 Page<ExamArrange> timePassed(String user)throws Exception;
	 /**
	  * show 查询考试时间已过但是自己还没有参加的考试指定的第几页
	  * @param page 分页数据对象
	  * @param type 第几页
	  * @return 返回分页对象(type页)
	  * */
	 Page<ExamArrange> timePassedSkip (Page<ExamArrange> page, int type)throws Exception;
	 /**
	  * show 查询学生参加的全部考试
	  * @param user 学生 id
	  * @return 返回分页对象(首页)
	  * */
	 Page<StudentGrade> studentAllGrade(String user)throws Exception;
	 /**
	  * show 查询学生参加的全部考试指定的第几页(搜索条件为空)
	  * @param page 分页数据对象
	  * @param type 第几页
	  * @return 返回分页对象(type页)
	  * */
	 Page<StudentGrade> studentAllGradeSkip(Page<StudentGrade> page,int type)throws Exception;
	 /**
	  * show 查询学生参加的全部考试(搜索条件为content)
	  * @param user 学生id
	  * @param content 分类条件
	  * @return 返回分页对象(首页)
	  * */
	 Page<StudentGrade> studentSearhLoginGradeSkip(String user,String content)throws Exception;
	 /**
	  * show 查询学生参加的全部考试(搜索条件为content)
	  * @param page 分页数据对象
	  * @param content 分类条件
	  * @param type 第几页
	  * @return 返回分页对象(type页)
	  * */
	 Page<StudentGrade> studentSearhGradeSkip(Page<StudentGrade> page,String content, int type)throws Exception;
	 /**
	  * show  查询学生不及格的成绩(首页)
	  * @param user 学生id
	  * @return 一页的数据
	  * */
	 Page<StudentGrade> failGrade(String user)throws Exception;
	 /**
	  * show 查询学生不及格成绩的指定type页数
	  * @param page 页的对象
	  * @param type 指定第几页
	  * @return 返回新的页的数据
	  * */
	 Page<StudentGrade> failGradeSkip(Page<StudentGrade> page,int type)throws Exception;
	 /**
	  * show 查询学生及格及以上的学生成绩(首页)
	  * @param user 学生id
	  * @return 一页的数据 
	  * */
	 Page<StudentGrade> passGrade(String user)throws Exception;
	 /**
	  * show 查询学生及格成绩的指定type页数
	  * @param page 页的对象
	  * @param type 指定第几页
	  * @return 返回新的页的数据
	  * */
	 Page<StudentGrade> passGradeSkip(Page<StudentGrade> page,int type)throws Exception;
	
}
