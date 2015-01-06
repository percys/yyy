package dv.sys.action;

import dv.biz.PerinfoBiz;
import dv.sys.entity.PersonInfo;

public class ResInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1843809437526122249L;
	
	private PersonInfo perinfo;
	private PerinfoBiz pb;

	public String addPerinfo(){
		pb.addPerinfo(perinfo);
		return NONE;
	}
	
	public PerinfoBiz getPb() {
		return pb;
	}

	public void setPb(PerinfoBiz pb) {
		this.pb = pb;
	}

	public PersonInfo getPerinfo() {
		return perinfo;
	}

	public void setPerinfo(PersonInfo perinfo) {
		this.perinfo = perinfo;
	}
}
