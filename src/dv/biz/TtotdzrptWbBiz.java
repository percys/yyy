package dv.biz;

import java.util.List;

import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public interface TtotdzrptWbBiz {
	/**
	 * 获得外部加盟门店总记录数
	 * 
	 * @return
	 */
	public Long getCommodityTotal(final QueryInternalNbjs toto);

	/**
	 * 查询所有外部加盟门店数据
	 * 
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param Object筛选
	 * @return 列表
	 */
	public List<TtotdzrptWb> doSplitPage(final int page, final int rows, final QueryInternalNbjs toto);
}
