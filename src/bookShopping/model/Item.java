package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private long cid;/*һ������ID*/
	private String cname;/*һ����������*/
	// һ�������д�Ŷ�������ļ���:
	private Set<SItem> Sitems;
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<SItem> getSitems() {
		return Sitems;
	}
	public void setSitems(Set<SItem> sitems) {
		Sitems = sitems;
	}
	
	
}
