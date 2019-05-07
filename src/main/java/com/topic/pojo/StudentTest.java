package com.topic.pojo;

/**
 * @author 孔超
 * @date 2019.4.30
 * 
 * */
public class StudentTest {
	private String user;
	private String subject;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	private String t13;
	private String t14;
	private String t15;
	private String t16;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT4() {
		return t4;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public String getT5() {
		return t5;
	}
	public void setT5(String t5) {
		this.t5 = t5;
	}
	public String getT6() {
		return t6;
	}
	public void setT6(String t6) {
		this.t6 = t6;
	}
	public String getT7() {
		return t7;
	}
	public void setT7(String t7) {
		this.t7 = t7;
	}
	public String getT8() {
		return t8;
	}
	public void setT8(String t8) {
		this.t8 = t8;
	}
	public String getT9() {
		return t9;
	}
	public void setT9(String t9) {
		this.t9 = t9;
	}
	public String getT10() {
		return t10;
	}
	public void setT10(String t10) {
		this.t10 = t10;
	}
	public String getT11() {
		return t11;
	}
	public void setT11(String t11) {
		this.t11 = t11;
	}
	public String getT12() {
		return t12;
	}
	public void setT12(String t12) {
		this.t12 = t12;
	}
	public String getT13() {
		return t13;
	}
	public void setT13(String t13) {
		this.t13 = t13;
	}
	public String getT14() {
		return t14;
	}
	public void setT14(String t14) {
		this.t14 = t14;
	}
	public String getT15() {
		return t15;
	}
	public void setT15(String t15) {
		this.t15 = t15;
	}
	public String getT16() {
		return t16;
	}
	public void setT16(String t16) {
		this.t16 = t16;
	}
	
	public int equalsClass(StudentTest st1) {
		int sum=0;
		if(st1.getT1()!=null&&this.t1.equals(st1.getT1())){
			++sum;
		}
		if(st1.getT2()!=null&&this.t2.equals(st1.getT2())){
			++sum;
		}
		if(st1.getT3()!=null&&this.t3.equals(st1.getT3())){
			++sum;
		}
		if(st1.getT4()!=null&&this.t4.equals(st1.getT4())){
			++sum;
		}
		if(st1.getT5()!=null&&this.t5.equals(st1.getT5())){
			++sum;
		}
		if(st1.getT6()!=null&&this.t6.equals(st1.getT6())){
			++sum;
		}
		if(st1.getT7()!=null&&this.t7.equals(st1.getT7())){
			++sum;
		}
		if(st1.getT8()!=null&&this.t8.equals(st1.getT8())){
			++sum;
		}
		if(st1.getT9()!=null&&this.t9.equals(st1.getT9())){
			++sum;
		}
		if(st1.getT10()!=null&&this.t10.equals(st1.getT10())){
			++sum;
		}
		return sum;
	}
	@Override
	public String toString() {
		return "StudentTest [user=" + user + ", subject=" + subject + ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3
				+ ", t4=" + t4 + ", t5=" + t5 + ", t6=" + t6 + ", t7=" + t7 + ", t8=" + t8 + ", t9=" + t9 + ", t10="
				+ t10 + ", t11=" + t11 + ", t12=" + t12 + ", t13=" + t13 + ", t14=" + t14 + ", t15=" + t15 + ", t16="
				+ t16 + "]";
	}
	
	
}
