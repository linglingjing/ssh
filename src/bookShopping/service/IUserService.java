package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;
import bookShopping.model.User;

public interface IUserService {

	User login(String f_userName, String f_password)throws ShoppingException;

	void addUser(User u) throws ShoppingException;

	List<User> getUsers() throws ShoppingException;

	void deleteUser(int id) throws ShoppingException;
  
    
    
    
}
