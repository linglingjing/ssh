package bookShopping.service.imp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookShopping.Exception.ShoppingException;
import bookShopping.dao.ICommentDao;
import bookShopping.model.Book;
import bookShopping.model.Cart;
import bookShopping.model.Comment;
import bookShopping.model.Order;
import bookShopping.service.ICommentService;


public class CommentService implements ICommentService{
	
	private ICommentDao commentDao;
	private Comment comment;
	public ICommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	/*根据对象添加*/
	@Override
	public void addComment(Comment c) throws ShoppingException {
		commentDao.add(c);
	}
	
	/*根据bid和用户ID查询评论*/
	@Override
	public List<Comment> loadComment(long bid,long sid)throws ShoppingException{
		Object[] args={bid,sid};
		String hql="from Comment c where c.book.bid=? and c.user.id=?";
		List<Comment> list=commentDao.list(hql, args);
		return list;
	}
}
