package dv.biz.impl;

import java.util.List;

import dv.biz.TtotdzrptNbYgBiz;
import dv.sys.dao.TtotdzrptNbYgDao;
import dv.sys.entity.TtotdzrptNb;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptNbYgBizImpl implements TtotdzrptNbYgBiz {

	private TtotdzrptNbYgDao totdzrptNbYgdao;
	
	public TtotdzrptNbYgDao getTotdzrptNbYgdao() {
		return totdzrptNbYgdao;
	}

	public void setTotdzrptNbYgdao(TtotdzrptNbYgDao totdzrptNbYgdao) {
		this.totdzrptNbYgdao = totdzrptNbYgdao;
	}

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptNbYgdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptNb> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptNbYgdao.doSplitPage(page, rows, toto);
	}

}
