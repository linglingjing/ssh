package bookShopping.action;

import bookShopping.model.Admin;
import bookShopping.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	
	protected static final String SUCCESS="success";
	protected static final String ERROR="error";
	protected static final String ERROR2="error2";
	protected static final String LIST="list";
	protected static final String RELOAD="reload";
	protected static final String UPDATE="update";
	protected static final String ADD="add";
	protected static final String LOGIN="login";
	protected static final String LOGOUT="logout";
	protected static final String EDIT="edit";
	
	//��ʾǰ̨��������ҳ�룬�ڼ�ҳ
   protected  int pageIndex;
  
  
   //��ֵ�ŵ�page������
   protected void putContext(String key,Object value)
   {
	   ActionContext.getContext().put(key, value);
   }
  
//   ��ֵ�ŵ�Session��
   protected void putSession(String key, Object value) {
	   ActionContext.getContext().getSession().put(key, value);
		
	}
// ��Session��ȡֵ
 protected Object getSession(Object obj) {
	  return  ActionContext.getContext().getSession().get(obj);
		
	}
}
