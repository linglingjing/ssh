package bookShopping.model;

public class Order {
	private long oid;//����ID
	private Integer state;//1:δ����  2:�����Ѿ�����   3:�Ѿ�����   4:��������   
	private double totalPrice;//�����ܽ��
	private String address;//��ַ
	private String orderTime;//�µ�ʱ��
	// �û������:����
	private User user;
	
	
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
