package bookShopping.test;





import javax.annotation.Resource;

import org.junit.Test;

import bookShopping.model.Book;
import bookShopping.service.IBookService;





public class TestDao  extends BaseDAOTestCaseJunit44 {
	
	
	@Resource
	private IBookService bookService;
	
	
	
	
	
	public IBookService getBookService() {
		return bookService;
	}


	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Test
	public void testJson()
	{
		try
		{
			//long id=1;
			//Book b=bookService.loadBook(id);
			//System.out.println(b.getBookName());
			//bookService.deleteBook(b);
			//bookService.deleteBook(2);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	
	
	
	
}
