package bookShopping.action;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;
import bookShopping.model.Cart;
import bookShopping.model.User;
import bookShopping.service.IBookService;
import bookShopping.service.ICartService;

public class CartAction extends BaseAction{
	ICartService cartService;
	IBookService bookService;
	
	private String buycount;//����һ��ͼ�������
	private long bid;//����ͼ���ID
	private int cartId;//ɾ��
	
	
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getBuycount() {
		return buycount;
	}

	public void setBuycount(String buycount) {
		this.buycount = buycount;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	/*���빺�ﳵ֮ǰ����֤һ��*/
	/*public void check(){
		User user=(User)getSession("user");
		try {
			if(cartService.loadCart(bid, user.getId())==null){
				addCart();
			}else{
				updateCart();
			}
			
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*�ڹ��ﳵ�����������*/
	public String addCart(){
		User user=(User)getSession("user");
		User u=new User();
		u.setId(user.getId());//�ѵ�ǰ�û�ID��ӵ�t_cart����
		Book b=new Book();
		b.setBid(bid);
		Book book=new Book();
		try {
			book = bookService.loadBook(bid);
		} catch (ShoppingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Cart c=new Cart();
		c.setCount(Integer.parseInt(buycount));
		DecimalFormat df = new DecimalFormat("#.00"); 
		/*c.setSubtotal(Double.valueOf(df.format(book.getCurrent_price()*c.getCount())));*/
		c.setUser(u);
		c.setBook(b);
		try {
			cartService.addCart(c);
			
		} catch (ShoppingException e) {
			String info="���빺�ﳵʧ�ܣ�"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return SUCCESS;
	}
	
	/*�޸Ĺ��ﳵ��Ʒ����*/
	/*public String updateCart(){
		Book book=new Book();
		try {
			book = bookService.loadBook(bid);
		} catch (ShoppingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		User user=(User)getSession("user");
		long userID=user.getId();
		
		
		User u=new User();
		u.setId(userID);//�ѵ�ǰ�û�ID��ӵ�t_cart����
		
		Book b=new Book();
		b.setBid(bid);
		
		Cart c=new Cart();
		c.setCartid(cartId);
		int updateCount=c.getCount();
		int a=Integer.parseInt(buycount);
		updateCount+=a;
		c.setCount(updateCount);
		c.setSubtotal(book.getCurrent_price()*c.getCount());
		c.setUser(u);
		c.setBook(b);
		
		try {
			cartService.updateCartList(c);;
			
		} catch (ShoppingException e) {
			String info="���빺�ﳵʧ�ܣ�"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return SUCCESS;
	}*/
	
	/*�ڹ��ﳵ�������*/
	public String cartList(){
		try {
			List<Cart> CartList=cartService.getCartList();
			if(CartList!=null){
				putContext("CartList", CartList);
			}else {
				return LIST;
			}
		} catch (ShoppingException e) {
			String info="��ȡ���ﳵ�б�ʧ�ܣ�"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return LIST;
	}
	
	/*ɾ��һ����¼*/
	 public String deleteCartList(){
		try {
			cartService.deleteCartList(cartId);
		} catch (ShoppingException e) {
			e.printStackTrace();
			return ERROR2;
		}
		return SUCCESS;
	 }
	
}
