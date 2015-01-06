package dv.biz.impl;

import java.util.List;

import dv.biz.InternalYgBiz;
import dv.sys.dao.InternalYgDao;
import dv.sys.entity.TtotdzrptShnbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public class InternalYgBizImpl implements InternalYgBiz {
	
	private InternalYgDao internalygdao;
	
	public Long getCommodityTotal(QueryInternalNbjs toto) {
		return internalygdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptShnbjs> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		return internalygdao.doSplitPage(page, rows, toto);
	}

	public InternalYgDao getInternalygdao() {
		return internalygdao;
	}
	
	public void setInternalygdao(InternalYgDao internalygdao) {
		this.internalygdao = internalygdao;
	}
}
