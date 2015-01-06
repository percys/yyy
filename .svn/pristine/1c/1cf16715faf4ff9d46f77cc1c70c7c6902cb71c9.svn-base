package dv.biz.impl;

import java.util.List;

import dv.biz.ExternalBiz;
import dv.sys.dao.ExternalDao;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public class ExternalBizImpl implements ExternalBiz {
	
	private ExternalDao externadao;

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return externadao.getCommodityTotal(toto);
	}

	public List<TtotdzrptShwbjs> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return externadao.doSplitPage(page, rows, toto);
	}
	
	public ExternalDao getExternadao() {
		return externadao;
	}

	public void setExternadao(ExternalDao externadao) {
		this.externadao = externadao;
	}
}
