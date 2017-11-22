package bookShopping.model;


public class Cart {
	private long cartid;
	private Book book;	// 购物项中商品信息
	private User user;//一个用户对应一个购物车
	private int count;			// 购买某种商品数量
	
	
	
	
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
