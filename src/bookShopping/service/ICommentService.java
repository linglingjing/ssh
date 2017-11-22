package bookShopping.service;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Comment;

public interface ICommentService {

	void addComment(Comment c) throws ShoppingException;
   //声明写了的方法 
	List<Comment> loadComment(long bid,long sid)throws ShoppingException;


	
}
