package bookShopping.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;
import bookShopping.model.Item;
import bookShopping.model.SItem;
import bookShopping.service.IBookService;
import bookShopping.service.IItemService;
import bookShopping.service.ISItemService;
public class BookAction extends BaseAction {
	IBookService bookService;
	IItemService itemService;
	ISItemService sitemService;
	private Map<Long, List<SItem>> subCategoryMap = new HashMap<Long, List<SItem>>();
	/*添加图书*/
	private int bid=-1;
	private String bookName;
	private String original_price;
	private String current_price;
	private String author;
	private String publisher;
	private String info;
	private String quantity;
	private String cid;
	private String sid;
	private String publishDate;
	//以下是文件上传
	private File photo;//图片文件
	private String photoFileName;//文件名
	private String photoContentType;//文件类型
	private String savePath=ServletActionContext.getServletContext().getRealPath("Upload");//文件上传路径
	/*添加图书*/
	
	private int deleteBId;//删除一本图书
	private String ids;//批量删除图书
	
	private int SID;//获得前台二级分类的ID
	
	
  	public Map<Long, List<SItem>> getSubCategoryMap() {
		return subCategoryMap;
	}
	public void setSubCategoryMap(Map<Long, List<SItem>> subCategoryMap) {
		this.subCategoryMap = subCategoryMap;
	}
	public ISItemService getSitemService() {
		return sitemService;
	}
	public void setSitemService(ISItemService sitemService) {
		this.sitemService = sitemService;
	}
	public IBookService getBookService() {
		return bookService;
	}
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public IItemService getItemService() {
		return itemService;
	}
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}
	public String getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(String current_price) {
		this.current_price = current_price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}	
	public int getDeleteBId() {
		return deleteBId;
	}
	public void setDeleteBId(int deleteBId) {
		this.deleteBId = deleteBId;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	/*加载一级分类和二级分类下拉框*/
	public String SelectMenu(){
		try {
		    List<Item> selectMenus=itemService.getItems();
		    putContext("selectMenus", selectMenus);
		    System.out.println(selectMenus.get(1).getCid()+" 属于经济管理的一级ID");
		    for (int i = 0; i < selectMenus.size(); i++) {
		    	List<SItem> selectSubmenus = new ArrayList<SItem>();
		    	//根据一级的ID加载数据集合，即根据二级的外键查找
		    	selectSubmenus = sitemService.loadSItem2(selectMenus.get(i).getCid());
		    	subCategoryMap.put(selectMenus.get(i).getCid(),selectSubmenus);
			}
			 return "selectmenus";
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	
	/*根据添加一本图书*/
	 public String addBook(){
		 SItem si=new SItem();
		 si.setSid(Integer.parseInt(sid));
		 Book b=new Book();
		 b.setSecondCategory(si);
		 b.setBookName(bookName);
		 b.setOriginal_price(Float.parseFloat(original_price));
		 b.setCurrent_price(Float.parseFloat(current_price));
		 b.setAuthor(author);
		 b.setInfo(info);
		 b.setPublisher(publisher);
		 b.setQuantity(Integer.parseInt(quantity));
		 b.setPublishDate(publishDate);
		 if(photo!=null){
			/*上传文件处理*/
			/*生成唯一文件名*/
			 String newfileName=UUID.randomUUID().toString().substring(0,8);
			 newfileName+=getPhotoFileName().substring(getPhotoFileName().lastIndexOf("."));
			 try{
				 //以服务器的文件保存地址和新文件创建长传文件输出流
				 FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+newfileName);
				 FileInputStream fis=new FileInputStream(getPhoto());
				 byte[] buffer=new byte[1024];
				 int len=0;
				 try{
					 while((len=fis.read(buffer))>0){
						 fos.write(buffer, 0, len);
					 }
					 System.out.println(getSavePath()+"\\"+newfileName);
					 b.setPhotoURL("/SecondBookShopping/Upload/"+newfileName);
				 }catch(IOException e){
					 e.printStackTrace();
					 return ERROR;
				 }
			 }catch(FileNotFoundException e){
				 e.printStackTrace();
				 return ERROR;
			 }
		 }
			 /*添加修改使用同一个方法,bid==-1表示添加，若bid为其他值表示修改*/
			 if(bid!=-1){
				 b.setBid(bid);
				 try {
					bookService.updateBook(b);
				} catch (ShoppingException e) {
					String info="修改书本失败！"+e.getMessage(); 
			    	putContext("error",info);
			    	 return ERROR;
				}
				 
			 }else{
				 try {
						bookService.addBook(b);
					} catch (ShoppingException e) {
						String info="添加书本失败！"+e.getMessage(); 
				    	putContext("error",info);
				    	 return ERROR;
					}
			 }
			 return "booklist";
		 }
		
	 
	 
	 /*读取书本列表*/
	 public String BookList(){
			try {
				List<Book> BookList=bookService.getBooks();
				putContext("BookList", BookList);
			} catch (ShoppingException e) {
				String info="获取书本列表失败！"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return LIST; 
	}
	
	 /*根据删除一本书*/
	 public String DeleteBook(){
			try {
				bookService.deleteBook(deleteBId);
				return "booklist";
			} catch (ShoppingException e) {
				String info="删除图书失败！"+e.getMessage(); 
		    	putContext("error",info);
			}
			return ERROR;
		 }
	 /*批量删除图书记录*/
	 public String DeleteBooks(){
		 System.out.println("ids是"+ids);
		String[] chkValues = ids.split(",");
		 int[] idslist = new int[chkValues.length];
		 for(int i=0;i<chkValues.length;i++){
			 idslist[i]=Integer.parseInt(chkValues[i]);
			 }
		 try {
			 for(int i=0;i<idslist.length;i++){
				 System.out.println(idslist);
				bookService.deleteBook(idslist[i]);
		 	}
			 return "booklist";
		 } catch (ShoppingException e) {
			 String info="批量删除图书失败！"+e.getMessage(); 
	    	 putContext("error",info);	
			}
		 return ERROR;
	 }
	
	  /*加载当前修改对象*/
	 public String loadBook(){
		 try {
			 SelectMenu();
			 Book book=bookService.loadBook(deleteBId);
			 putContext("book", book);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "获取当前图书信息失败"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 /*前台加载书本详情的当前对象*/
	 public String loadDetailBook(){
		 try {
			Book detailBook=bookService.loadBook(deleteBId);
			putContext("detailBook", detailBook);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "获取当前图书详情信息失败！"+e.getMessage());
			return ERROR;
		}
		 return "detailbook";
	 }
	 
	/*首页图书推荐*/
	 public String recommendBooks(){
		 try {
			List<Book> BookList=bookService.getBooks();
			List<Book> subBookList1=BookList.subList(BookList.size()-4, BookList.size());
			List<Book> subBookList2=BookList.subList(BookList.size()-8, BookList.size()-4);
			putContext("subBookList1", subBookList1);
			putContext("subBookList2", subBookList2);
		} catch (ShoppingException e) {
			putContext("errorinfo", "图书推荐信息获取失败！"+e.getMessage());
			return ERROR;
		}
		 return "indexbooks";
	 }
	 
	 /*商品列表展示*/
	 public String subBooks(){
		 try {
			List<Book> subBookList=bookService.loadsubBooks(SID);
			putContext("subBookList", subBookList);
		 } catch (ShoppingException e) {
			putContext("errorinfo", "图书列表获取失败！"+e.getMessage());
			return ERROR;
		}
		 return "subbooklist";
	 }
	 
	 
	 
	 
	 
	 
}
