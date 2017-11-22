package bookShopping.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.User;
import bookShopping.service.IUserService;

public class UserAction extends BaseAction{
	IUserService userService;
	private String username;//注册表单
	private String telephone;//注册表单
	private String password;//注册表单
	
	private String f_userName;//从登录表单获取
	private String f_password;//从登录表单获取
	
	private int userId;//删除一条用户记录的ID
	private String ids;//批量删除管理员

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	public String getF_userName() {
		return f_userName;
	}

	public void setF_userName(String f_userName) {
		this.f_userName = f_userName;
	}

	public String getF_password() {
		return f_password;
	}

	public void setF_password(String f_password) {
		this.f_password = f_password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/*用户注册*/
	public String register(){
		User user=new User();
		user.setUsername(username);
		user.setTelephone(telephone);
		user.setPassword(password);
		try {
			userService.addUser(user);
		} catch (ShoppingException e) {
			putContext("errorInfo", "注册失败！"+e.getMessage());
			return ERROR2;
		}
		return "login";
	}
	
	/*用户登录*/
	public String login(){
		 try {
			User user=userService.login(f_userName, f_password); 
				 if(user!=null){
					 putSession("user",user);
					 return "login";
				 }else{
					 this.addActionError("用户名密码错误，请重新输入！");
					return RELOAD;
				 }
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return RELOAD;
	 }
	
	/*用户退出登录*/
	public String logout(){
		 ActionContext act = ActionContext.getContext();
		 Map session = act.getSession();
		 if(session!=null){
			 session.clear();
		 }
		 return "login";
	}
	
	
	/*获取用户列表*/
	public String UserList(){
		try {
			List<User> UserList=userService.getUsers();
			putContext("UserList", UserList);
		} catch (ShoppingException e) {
			putContext("erroeInfo", "获取用户列表失败！"+e.getMessage());
			return ERROR2;
		}
		return LIST; 
	}
	
	/*删除一条记录*/
	 public String DeleteUser(){
		try {
			userService.deleteUser(userId);
			return "userlist";
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR2;
	 }
	 /*批量删除用户*/
	 public String DeleteUsers(){
		 System.out.println("ids是"+ids);
		
		String[] chkValues = ids.split(",");
		 int[] idslist = new int[chkValues.length];
		
		 for(int i=0;i<chkValues.length;i++){
			 idslist[i]=Integer.parseInt(chkValues[i]);
			 }
		 try {
			 for(int i=0;i<idslist.length;i++){
				 System.out.println(idslist);
				userService.deleteUser(idslist[i]);;
		 	}
			 return "userlist";
		 } catch (ShoppingException e) {
				e.printStackTrace();	
			}
		 return ERROR2;
	 }
	 
}
