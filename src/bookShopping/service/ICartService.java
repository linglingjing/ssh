package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Cart;


public interface ICartService {

	void addCart(Cart c) throws ShoppingException;

	List<Cart> getCartList() throws ShoppingException;

	void deleteCartList(int id) throws ShoppingException;

	void updateCartList(Cart c) throws ShoppingException;
	
	List<Cart> loadCart(long bid,long sid)throws ShoppingException;

	
  
    
    
    
}
