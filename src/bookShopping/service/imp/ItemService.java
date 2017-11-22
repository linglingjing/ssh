package bookShopping.service.imp;

import java.util.List;

import org.apache.log4j.Logger;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IItemDao;
import bookShopping.dao.IUserDao;
import bookShopping.model.Admin;
import bookShopping.model.Item;
import bookShopping.model.User;
import bookShopping.service.IItemService;

/**
 * 书本业务类
 * @author jacky
 *
 */
public class ItemService implements IItemService {
	private IItemDao itemDao;
	private Item item;
	
	
	public IItemDao getItemDao() {
		return itemDao;
	}
	public void setItemDao(IItemDao itemDao) {
		this.itemDao = itemDao;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	/*添加一条一级分类记录*/
	@Override
	public void addItem(Item i) throws ShoppingException {
		// TODO Auto-generated method stub
		itemDao.add(i);
	}
	/*获取一级列表*/
	@Override
	public List<Item> getItems() throws ShoppingException {
		String hql="from Item";
		List<Item> list=itemDao.list(hql);
		return list;
	}
	
	/*根据ID删除一级分类*/
	@Override
	public void deleteItem(int id) throws ShoppingException{
		 itemDao.delete(id);
	}
	/*根据ID加载一级分类*/
	@Override
	public Item loadItem(int id) throws ShoppingException{
		return itemDao.load(id);
	}
	/*根据ID更新一条记录*/
	@Override
	public void updateItem(Item i) throws ShoppingException{
		itemDao.update(i);
	}
	



	

}
