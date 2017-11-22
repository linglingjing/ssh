package bookShopping.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Item;
import bookShopping.service.IItemService;


public class ItemAction extends BaseAction{
	IItemService itemService;
	private String itemname;//添加一级分类名
	private int itemId;//删除一级分类
	private int itemID;//修改一级分类
	private String itemName;//修改一级分类
	private String ids;//批量删除一级分类
	
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public IItemService getItemService() {
		return itemService;
	}

	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

	/*添加一级分类*/
	public String addItem(){
		Item item=new Item();
		item.setCname(itemname);
		try {
			itemService.addItem(item);
			return "itemlist";
		} catch (ShoppingException e) {
			String info="添加一级失败！"+e.getMessage(); 
	    	 putContext("error",info);
		}
		return ERROR;
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
			return LIST; 
		 }
	 
	 /*删除一条一级分类*/
	 public String DeleteItem(){
		 try {	System.out.println("<script></script>");
				itemService.deleteItem(itemId);;
				return "itemlist";
			} catch (ShoppingException e) {
				String info="删除一级分类失败！"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return ERROR; 
	 }
	 /*批量删除一级分类*/
	 public String DeleteItems(){
		 System.out.println("ids是"+ids);
		
		String[] chkValues = ids.split(",");
		 int[] idslist = new int[chkValues.length];
		
		 for(int i=0;i<chkValues.length;i++){
			 idslist[i]=Integer.parseInt(chkValues[i]);
			 }
		 try {
			 for(int i=0;i<idslist.length;i++){
				itemService.deleteItem(idslist[i]);;
		 	}
			 return "itemlist";
		 } catch (ShoppingException e) {
			 String info="批量删除一级分类失败！"+e.getMessage(); 
	    	 putContext("error",info);	
			}
		 return ERROR;
	 }
	 
	 
	 /*加载要修改一级的当前对象*/
	 public String ItemEdit(){
		 try {
			Item item=itemService.loadItem(itemId);;
			putContext("i", item);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "获取管理员失败"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 
	 /*修改一级分类*/
	 public String updateItem() throws ShoppingException{
		Item i=new Item();
		System.out.println(itemID+" "+itemName+" "+"WWWWWWWWWW");
		i.setCid(itemID);
		i.setCname(itemName);
		
		itemService.updateItem(i);
		return "itemlist";
	 }
}
