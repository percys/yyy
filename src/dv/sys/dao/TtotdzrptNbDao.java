package dv.sys.dao;

import java.util.List;

import dv.sys.entity.TtotdzrptNb;
import dv.sys.queryProperties.QueryInternalNbjs;

public interface TtotdzrptNbDao {
	/**
	 * 获得内部加盟门店一定范围内(暂定60 Day)的总记录数
	 * 
	 * @return
	 */
	public Long getCommodityTotal(QueryInternalNbjs toto);

	/**
	 * 查询内部加盟门店一定范围内(暂定60 Day)的数据
	 * 
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param Object筛选
	 * @return 列表
	 */
	public List<TtotdzrptNb> doSplitPage(final int page, final int rows, final QueryInternalNbjs toto);
}
