package bookShopping.service.imp;

import java.util.List;

import org.apache.log4j.Logger;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.IBookDao;
import bookShopping.model.Book;
import bookShopping.model.SItem;
import bookShopping.service.IBookService;

/**
 * �鱾ҵ����
 * @author jacky
 *
 */
public class BookService implements IBookService {
	
	IBookDao bookDao;
	
	public IBookDao getBookDao() {
		return bookDao;
	}

	//����ע��bookDao
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book b) throws ShoppingException {
		bookDao.add(b);
	}


	@Override
	public void deleteBook(int id) throws ShoppingException {
		bookDao.delete(id);
	}

	@Override
	public List<Book> getBooks() throws ShoppingException {
		String hql="select b from Book as b";
		List<Book> list=bookDao.list(hql);
		
		return list;
	}

	@Override
	public void updateBook(Book b) throws ShoppingException {
		 bookDao.update(b);
	}

	@Override
	public Book loadBook(long id) throws ShoppingException {
		return bookDao.load(id);
	}

	@Override
	public void deleteBook(Book b) throws ShoppingException {
		  bookDao.deleteObject(b);
	}
	
	/*�������sid��ѯ���ڶ��������ͼ�鼯��*/
	public List<Book> loadsubBooks(long sid)throws ShoppingException{
		String hql="from Book b where b.secondCategory.sid=?";
		List<Book> list=bookDao.list(hql,sid);
		return list;
	}

}
