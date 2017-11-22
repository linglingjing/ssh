package bookShopping.service.imp;

import java.util.List;

import org.apache.log4j.Logger;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ISItemDao;
import bookShopping.model.Admin;
import bookShopping.model.Item;
import bookShopping.model.SItem;
import bookShopping.service.ISItemService;

/**
 * �鱾ҵ����
 * @author jacky
 *
 */
public class SItemService implements ISItemService {
	private ISItemDao sitemDao;
	private SItem sitem;
	public ISItemDao getSitemDao() {
		return sitemDao;
	}
	public void setSitemDao(ISItemDao sitemDao) {
		this.sitemDao = sitemDao;
	}
	public SItem getSitem() {
		return sitem;
	}
	public void setSitem(SItem sitem) {
		this.sitem = sitem;
	}
	
	/*��ȡ�����б�*/
	@Override
	public List<SItem> getItems() throws ShoppingException {
		String hql="from SItem";
		List<SItem> list=sitemDao.list(hql);
		return list;
	}
	/*���һ�����������¼*/
	@Override
	public void addSItem(SItem sitem) throws ShoppingException {
		// TODO Auto-generated method stub
		sitemDao.add(sitem);
	}
	/*����IDɾ��һ�����������¼*/
	@Override
	public void deleteSItem(int id) throws ShoppingException{
		 sitemDao.delete(id);
	}
	/*����ID����һ����¼*/
	@Override
	public SItem loadSItem(int id) throws ShoppingException{
		return sitemDao.load(id);
	}
	/*�������cid��ѯ�������༯��*/
	public List<SItem> loadSItem2(long cid)throws ShoppingException{
		String hql="from SItem s where s.item.id=?";
		List<SItem> list=sitemDao.list(hql,cid);
		return list;
	}
	/*���ݶ����޸�һ����¼*/
	@Override
	public void updateSItem(SItem sitem) throws ShoppingException{
		sitemDao.update(sitem);;
	}
	
	
}
