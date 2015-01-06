package dv.sys.queryProperties;

import java.io.Serializable;

public class QueryWebUnit implements Serializable {
	private static final long serialVersionUID = -1727678346839880462L;
	private String unitid;
	private String name;
	private String areano;
	private String fatherName;
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreano() {
		return areano;
	}
	public void setAreano(String areano) {
		this.areano = areano;
	}
}
