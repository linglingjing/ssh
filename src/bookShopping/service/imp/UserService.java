package bookShopping.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IUserDao;
import bookShopping.model.Admin;
import bookShopping.model.Book;
import bookShopping.model.User;
import bookShopping.service.IUserService;

/**
 * �鱾ҵ����
 * @author jacky
 *
 */
public class UserService implements IUserService {

	
	private static Logger logger=Logger.getLogger(UserService.class);
	private IUserDao userDao;
	private User user;
	
	public static Logger getLogger() {
		return logger;
	}


	public static void setLogger(Logger logger) {
		UserService.logger = logger;
	}


	public IUserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	/*ע�ᣬ���һ����¼*/
	@Override
	public void addUser(User u) throws ShoppingException {
		// TODO Auto-generated method stub
		userDao.add(u);
	}
	/*��ȡ�û��б�*/
	@Override
	public List<User> getUsers() throws ShoppingException {
		String hql="from User";
		List<User> list=userDao.list(hql);
		return list;
	}
	
	/*����IDɾ��һ���û���¼*/
	@Override
	public void deleteUser(int id) throws ShoppingException{
		 userDao.delete(id);
		
	}
	
	@Override
	public User login(String f_userName, String f_password)
			throws ShoppingException {
		String hql="select s from User as s where username=:f_userName and password=:f_password ";
		Map<String,Object> alias=new HashMap<String, Object>();
		alias.put("f_userName", f_userName);
		alias.put("f_password", f_password);
		user=(User)userDao.queryObjectByAlias(hql, alias);
		if(user!=null){
			return user;
		}
		return null;
	}
	
	




}
