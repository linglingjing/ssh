package bookShopping.model;

public class Comment {
	private long comId;
	private String content;//评论内容
	private User user;//键入用户关系
	private Book book;//键入图书关系
	
	public long getComId() {
		return comId;
	}
	public void setComId(long comId) {
		this.comId = comId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
