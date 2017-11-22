package bookShopping.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.OrderList;
import bookShopping.service.IOrderListService;
import bookShopping.service.IOrderService;


public class OrderListAction extends BaseAction{
	IOrderService orderService;
	IOrderListService orderListService;
	private int oid;
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public IOrderListService getOrderListService() {
		return orderListService;
	}
	public void setOrderListService(IOrderListService orderListService) {
		this.orderListService = orderListService;
	}
	
	
	
}
