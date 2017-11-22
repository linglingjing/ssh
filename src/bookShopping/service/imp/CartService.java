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
 * 订单业务类
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
	
	/*根据对象添加*/
	@Override
	public void addCart(Cart c) throws ShoppingException {
		cartDao.add(c);
	}
	
	/*根据对象读数据*/
	@Override
	public List<Cart> getCartList() throws ShoppingException {
		String hql="select c from Cart as c";
		List<Cart> list=cartDao.list(hql);
		return list;
	}
	/*根据ID去删除一条*/
	@Override
	public void deleteCartList(int id) throws ShoppingException {
		cartDao.delete(id);
	}
	/*根据外键sid和user的ID查询集合*/
	public List<Cart> loadCart(long bid,long sid)throws ShoppingException{
		Object[] args={bid,sid};
		String hql="from Cart c where c.book.bid=? and c.user.id=?";
		List<Cart> list=cartDao.list(hql, args);
		return list;
	}
	/*根据ID去更新*/
	@Override
	public void updateCartList(Cart c) throws ShoppingException {
		cartDao.update(c);
	}
	
}
