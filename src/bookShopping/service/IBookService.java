package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;

public interface IBookService {
    public void addBook(Book b) throws ShoppingException ;
    public void deleteBook(int id) throws ShoppingException ;
    public void deleteBook(Book b) throws ShoppingException ;
    public List<Book> getBooks() throws ShoppingException ;
    public void updateBook(Book b)throws ShoppingException ;
    
    public Book loadBook(long id) throws ShoppingException ;
    public List<Book> loadsubBooks(long sid)throws ShoppingException;
    
    
}
