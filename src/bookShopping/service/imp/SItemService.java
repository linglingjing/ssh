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
 * 书本业务类
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
	
	/*获取二级列表*/
	@Override
	public List<SItem> getItems() throws ShoppingException {
		String hql="from SItem";
		List<SItem> list=sitemDao.list(hql);
		return list;
	}
	/*添加一条二级分类记录*/
	@Override
	public void addSItem(SItem sitem) throws ShoppingException {
		// TODO Auto-generated method stub
		sitemDao.add(sitem);
	}
	/*根据ID删除一条二级分类记录*/
	@Override
	public void deleteSItem(int id) throws ShoppingException{
		 sitemDao.delete(id);
	}
	/*根据ID加载一条记录*/
	@Override
	public SItem loadSItem(int id) throws ShoppingException{
		return sitemDao.load(id);
	}
	/*根据外键cid查询二级分类集合*/
	public List<SItem> loadSItem2(long cid)throws ShoppingException{
		String hql="from SItem s where s.item.id=?";
		List<SItem> list=sitemDao.list(hql,cid);
		return list;
	}
	/*根据对象修改一条记录*/
	@Override
	public void updateSItem(SItem sitem) throws ShoppingException{
		sitemDao.update(sitem);;
	}
	
	
}
