package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

public class WebUnit implements java.io.Serializable {

	private static final long serialVersionUID = 1234667943820029351L;

	private String unitid;
	private WebUnit webUnit;
	private String name;
	private String areano;
	private String bz;
	private Set<WebUser> webUsers = new HashSet<WebUser>(0);
	private Set<WebUnit> webUnits = new HashSet<WebUnit>(0);

	public WebUnit() {
	}

	public WebUnit(String unitid) {
		this.unitid = unitid;
	}

	public WebUnit(String unitid, WebUnit webUnit, String name, String areano,
			String bz, Set<WebUser> webUsers, Set<WebUnit> webUnits) {
		this.unitid = unitid;
		this.webUnit = webUnit;
		this.name = name;
		this.areano = areano;
		this.bz = bz;
		this.webUsers = webUsers;
		this.webUnits = webUnits;
	}

	public String getUnitid() {
		return this.unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public WebUnit getWebUnit() {
		return this.webUnit;
	}

	public void setWebUnit(WebUnit webUnit) {
		this.webUnit = webUnit;
	}

	public String getWebUnitString(){
		if(this.webUnit!=null) return this.webUnit.getName();
		else return "";
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreano() {
		return this.areano;
	}

	public void setAreano(String areano) {
		this.areano = areano;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Set<WebUser> getWebUsers() {
		return this.webUsers;
	}

	public void setWebUsers(Set<WebUser> webUsers) {
		this.webUsers = webUsers;
	}

	public Set<WebUnit> getWebUnits() {
		return this.webUnits;
	}

	public void setWebUnits(Set<WebUnit> webUnits) {
		this.webUnits = webUnits;
	}
}