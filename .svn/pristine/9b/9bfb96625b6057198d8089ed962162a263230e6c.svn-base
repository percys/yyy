package dv.biz.impl;

import java.util.List;

import dv.biz.TtotdzrptNbBiz;
import dv.sys.dao.TtotdzrptNbDao;
import dv.sys.entity.TtotdzrptNb;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptNbBizImpl implements TtotdzrptNbBiz {

	private TtotdzrptNbDao totdzrptNbdao;
	public TtotdzrptNbDao getTotdzrptNbdao() {
		return totdzrptNbdao;
	}

	public void setTotdzrptNbdao(TtotdzrptNbDao totdzrptNbdao) {
		this.totdzrptNbdao = totdzrptNbdao;
	}

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptNbdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptNb> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptNbdao.doSplitPage(page, rows, toto);
	}

}
