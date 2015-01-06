package dv.biz.impl;

import java.util.List;

import dv.biz.ExternalYgBiz;
import dv.sys.dao.ExternalYgDao;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public class ExternalYgBizImpl implements ExternalYgBiz {

	private ExternalYgDao externalygdao;
	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return externalygdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptShwbjs> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return externalygdao.doSplitPage(page, rows, toto);
	}

	public ExternalYgDao getExternalygdao() {
		return externalygdao;
	}

	public void setExternalygdao(ExternalYgDao externalygdao) {
		this.externalygdao = externalygdao;
	}

}
