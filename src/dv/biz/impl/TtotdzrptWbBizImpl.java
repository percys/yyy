package dv.biz.impl;

import java.util.List;
import dv.biz.TtotdzrptWbBiz;
import dv.sys.dao.TtotdzrptWbDao;
import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptWbBizImpl implements TtotdzrptWbBiz {

	private TtotdzrptWbDao totdzrptWbdao;
	
	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptWbdao.getCommodityTotal(toto);
	}

	public List<TtotdzrptWb> doSplitPage(int page, int rows,
			QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		return totdzrptWbdao.doSplitPage(page, rows, toto);
	}

	public TtotdzrptWbDao getTotdzrptWbdao() {
		return totdzrptWbdao;
	}

	public void setTotdzrptWbdao(TtotdzrptWbDao totdzrptWbdao) {
		this.totdzrptWbdao = totdzrptWbdao;
	}

}
