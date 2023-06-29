package jp.co.aforce.bean;

import java.io.Serializable;

public class MemberBean implements Serializable{
    
	private String member_id;
	private String password;
	private String member_name;
	private String home_address;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private String job;
	private String phone_number;
	private String mail_address;
	
	public String getMember_id() {
		return member_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getMember_name() {
		return member_name;
	}
	
	public String getHome_address() {
		return home_address;
	}
	
	public int getBirth_year() {
		return birth_year;
	}
	
	public int getBirth_month() {
		return birth_month;
	}
	
	public int getBirth_day() {
		return birth_day;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public String getMail_address(){
		return mail_address;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMember_name(String member_name) {
	    this.member_name = member_name;	
	}
	
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	
	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}
	
	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

}
