package bookShopping.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IOrderDao;
import bookShopping.model.Book;
import bookShopping.model.Order;
import bookShopping.service.IOrderService;

/**
 * ����ҵ����
 * @author jacky
 *
 */
public class OrderService implements IOrderService {

	private IOrderDao orderDao;
	private Order order;
	public IOrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	/*���ݶ������*/
	@Override
	public void addOrder(Order o) throws ShoppingException {
		orderDao.add(o);
	}
	/*���ݶ���״̬��ѯ*/
	public List<Order> loadUnhandleOrder(int state) throws ShoppingException{
		String hql="select s from Order as s where s.state=?";
		List<Order> list=orderDao.list(hql,state);
		return list;
	}
	/*���Ķ���״̬*/
	public void changeState(int state,long oid) throws ShoppingException{
		String hql="update Order o set o.state=? where o.oid=?";
		Object[] obj={state,oid};
		orderDao.updateByHql(hql,obj);
	}
	/*����IDɾ��һ����¼*/
	@Override
	public void deleteOrder(int id) throws ShoppingException{
		orderDao.delete(id);
	}
	
}
