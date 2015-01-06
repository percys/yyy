package dv.biz.impl;

import java.util.List;

import dv.biz.TtotdzrptWbYgBiz;
import dv.sys.dao.TtotdzrptNbYgDao;
import dv.sys.dao.TtotdzrptWbYgDao;
import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptWbYgBizImpl implements TtotdzrptWbYgBiz {

	private TtotdzrptWbYgDao totdzrptWbYgdao;
	
	public TtotdzrptWbYgDao getTotdzrptWbYgdao() {
		return totdzrptWbYgdao;
	}

	public void setTotdzrptWbYgdao(TtotdzrptWbYgDao totdzrptWbYgdao) {
		this.totdzrptWbYgdao = totdzrptWbYgdao;
	}

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptWbYgdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptWb> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptWbYgdao.doSplitPage(page, rows, toto);
	}

}
