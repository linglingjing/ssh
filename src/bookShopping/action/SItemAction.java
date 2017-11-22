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
	private int itemCid;//��Ӷ������ഫ������һ������ID
	private String sitemName;//��ӵĶ���������
	private int deleteSId;//ɾ���������ഫ������ID���޸ĵ�ID
	private String ids;//����ɾ����������
	private int CID;//�޸Ĵ�������һ������ID
	private int SID;//�޸Ĵ������Ķ�������ID
	private String SNAME;//�޸Ĵ������Ķ���������
	
	
	
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

	/*��ȡһ�������б�*/
	public String ItemList(){
			try {
				List<Item> ItemList=itemService.getItems();
				putContext("ItemList", ItemList);
			} catch (ShoppingException e) {
				String info="��ȡһ������ʧ�ܣ�"+e.getMessage(); 
		    	 putContext("error",info);
			}
			return "item"; //����һ�����༯��
	}
	/*��ȡ���������б�*/
	public String SItemList(){
		try {
			List<SItem> SItemList=sitemService.getItems();
			putContext("SItemList", SItemList);
		} catch (ShoppingException e) {
			String info="��ȡ��������ʧ�ܣ�"+e.getMessage(); 
	    	 putContext("error",info);
		}
		return LIST;
	}
	
	/*��ȡ�˵���*/
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
	
	/*��Ӷ�������*/
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
			String info="��Ӷ�������ʧ�ܣ�"+e.getMessage(); 
	    	putContext("error",info);
		}
		 
		 return ERROR;
	 }
	 
	 /*ɾ����������*/
	 public String DeleteSItem(){
			try {
				sitemService.deleteSItem(deleteSId);
				return "sitemlist";
			} catch (ShoppingException e) {
				String info="ɾ����������ʧ�ܣ�"+e.getMessage(); 
		    	putContext("error",info);
			}
			return ERROR;
		 }
	 
	 /*����ɾ����������*/
	 public String DeleteSItems(){
		 System.out.println("ids��"+ids);
		
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
			 String info="����ɾ����������ʧ�ܣ�"+e.getMessage(); 
	    	 putContext("error",info);	
			}
		 return ERROR;
	 }
	 
	 /*���ص�ǰ�޸Ķ���*/
	 public String EditSItem(){
		 try {
			 ItemList();
			 SItem sitem=sitemService.loadSItem(deleteSId);
			 System.out.println(sitem.getItem().getCid());
			putContext("sitem", sitem);
		} catch (ShoppingException e) {
			// TODO Auto-generated catch block
			putContext("errorinfo", "��ȡ��������ʧ��"+e.getMessage());
			return ERROR;
		}
		 return EDIT;
	 }
	 
	 /*�޸ĵ�ǰ����*/
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
				String info="�޸Ķ�������ʧ�ܣ�"+e.getMessage(); 
		    	putContext("error",info);
			}
			 return ERROR;
	 	}
	 
}
