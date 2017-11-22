package bookShopping.model;

import java.util.Date;

public class Admin {
	private long id;//管理员ID
	private String adminName;//管理员用户名
	private String password;//管理员密码
	private String registerDate;
	private int limits;//0--超级管理员，1--普通管理员
	
	
	
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLimits() {
		return limits;
	}
	public void setLimits(int limits) {
		this.limits = limits;
	}
	
}
