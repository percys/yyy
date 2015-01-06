package dv.sys.dao;

import java.util.List;

import dv.sys.entity.WebUnit;
import dv.sys.queryProperties.QueryWebUnit;

public interface WebUnitDao {
	
	/**
	 * 修改部门
	 * @param unit
	 */
	public WebUnit updateUnit(WebUnit unit);
	
	/**
	 * 获取所有部门信息
	 * @param id 部门编号
	 * @return	部门列表
	 */
	public List<WebUnit> getAllUnit(String id);
	
	/**
	 * 查找角色
	 * @param roleid
	 * @return 角色
	 */
	public WebUnit getUnit(String unitid);
	
	/**
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param sort排序字段
	 * @param order排序方式
	 * @return 部门列表
	 */
	public List<WebUnit> doSplitPage(final int page,final int rows,final String sort,final String order,final QueryWebUnit queryWebUnit);

	/**
	 * 获得部门的总数量
	 * @param queryWebUnit	部门对象
	 * @return	部门数量
	 */
	public Long getUnitsTotal(final QueryWebUnit queryWebUnit);
	
	/**
	 * 删除部门信息
	 * @param ids  编号
	 */
	public void delUnit(String ids);
	/**
	 * 添加部门信息
	 * @param webUnit	部门对象
	 */
	public WebUnit addUnit(WebUnit webUnit);
}
