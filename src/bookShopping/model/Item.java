package bookShopping.model;

import java.util.HashSet;
import java.util.Set;

public class Item {
	private long cid;/*一级分类ID*/
	private String cname;/*一级分类名称*/
	// 一级分类中存放二级分类的集合:
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
