package bookShopping.model;


public class Cart {
	private long cartid;
	private Book book;	// ����������Ʒ��Ϣ
	private User user;//һ���û���Ӧһ�����ﳵ
	private int count;			// ����ĳ����Ʒ����
	
	
	
	
	public long getCartid() {
		return cartid;
	}
	public void setCartid(long cartid) {
		this.cartid = cartid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
