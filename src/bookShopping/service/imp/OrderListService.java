package bookShopping.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IOrderListDao;
import bookShopping.model.Book;
import bookShopping.model.OrderList;
import bookShopping.model.SItem;
import bookShopping.service.IOrderListService;

/**
 * 订单业务类
 * @author jacky
 *
 */
public class OrderListService implements IOrderListService {

	private IOrderListDao orderListDao;
	private OrderList orderlist;
	public IOrderListDao getOrderListDao() {
		return orderListDao;
	}
	public void setOrderListDao(IOrderListDao orderListDao) {
		this.orderListDao = orderListDao;
	}
	public OrderList getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(OrderList orderlist) {
		this.orderlist = orderlist;
	}
	
	@Override
	public void addOrderList(OrderList ol) throws ShoppingException {
		orderListDao.add(ol);
	}

	
	
}
