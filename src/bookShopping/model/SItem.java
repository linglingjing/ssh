package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class SItem {
	private long sid;
	private String sname;
	// 所属一级分类.存的是一级分类的对象.
	private Item item;
	// 配置书本集合
	private Set<Book> books = new HashSet<Book>();
		
		
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
