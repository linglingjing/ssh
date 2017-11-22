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
	
	private String buycount;//购买一种图书的数量
	private long bid;//购买图书的ID
	private int cartId;//删除
	
	
	
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
	/*加入购物车之前先验证一下*/
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
	/*在购物车表里添加数据*/
	public String addCart(){
		User user=(User)getSession("user");
		User u=new User();
		u.setId(user.getId());//把当前用户ID添加到t_cart表中
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
			String info="加入购物车失败！"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return SUCCESS;
	}
	
	/*修改购物车商品数量*/
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
		u.setId(userID);//把当前用户ID添加到t_cart表中
		
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
			String info="加入购物车失败！"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return SUCCESS;
	}*/
	
	/*在购物车里读数据*/
	public String cartList(){
		try {
			List<Cart> CartList=cartService.getCartList();
			if(CartList!=null){
				putContext("CartList", CartList);
			}else {
				return LIST;
			}
		} catch (ShoppingException e) {
			String info="获取购物车列表失败！"+e.getMessage(); 
	    	putContext("error",info);
	    	return ERROR2;
		}
		return LIST;
	}
	
	/*删除一条记录*/
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
