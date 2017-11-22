package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.SItem;

public interface ISItemService{

	List<SItem> getItems() throws ShoppingException;
	void addSItem(SItem sitem) throws ShoppingException;
	void deleteSItem(int id) throws ShoppingException;
	SItem loadSItem(int id) throws ShoppingException;
	void updateSItem(SItem sitem) throws ShoppingException;
	List<SItem> loadSItem2(long cid)throws ShoppingException;

}