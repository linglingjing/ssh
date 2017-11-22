package bookShopping.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.text.resources.FormatData;

import com.opensymphony.xwork2.ActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.service.IAdminService;

public class AdminAction extends BaseAction {
	
	IAdminService adminService;
	private String f_adminName;
	private String f_password;
	private String a_adminName;//添加管理员
	private String a_password;//添加管理员
	private String a_adminType;//添加管理员
	private String ids=null;//删除管理员
	private int   adminId;//删除管理员
	private int   m_adminID;//修改管理员
	private String m_adminName;//修改管理员
	private String m_password;//修改管理员
	private String m_adminType;//修改管理员
	private String m_register_time;//修改管理员
	
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public IAdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	public String getF_adminName() {
		return f_adminName;
	}
	public void setF_adminName(String f_adminName) {
		this.f_adminName = f_adminName;
	}
	public String getF_password() {
		return f_password;
	}
	public void setF_password(String f_password) {
		this.f_password = f_password;
	}
	
	public String getA_adminName() {
		return a_adminName;
	}
	public void setA_adminName(String a_adminName) {
		this.a_adminName = a_adminName;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_adminType() {
		return a_adminType;
	}
	public void setA_adminType(String a_adminType) {
		this.a_adminType = a_adminType;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public int getM_adminID() {
		return m_adminID;
	}
	public void setM_adminID(int m_adminID) {
		this.m_adminID = m_adminID;
	}
	public String getM_adminName() {
		return m_adminName;
	}
	public void setM_adminName(String m_adminName) {
		this.m_adminName = m_adminName;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_adminType() {
		return m_adminType;
	}
	public void setM_adminType(String m_adminType) {
		this.m_adminType = m_adminType;
	}
	public String getM_register_time() {
		return m_register_time;
	}
	public void setM_register_time(String m_register_time) {
		this.m_register_time = m_register_time;
	}
	/*登录功能*/
	 public String login(){
		 try {
			Admin admin=adminService.login(f_adminName, f_password); 
				 if(admin!=null){
					 putSession("admin",admin);
					 return SUCCESS;
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
	
	 /*退出功能*/
	 public String logout(){
		 ActionContext act = ActionContext.getContext();
		 Map session = act.getSession();
		 if(session!=null){
			 session.clear();
		 }
		 return LOGOUT;
	 }
	 
	 /*读取超级管理员列表*/
	 public String AdminList(){
		try {
			List<Admin> AdminList=adminService.getAdmins();
			putContext("AdminList", AdminList);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LIST; 
	 }
	
	/*添加管理员*/
	 public String AddAdmin(){
		 Admin admin=new Admin();
		 admin.setAdminName(a_adminName);
		 admin.setPassword(a_password);
		 admin.setLimits(Integer.parseInt(a_adminType));
		 admin.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		 try {
		 adminService.addAdmin(admin);
		 return "adminlist";
			} catch (ShoppingException ex) {
				// TODO Auto-generated catch block
				 String info="添加管理员失败！"+ex.getMessage(); 
		    	 putContext("error",info);
			}
			return ERROR;
	 }
	 
	 /*批量删除管理员*/
	 public String DeleteSuperAdmins(){
		 System.out.println("ids是"+ids);
		
		String[] chkValues = ids.split(",");
		 int[] idslist = new int[chkValues.length];
		
		 for(int i=0;i<chkValues.length;i++){
			 idslist[i]=Integer.parseInt(chkValues[i]);
			 }
		 try {
			 for(int i=0;i<idslist.length;i++){
				 System.out.println(idslist);
				adminService.deleteAdmin(idslist[i]);
		 	}
			 return "adminlist";
		 } catch (ShoppingException e) {
				e.printStackTrace();	
			}
		 return ERROR;
	 }
	 /*删除一条管理员记录*/
	 public String DeleteSuperAdmin(){
		try {
			adminService.deleteAdmin(adminId);
			return "adminlist";
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	 }
	 /*加载要修改管理员的当前对象*/
	 public String UpdateEdit(){
		 try {
			Admin admin=adminService.loadAdmin(adminId);
			putContext("a", admin);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "获取管理员失败"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 /*修改管理员信息*/
	 public String UpdateAdmin() throws ShoppingException{
		Admin a=new Admin();
		System.out.println(m_adminID+" "+m_adminName+" "+m_password+" "+m_adminType);
		a.setId(m_adminID);
		a.setAdminName(m_adminName);
		a.setPassword(m_password);
		a.setLimits(Integer.parseInt(m_adminType));
		a.setRegisterDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		adminService.updateAdmin(a);
		
		return "adminlist";
	 }
}
