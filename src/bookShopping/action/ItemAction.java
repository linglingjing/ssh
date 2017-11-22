package bookShopping.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bookShopping.Exception.ShoppingException;
import bookShopping.model.Item;
import bookShopping.service.IItemService;


public class ItemAction extends BaseAction{
	IItemService itemService;
	private String itemname;//���һ��������
	private int itemId;//ɾ��һ������
	private int itemID;//�޸�һ������
	private String itemName;//�޸�һ������
	private String ids;//����ɾ��һ������
	
	
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
	

	/*���һ������*/
	public String addItem(){
		Item item=new Item();
		item.setCname(itemname);
		try {
			itemService.addItem(item);
			return "itemlist";
		} catch (ShoppingException e) {
			String info="���һ��ʧ�ܣ�"+e.getMessage(); 
	    	 putContext("error",info);
		}
		return ERROR;
	}
	/*��ȡһ�������б�*/
	 public String ItemList(){
			try {
				List<Item> ItemList=itemService.getItems();
				putContext("ItemList", ItemList);
			} catch (ShoppingException e) {
				String info="��ȡһ������ʧ�ܣ�"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return LIST; 
		 }
	 
	 /*ɾ��һ��һ������*/
	 public String DeleteItem(){
		 try {	System.out.println("<script></script>");
				itemService.deleteItem(itemId);;
				return "itemlist";
			} catch (ShoppingException e) {
				String info="ɾ��һ������ʧ�ܣ�"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return ERROR; 
	 }
	 /*����ɾ��һ������*/
	 public String DeleteItems(){
		 System.out.println("ids��"+ids);
		
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
			 String info="����ɾ��һ������ʧ�ܣ�"+e.getMessage(); 
	    	 putContext("error",info);	
			}
		 return ERROR;
	 }
	 
	 
	 /*����Ҫ�޸�һ���ĵ�ǰ����*/
	 public String ItemEdit(){
		 try {
			Item item=itemService.loadItem(itemId);;
			putContext("i", item);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "��ȡ����Աʧ��"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 
	 /*�޸�һ������*/
	 public String updateItem() throws ShoppingException{
		Item i=new Item();
		System.out.println(itemID+" "+itemName+" "+"WWWWWWWWWW");
		i.setCid(itemID);
		i.setCname(itemName);
		
		itemService.updateItem(i);
		return "itemlist";
	 }
}
