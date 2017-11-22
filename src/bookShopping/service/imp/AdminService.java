package bookShopping.service.imp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import bookShopping.Exception.ShoppingException;
import bookShopping.action.AdminAction;
import bookShopping.dao.IAdminDao;
import bookShopping.dao.imp.AdminDao;
import bookShopping.model.Admin;
import bookShopping.model.Book;
import bookShopping.service.IAdminService;

public class AdminService implements IAdminService{
	
	private static Logger logger=Logger.getLogger(AdminService.class);
	private IAdminDao adminDao;
	private Admin admin;
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		AdminService.logger = logger;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	

	@Override
	public Admin login(String f_adminName, String f_password)
			throws ShoppingException {
		String hql="select s from Admin as s where adminName=:f_adminName and password=:f_password ";
		Map<String,Object> alias=new HashMap<String, Object>();
		alias.put("f_adminName", f_adminName);
		alias.put("f_password", f_password);
		admin=(Admin)adminDao.queryObjectByAlias(hql, alias);
		if(admin!=null){
			return admin;
		}
		return null;
	}

	@Override
	public List<Admin> getAdmins() throws ShoppingException {
		String hql="from Admin";
		List<Admin> AdminList=adminDao.list(hql);
		return AdminList;
	}
	
	@Override
	public void addAdmin(Admin a) throws ShoppingException {
		// TODO Auto-generated method stub
		adminDao.add(a);
	}
	
	/*根据ID删除一条记录*/
	@Override
	public void deleteAdmin(int id) throws ShoppingException{
		 adminDao.delete(id);
		
	}
	/*根据ID查找一条记录*/
	@Override
	public Admin findAdmin(int id) throws ShoppingException{
		String hql="select s from Admin as s where id=:id";
		Map<String,Object> alias=new HashMap<String, Object>();
		alias.put("m_id", id);
		admin=(Admin)adminDao.queryObjectByAlias(hql, alias);
		if(admin!=null){
			return admin;
		}
		return null;
		
	}
	/*根据ID加载一条记录*/
	@Override
	public Admin loadAdmin(int id) throws ShoppingException{
		return adminDao.load(id);
	}
	/*根据ID更新一条记录*/
	@Override
	public void updateAdmin(Admin admin) throws ShoppingException{
		adminDao.update(admin);
	}

}
