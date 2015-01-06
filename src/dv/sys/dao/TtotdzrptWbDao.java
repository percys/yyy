package dv.sys.dao;

import java.util.List;

import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public interface TtotdzrptWbDao {
	/**
	 * 获得外部加盟门店一定范围内(暂定60 Day)的总记录数
	 * 
	 * @return
	 */
	public Long getCommodityTotal(QueryInternalNbjs toto);

	/**
	 * 查询外部加盟门店一定范围内(暂定60 Day)的数据
	 * 
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param Object筛选
	 * @return 列表
	 */
	public List<TtotdzrptWb> doSplitPage(final int page, final int rows, final QueryInternalNbjs toto);
}
