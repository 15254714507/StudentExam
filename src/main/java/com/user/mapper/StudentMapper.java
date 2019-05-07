package com.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.topic.pojo.ChoiceQuestion;
import com.topic.pojo.ExamQuestion;
import com.topic.pojo.ModelAnswer;
import com.topic.pojo.ModelAnswerList;
import com.topic.pojo.ShortAnswerQuestion;
import com.topic.pojo.StudentTest;
import com.user.pojo.ExamArrange;
import com.user.pojo.StudentGrade;
import com.user.unit.Page;
/**
 * @author 孔超
 * @date 2019/5/4
 * 
 */
public interface StudentMapper {
	 /**
	  * show 去数据库中获取即将考试的总条数
	  * @param user 学生 id
	  * @return 返回int类型的总条数
	  * */
	 int  countComingTotal(@Param("user")String user) throws Exception;
	 /**
	  * show 把页的对象给数据库，根据里面的begin和end来返回新的即将考试的数据集合
	  * @param page 页的数据对象
	  * @return 关于即将考试的数据集合
	  * */
	 List<ExamArrange> listComingExamArrange(@Param("page")Page<ExamArrange> page ) throws Exception;
	 
	 /**
	  * show 去数据库中获取正在考试的总条数
	  * @param user 学生 id
	  * @return 返回即将考试的总条数
	  * */
	 int countUnderwayTotal(String user) throws Exception;
	 /**
	  * show 页的对象给数据库，根据里面的begin和end来返回新的即将考试的数据集合
	  * @param page 页的数据对象
	  * @return 关于即将考试的数据集合 
	  * */
	 List<ExamArrange> listUnderwayExamArrange(@Param("page")Page<ExamArrange> page) throws Exception;
	 /**
	  *show 看看返回的结果是1(已经考过，但是可能因为断网等重新考试) 
	  *@param user 学生id
	  *@param subject 考试科目
	  *@return 返回条数
	  * */
	 int  countExamQuestion(@Param("user")String user,@Param("subject")String subject)throws Exception; 
	 /**
	  * show 删除试卷
	  *@param user 学生id
	  *@param subject 考试科目
	  * */
	 void deleteExamQuestion(@Param("user")String user,@Param("subject")String subject)throws Exception;
	 /**
	  * show 删除答案卷
	  *@param user 学生id
	  *@param subject 考试科目
	  * */
	 void deleteExamAnswer(@Param("user")String user,@Param("subject")String subject)throws Exception;
	 /**
	  * show 获取选择题
	  * @param subject 科目
	  * @return 返回选择题集合
	  * */ 
	 List<ChoiceQuestion> listChoiceQuestion(@Param("subject")String subject) throws Exception;
	 /**
	  * show 获取简答题
	  * @param subject 科目
	  * @return 返回简答题集合
	  * */
	 List<ShortAnswerQuestion> listShortAnswerQuestion(@Param("subject")String subject) throws Exception;
	 /**
	  * show 把完整的试卷放进试卷表
	  * @param examQuestion 完整的试卷对象
	  * */
	 void insertQuestions(@Param("examQuestion")ExamQuestion examQuestion)throws Exception;
	 /**
	  * show 获取选择题的答案
	  * @param choic 选择题，里面有题的id
	  * @return 返回选择答案集合
	  * */
	 List<ModelAnswer> listChoiceModelAnswer(@Param("choic")List<ChoiceQuestion> choic)throws Exception;
	 /**
	  * show 获取简答题的答案
	  * @param shortAnswer 简答题，里面有题的id
	  * @return 返回简答答案集合
	  * */
	 List<ModelAnswer> listShortModelAnswer(@Param("shortAnswer")List<ShortAnswerQuestion> shortAnswer)throws Exception;
	 /**
	  * show 把试卷的答案插入答案表
	  * @param modelAnswerList 标准答案的集合
	  * */
	 void insertModelAnswers(@Param("modelAnswerList")ModelAnswerList modelAnswerList)throws Exception;
	 
	 /**
	  * show 修改考试状态，由0变成1
	  * @param user 学生id
	  * @param subject 考试科目
	  * */
	 void updateState(@Param("user")String user,@Param("subject")String subject)throws Exception;
	 /**
	  * show 获得试卷的标准答案
	  * @param user 学生id
	  * @param subject 考试科目
	  * @return 返回学生标准答案试卷
	  * */
	 StudentTest getModelAnswer(@Param("user")String user,@Param("subject")String subject)throws Exception;
	 /**
	  * show 把学生成绩放进成绩表
	  * @param studentGrade 学生成绩信息
	  * */
	 void insertGrade(@Param("studentGrade")StudentGrade studentGrade)throws Exception;
	 /**
	  * show 把学生的做的卷子保存在学生提交试卷库中，因为简答题还是需要老师去改
	  * @param studentTest 学生提交的试卷
	  * */
	 void insertStudentTest(@Param("studentTest") StudentTest studentTest)throws Exception;
	 /**
	  * show 统计错过考试的条数
	  * @param user 学生id
	  * @return 返回数字
	  * */
	 int  countPassedTotal(@Param("user")String user) throws Exception;
	 /**
	  * show 获取错过考试的集合
	  * @param page 页的信息
	  * @return 返回学生错过考试信息的集合
	  * */
	 List<ExamArrange> listPassedExamArrange(@Param("page")Page<ExamArrange> page) throws Exception;
	 /**
	  * show 所有的成绩的条数
	  * @param user 学生id
	  * @return 条数数字
	  * */
	 int  countAllGradeTotal(@Param("user")String user) throws Exception;
	 /**
	  * show  按指定页数来查询需要的那一页所有成绩的集合
	  * @param page 页的数据
	  * @return 返回的集合
	  * */
	 List<StudentGrade> listAllGrade(@Param("page")Page<StudentGrade> page) throws Exception;
	 /**
	  * show 根据分类来进行查询总条数
	  * @param user 学生 id
	  * @param content 查询条件
	  * @return 返回条数
	  * */
	 int  countSearchGradeTotal(@Param("user")String user,@Param("content")String content) throws Exception;
	 /**
	  * show 根据分类去数据库搜索指定的页数的数据
	  * @param page 页的数据，但是里面有新的页数
	  * @return 返回指定页数数据集合
	  * */
	 List<StudentGrade> listSearchGrade(@Param("page")Page<StudentGrade> page) throws Exception;
	 /**
	  *  show 查询不及格的总条数
	  * @param user 学生 id
	  * @param content 查询条件
	  * @return 返回条数
	  * */
	 int  countFailGradeTotal(@Param("user")String user) throws Exception;
	 /**
	  * show 根据指定的页数来查询不及格的数据的集合
	  * @param page 页的数据，但是里面有新的页数
	  * @return 返回指定页数数据集合
	  * */
	 List<StudentGrade> listFailGrade(@Param("page")Page<StudentGrade> page) throws Exception;
	 /**
	  * show 查询及格的总条数
	  * @param user 学生 id
	  * @param content 查询条件
	  * @return 返回条数
	  * */
	 int  countPassGradeTotal(@Param("user")String user) throws Exception;
	 /**
	  * show 根据指定的页数来查询及格的数据的集合
	  * @param page 页的数据，但是里面有新的页数
	  * @return 返回指定页数数据集合
	  * */
	 List<StudentGrade> listPassGrade(@Param("page")Page<StudentGrade> page) throws Exception;
	
}
