package bookShopping.model;

public class OrderList {
	private long olistID;
	private Book book;
	private Order order;
	
	public long getOlistID() {
		return olistID;
	}
	public void setOlistID(long olistID) {
		this.olistID = olistID;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
