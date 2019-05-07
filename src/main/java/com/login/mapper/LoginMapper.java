package com.login.mapper;
import com.login.pojo.StudentUser;
import com.login.pojo.User;
/**
 * @author 孔超
 * @date 2019/5/1
 *
 * */
public interface LoginMapper {
	
	 /**
	  * show 去数据库验证是否有这个人的存在
	  * @param user service传来的对象，里面有登录者的账号和密码信息
	  * @return 返回一个包含学生信息的对象
	  * @exception 有可能数据库连接异常
	  * */
	 StudentUser getStudentUser(User user) throws Exception;
	 
	 /**
	  * show 去数据库查此账号的信息
	  * @param user 里面有想修改密码的账号
	  * @return 返回一个学生信息的对象，为下一步做准备
	  * @exception 有可能数据库连接异常
	  * */
	 StudentUser getStudentMessage(User user) throws Exception ;
	 /**
	  * show 去数据库修改账号的密码
	  * @param user 里面有需要修改的新密码与对应的账号
	  * @exception 如果修改失败有可能需要事务回滚
	  * */
	 void updateStudentMessage(User user)throws Exception;
}
