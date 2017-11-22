package bookShopping.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Book;
import bookShopping.model.Cart;
import bookShopping.model.Order;
import bookShopping.model.OrderList;
import bookShopping.model.User;
import bookShopping.service.ICartService;
import bookShopping.service.IOrderListService;
import bookShopping.service.IOrderService;
import bookShopping.service.IUserService;

public class OrderAction extends BaseAction{
	IOrderService orderService;
	IOrderListService orderListService;
	ICartService cartService;
	
	private String address;
	private String totalprice;
	private int oid;//订单号
	
	
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public IOrderListService getOrderListService() {
		return orderListService;
	}

	public void setOrderListService(IOrderListService orderListService) {
		this.orderListService = orderListService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	
	/*生成订单*/
	public String addOrder(){
		List<Cart> cartlist = null;
		User user=(User)getSession("user");//获得当前用户对象
		User u=new User();
		u.setId(user.getId());
		
		Order order=new Order();
		order.setUser(u);
		order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		order.setState(2);//生成订单即已付款
		order.setAddress(address);
		order.setTotalPrice(Double.valueOf(totalprice));
		try {
			orderService.addOrder(order);
			cartlist=cartService.getCartList();
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < cartlist.size(); i++) {
			Book b=new Book();
			b.setBid(cartlist.get(i).getBook().getBid());
			
			OrderList orderlist=new OrderList();
			orderlist.setBook(b);
			orderlist.setOrder(order);
			try {
				orderListService.addOrderList(orderlist);
				for(int j=0;j<cartlist.size();j++){
					cartService.deleteCartList((int)cartlist.get(i).getCartid());
				}
			} catch (ShoppingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "checkout";
	}
	
	
	/*未处理订单查询*/
	public String unhandleOrder(){
		try {
			List<Order> unhandleOrder=orderService.loadUnhandleOrder(2);
			putContext("unhandleOrder", unhandleOrder);
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
		return LIST;
	}
	
	/*已处理订单查询*/
	public String Orders(){
		try {
			List<Order> orders=orderService.loadUnhandleOrder(3);
			putContext("orders", orders);
			for (int i = 0; i < orders.size(); i++) {
				System.out.println(orders.get(i).getAddress()+"QQQ");
			}
		} catch (ShoppingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*修改订单状态*/
	public String changeOrderState(){
		try {
			orderService.changeState(3, oid);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "orderlist";
	}
	
	/*删除订单*/
	/*public String deleteOrder(){
		System.out.println(oid);
		try {
			orderService.deleteOrder(oid);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "orderlist";
	}*/
}
