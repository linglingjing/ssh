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
 * �鱾ҵ����
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

	/*���һ��һ�������¼*/
	@Override
	public void addItem(Item i) throws ShoppingException {
		// TODO Auto-generated method stub
		itemDao.add(i);
	}
	/*��ȡһ���б�*/
	@Override
	public List<Item> getItems() throws ShoppingException {
		String hql="from Item";
		List<Item> list=itemDao.list(hql);
		return list;
	}
	
	/*����IDɾ��һ������*/
	@Override
	public void deleteItem(int id) throws ShoppingException{
		 itemDao.delete(id);
	}
	/*����ID����һ������*/
	@Override
	public Item loadItem(int id) throws ShoppingException{
		return itemDao.load(id);
	}
	/*����ID����һ����¼*/
	@Override
	public void updateItem(Item i) throws ShoppingException{
		itemDao.update(i);
	}
	



	

}
