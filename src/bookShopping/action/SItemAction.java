package bookShopping.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Admin;
import bookShopping.model.Item;
import bookShopping.model.SItem;
import bookShopping.service.IItemService;
import bookShopping.service.ISItemService;



public class SItemAction extends BaseAction{
	ISItemService sitemService;
	IItemService itemService;
	private int itemCid;//添加二级分类传过来的一级分类ID
	private String sitemName;//添加的二级分类名
	private int deleteSId;//删除二级分类传过来的ID和修改的ID
	private String ids;//批量删除二级分类
	private int CID;//修改传过来的一级分类ID
	private int SID;//修改传过来的二级分类ID
	private String SNAME;//修改传过来的二级分类名
	
	
	
	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getDeleteSId() {
		return deleteSId;
	}

	public void setDeleteSId(int deleteSId) {
		this.deleteSId = deleteSId;
	}

	public String getSitemName() {
		return sitemName;
	}

	public void setSitemName(String sitemName) {
		this.sitemName = sitemName;
	}

	public int getItemCid() {
		return itemCid;
	}

	public void setItemCid(int itemCid) {
		this.itemCid = itemCid;
	}

	public ISItemService getSitemService() {
		return sitemService;
	}

	public void setSitemService(ISItemService sitemService) {
		this.sitemService = sitemService;
	}
	
	public IItemService getItemService() {
		return itemService;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	/*获取一级分类列表*/
	public String ItemList(){
			try {
				List<Item> ItemList=itemService.getItems();
				putContext("ItemList", ItemList);
			} catch (ShoppingException e) {
				String info="获取一级分类失败！"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return "item"; //返回一级分类集合
	}
	/*获取二级分类列表*/
	public String SItemList(){
		try {
			List<SItem> SItemList=sitemService.getItems();
			putContext("SItemList", SItemList);
		} catch (ShoppingException e) {
			String info="获取二级分类失败！"+e.getMessage(); 
	    	 putContext("error",info);
		}
		return LIST;
	}
	
	/*获取菜单栏*/
	public String Menu(){
		try {
			 HttpServletRequest request = ServletActionContext.getRequest();
			List<Item> menus=itemService.getItems();
			 request.setAttribute("menus", menus);
			 return "menu";
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/*添加二级分类*/
	 public String addSItem(){
		 Item i=new Item();
		 i.setCid(itemCid);
		 SItem si=new SItem();
		 si.setSname(sitemName);
		 si.setItem(i);
		 try {
			sitemService.addSItem(si);
			return "sitemlist";
		} catch (ShoppingException e) {
			String info="添加二级分类失败！"+e.getMessage(); 
	    	putContext("error",info);
		}
		 
		 return ERROR;
	 }
	 
	 /*删除二级分类*/
	 public String DeleteSItem(){
			try {
				sitemService.deleteSItem(deleteSId);
				return "sitemlist";
			} catch (ShoppingException e) {
				String info="删除二级分类失败！"+e.getMessage(); 
		    	putContext("error",info);
			}
			return ERROR;
		 }
	 
	 /*批量删除二级分类*/
	 public String DeleteSItems(){
		 System.out.println("ids是"+ids);
		
		String[] chkValues = ids.split(",");
		 int[] idslist = new int[chkValues.length];
		
		 for(int i=0;i<chkValues.length;i++){
			 idslist[i]=Integer.parseInt(chkValues[i]);
			 }
		 try {
			 for(int i=0;i<idslist.length;i++){
				 System.out.println(idslist);
				sitemService.deleteSItem(idslist[i]);
		 	}
			 return "sitemlist";
		 } catch (ShoppingException e) {
			 String info="批量删除二级分类失败！"+e.getMessage(); 
	    	 putContext("error",info);	
			}
		 return ERROR;
	 }
	 
	 /*加载当前修改对象*/
	 public String EditSItem(){
		 try {
			 ItemList();
			 SItem sitem=sitemService.loadSItem(deleteSId);
			 System.out.println(sitem.getItem().getCid());
			putContext("sitem", sitem);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "获取二级分类失败"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 
	 /*修改当前对象*/
	 public String UpdateSItem() throws ShoppingException{
		 Item i=new Item();
		 i.setCid(CID);
		 SItem si=new SItem();
		 si.setSname(SNAME);
		 si.setSid(SID);
		 si.setItem(i);
		System.out.println(CID+" "+SNAME+" "+"SID ");
		 try {
				sitemService.updateSItem(si);;
				return "sitemlist";
			} catch (ShoppingException e) {
				String info="修改二级分类失败！"+e.getMessage(); 
		    	putContext("error",info);
			}
			 return ERROR;
	 	}
	 
}
