package dv.biz.impl;

import dv.biz.PerinfoBiz;
import dv.sys.dao.PerinfoDao;
import dv.sys.entity.PersonInfo;

public class PerinfoBizImpl implements PerinfoBiz {
	
	private PerinfoDao pd;
	
	public PerinfoDao getPd() {
		return pd;
	}

	public void setPd(PerinfoDao pd) {
		this.pd = pd;
	}

	public void addPerinfo(PersonInfo perinfo) {
		// TODO Auto-generated method stub
		pd.addPerinfo(perinfo);
	}

}
