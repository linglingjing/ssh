package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class SItem {
	private long sid;
	private String sname;
	// ����һ������.�����һ������Ķ���.
	private Item item;
	// �����鱾����
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
