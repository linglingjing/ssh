package bookShopping.action;

import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Book;
import bookShopping.model.Cart;
import bookShopping.model.Comment;
import bookShopping.model.User;
import bookShopping.service.ICommentService;

public class CommentAction extends BaseAction {
	
	ICommentService commentService;
	private int bid;
	private String content;
	
	
	
	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/*发表评论*/
	public String addComment(){
		Book b=new Book();
		b.setBid(bid);
		
		User user=(User)getSession("user");//获得当前用户对象
		User u=new User();
		u.setId(user.getId());
		
		Comment c=new Comment();
		c.setContent(content);
		c.setBook(b);
		c.setUser(u);
		
		try {
			commentService.addComment(c);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR2;
		}
		return SUCCESS;
	}
	
	/*显示评论*/
	public String loadComment(){
		User user=(User)getSession("user");//获得当前用户对象
		try {
			List<Comment> comments=commentService.loadComment(bid, user.getId());
			putContext("comments", comments);
		} catch (ShoppingException e) {
			e.printStackTrace();
			return ERROR2;
		}
		return LIST;
	}
	
}
