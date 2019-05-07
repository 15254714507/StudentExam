package com.user.mapper;

import com.login.pojo.User;
/**
 * @author 孔超
 * @date 2019/5/2
 * 
 * */
public interface InitialMapper {
	 /**
	  * show 去数据库中修改学生的个人信息
	  * @param user 保存有学生新的基本信息
	  * @exception 可能会有修改失败异常
	  * */
	 void updateStudentMessage(User user)throws Exception;
	 /**
	  * show 去数据库中修改老师的个人信息
	  * @param  user 保存有老师新的基本信息
	  * @exception 可能会有修改失败异常
	  * */
	 void updateTeacherMessage(User user)throws Exception;
}
