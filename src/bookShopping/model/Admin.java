package bookShopping.model;

import java.util.Date;

public class Admin {
	private long id;//����ԱID
	private String adminName;//����Ա�û���
	private String password;//����Ա����
	private String registerDate;
	private int limits;//0--��������Ա��1--��ͨ����Ա
	
	
	
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
