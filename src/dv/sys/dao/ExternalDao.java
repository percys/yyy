package dv.sys.dao;

import java.util.List;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public interface ExternalDao {
	/**
	 * 获得外部门店总记录数
	 * 
	 * @return
	 */
	public Long getCommodityTotal(QueryInternalNbjs toto);

	/**
	 * 查询所有管理员外部门店数据
	 * 
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param Object筛选
	 * @return 列表
	 */
	public List<TtotdzrptShwbjs> doSplitPage(final int page, final int rows,final QueryInternalNbjs toto);
}
