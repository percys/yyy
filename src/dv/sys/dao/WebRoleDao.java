package dv.sys.dao;

import java.util.List;

import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebRole;

public interface WebRoleDao {
	/**
	 * 获得所有角色
	 * @return
	 */
	public List<WebRole> getAllRole(WebUser webUser);
	/**
	 * 修改角色
	 * @param role
	 */
	public void updateRole(WebRole role);
	
	/**
	 * 查找角色
	 * @param roleid
	 * @return 角色
	 */
	public WebRole getRole(String roleid);
	
	/**
	 * 删除角色
	 * @param role
	 */
	public void delRole(String ids);
	
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(WebRole role);
	
	/**
	 * 角色的总数
	 * @param queryWebRole 角色对象
	 * @return 总数
	 */
	public Long getRoleTotal(final QueryWebRole queryWebRole);
	
	/**
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param sort排序字段
	 * @param order排序方式
	 * @return 角色列表
	 */
	public List<WebRole> doSplitPage(final int page,final int rows,final String sort,final String order,final QueryWebRole queryWebRole);
	
	/**
	 * 按name查找角色
	 * @param name
	 * @return 角色
	 */
	public WebResource getByName(String name);
	
	/**
	 * 根据角色Id查找角色的权限
	 * @return 权限集合
	 */
	public List<WebResource> getResourceById(String id);
}
