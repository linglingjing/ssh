package bookShopping.model;

//�鱾ʵ����
public class Book {
    
	//OID:ojbect identity �����ʶ��,��Book����Ϊ�־û�����
	private long bid;//ͼ��ID
	private String bookName;//ͼ����
	private float original_price;//ͼ��ԭ��
	private float current_price;//�����
	private String author;//ͼ������
	private String publisher;//������
	private String publishDate;//��������
	private String info;//ͼ����
	private String photoURL;//�洢ͼƬ��·��
	private int quantity;//ͼ����
	
	// ������������:ʹ�ö�������Ķ���.
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
