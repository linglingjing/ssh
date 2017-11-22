package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Order;


public interface IOrderService {

	void addOrder(Order o) throws ShoppingException;
	List<Order> loadUnhandleOrder(int state) throws ShoppingException;
	void changeState(int state,long oid) throws ShoppingException;
	void deleteOrder(int id) throws ShoppingException;
	
  
    
    
    
}
