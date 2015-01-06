package dv.sys.dao;

import java.util.List;

import dv.sys.entity.WebDictionary;

public interface WebDictionaryDao {
	
	/**
	 * 获取所有字典信息
	 * @return	字典列表
	 */
	public List<WebDictionary> getAllDictionary();
	
	/**
	 * 实现分页
	 * @param page	当前页
	 * @param rows	每页显示大小
	 * @param sort	排序字段
	 * @param order	排序方式
	 * @param webDictionary	字典对象
	 * @return	字典集合
	 */
	public List<WebDictionary> doSplitPage(final int page,final int rows,final String sort,final String order,final WebDictionary webDictionary);

	/**
	 * 获得字典的总数量
	 * @param webDictionary	字典对象
	 * @return	字典总数量
	 */
	public Long getWebDictionaryTotal(final WebDictionary webDictionary);
}
