package dv.biz.impl;

import java.util.List;

import dv.biz.TtotdzrptBiz;
import dv.sys.dao.TtotdzrptDao;
import dv.sys.entity.Ttotdzrpt;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptBizImpl implements TtotdzrptBiz {
	
	private TtotdzrptDao totdzrptDao;

	



	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptDao.getCommodityTotal(toto);
	}

	public List<Ttotdzrpt> doSplitPage(int page, int rows, final QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptDao.doSplitPage(page, rows, toto);
	}
	
	
	
	
	

	public TtotdzrptDao getTotdzrptDao() {
		return totdzrptDao;
	}

	public void setTotdzrptDao(TtotdzrptDao totdzrptDao) {
		this.totdzrptDao = totdzrptDao;
	}
}
