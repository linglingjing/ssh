package bookShopping.model;

//书本实体类
public class Book {
    
	//OID:ojbect identity 对象标识符,把Book声明为持久化的类
	private long bid;//图书ID
	private String bookName;//图书名
	private float original_price;//图书原价
	private float current_price;//优书价
	private String author;//图书作者
	private String publisher;//出版社
	private String publishDate;//出版日期
	private String info;//图书简介
	private String photoURL;//存储图片的路径
	private int quantity;//图书库存
	
	// 二级分类的外键:使用二级分类的对象.
	private SItem secondCategory;
	
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public SItem getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(SItem secondCategory) {
		this.secondCategory = secondCategory;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(float original_price) {
		this.original_price = original_price;
	}
	public float getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	
	
	
	
	
	
}
