package bookShopping.model;

public class Comment {
	private long comId;
	private String content;//��������
	private User user;//�����û���ϵ
	private Book book;//����ͼ���ϵ
	
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
