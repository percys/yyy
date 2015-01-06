package dv.sys.dao;

import java.util.List;
import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public interface TtotdzrptWbYgDao {
	/**
	 * 获得当前登录的外部加盟门店员工一定范围内(暂定30 Day)的总记录数
	 * 
	 * @return
	 */
	public Long getCommodityTotal(QueryInternalNbjs toto);

	/**
	 * 查询当前登录的外部加盟门店员工所属门店一定范围内(暂定30 Day)的数据
	 * 
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param Object筛选
	 * @return 列表
	 */
	public List<TtotdzrptWb> doSplitPage(final int page, final int rows, final QueryInternalNbjs toto);
}
