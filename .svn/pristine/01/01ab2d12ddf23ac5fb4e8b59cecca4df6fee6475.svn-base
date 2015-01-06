package dv.biz.impl;

import java.util.List;

import dv.biz.internalBiz;
import dv.sys.dao.internalDao;
import dv.sys.entity.TtotdzrptShnbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public class internalBizImpl implements internalBiz {

	private internalDao internaldao;
	
	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return internaldao.getCommodityTotal(toto);
	}

	public List<TtotdzrptShnbjs> doSplitPage(int page, int rows,final QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return internaldao.doSplitPage(page, rows, toto);
	}

	
	public internalDao getInternaldao() {
		return internaldao;
	}

	public void setInternaldao(internalDao internaldao) {
		this.internaldao = internaldao;
	}

}
