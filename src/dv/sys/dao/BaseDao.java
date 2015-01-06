package dv.sys.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	/**
	 * 带参数查询，排序，分页
	 * @param hql 要查询的hql的语句
	 * @param page 每页容量
	 * @param rows 第几页
	 * @param map 存放要注入的属性的集合
	 * @return 集合列表
	 */
	public List<?> doSplitPage(final String hql,final int page, final int rows,final Map<String, Object> map);
	/**
	 * 获得总记录
	 * @param hql 拼接好的HQL语句
	 * @param map 要注入的属性值
	 * @return 总记录数量
	 */
	public Long getTotal(final String hql,final Map<String, Object> map);
}
