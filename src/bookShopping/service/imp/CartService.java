package bookShopping.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICartDao;
import bookShopping.model.Book;
import bookShopping.model.Cart;
import bookShopping.model.SItem;
import bookShopping.service.ICartService;

/**
 * ����ҵ����
 * @author jacky
 *
 */
public class CartService implements ICartService {

	private ICartDao cartDao;
	private Cart cart;
	public ICartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/*���ݶ������*/
	@Override
	public void addCart(Cart c) throws ShoppingException {
		cartDao.add(c);
	}
	
	/*���ݶ��������*/
	@Override
	public List<Cart> getCartList() throws ShoppingException {
		String hql="select c from Cart as c";
		List<Cart> list=cartDao.list(hql);
		return list;
	}
	/*����IDȥɾ��һ��*/
	@Override
	public void deleteCartList(int id) throws ShoppingException {
		cartDao.delete(id);
	}
	/*�������sid��user��ID��ѯ����*/
	public List<Cart> loadCart(long bid,long sid)throws ShoppingException{
		Object[] args={bid,sid};
		String hql="from Cart c where c.book.bid=? and c.user.id=?";
		List<Cart> list=cartDao.list(hql, args);
		return list;
	}
	/*����IDȥ����*/
	@Override
	public void updateCartList(Cart c) throws ShoppingException {
		cartDao.update(c);
	}
	
}
