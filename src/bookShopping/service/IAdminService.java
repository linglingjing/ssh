package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;

public interface IAdminService {
   //声明写了的方法 
	Admin login(String f_adminName, String f_password) throws ShoppingException;
	void addAdmin(Admin a) throws ShoppingException;
	void deleteAdmin(int id) throws ShoppingException;

	void updateAdmin(Admin admin) throws ShoppingException;

	Admin findAdmin(int id) throws ShoppingException;

	List<Admin> getAdmins() throws ShoppingException;

	Admin loadAdmin(int id) throws ShoppingException;


	
}
