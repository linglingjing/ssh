package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	private long id;//�û�ID
	private String username;//�û���
	private String password;//�û�����
	private String telephone;//�û��ֻ�����
	// һ���û���Ӧ�������:
	private Set<Order> orders = new HashSet<Order>();
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
