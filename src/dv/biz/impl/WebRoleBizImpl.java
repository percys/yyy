package dv.biz.impl;

import java.util.List;

import dv.biz.WebRoleBiz;
import dv.sys.dao.WebRoleDao;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebRole;

public class WebRoleBizImpl implements WebRoleBiz {
	private WebRoleDao webRoleDao;
	public void addRole(WebRole role) {
		webRoleDao.addRole(role);
	}

	public void delRole(String ids) {
		webRoleDao.delRole(ids);
	}

	public WebRole getRole(String roleid) {
		return webRoleDao.getRole(roleid);
	}

	public void updateRole(WebRole role) {
		webRoleDao.updateRole(role);
	}

	public WebRoleDao getWebRoleDao() {
		return webRoleDao;
	}

	public void setWebRoleDao(WebRoleDao webRoleDao) {
		this.webRoleDao = webRoleDao;
	}

	public Long getRoleTotal(QueryWebRole queryWebRole) {
		return webRoleDao.getRoleTotal(queryWebRole);
	}

	public List<WebRole> doSplitPage(int page, int rows, String sort,
			String order, QueryWebRole queryWebRole) {
		return webRoleDao.doSplitPage(page, rows, sort, order, queryWebRole);
	}

	public WebResource getByName(String name){
		return webRoleDao.getByName(name);
	}

	public List<WebResource> getResourceById(String id) {
		return webRoleDao.getResourceById(id);
	}
	
	// 获得所有角色信息
	public List<WebRole> getAllRole(WebUser webUser) {
		return webRoleDao.getAllRole(webUser);
	}
}
