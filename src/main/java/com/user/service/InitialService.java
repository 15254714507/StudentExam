package com.user.service;


import com.login.pojo.User;
/**
 * @author 孔超
 * @date 2019/5/2
 * */
public interface InitialService {
	 /**
	  * show 把controller需要修改的学生对象传给InitialMapper
	  * @param user 需要修改的学生对象的信息，包括账号密码，包括密保信息
	  * @exception 可能会修改失败 强制手动事务回滚
	  * */
	 void updateStudentMessage(User user)throws Exception;
	 /**
	  * show 把controller需要修改的老师对象传给InitialMapper
	  * @param user 需要修改的老师对象的信息，包括账号密码，包括密保信息
	  * @exception 可能会修改失败 强制手动事务回滚
	  * */
	 void updateTeacherMessage(User user)throws Exception;
}
