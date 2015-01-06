package dv.biz.impl;

import java.util.List;

import dv.biz.TtotdzrptYgBiz;
import dv.sys.dao.TtotdzrptYgDao;
import dv.sys.entity.Ttotdzrpt;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptYgBizImpl implements TtotdzrptYgBiz {
	
	private TtotdzrptYgDao ttotdzrptygdao;
	
	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return ttotdzrptygdao.getCommodityTotal(toto);
	}

	public List<Ttotdzrpt> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return ttotdzrptygdao.doSplitPage(page, rows, toto);
	}

	public TtotdzrptYgDao getTtotdzrptygdao() {
		return ttotdzrptygdao;
	}

	public void setTtotdzrptygdao(TtotdzrptYgDao ttotdzrptygdao) {
		this.ttotdzrptygdao = ttotdzrptygdao;
	}

}
