package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;
import bookShopping.model.Item;

public interface IItemService {

	void addItem(Item i) throws ShoppingException;

	List<Item> getItems() throws ShoppingException;

	void deleteItem(int id) throws ShoppingException;

	Item loadItem(int id) throws ShoppingException;

	void updateItem(Item i) throws ShoppingException;

    
    
    
}
