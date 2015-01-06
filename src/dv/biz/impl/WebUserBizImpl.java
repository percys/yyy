package dv.biz.impl;

import java.util.List;

import dv.biz.WebUserBiz;
import dv.sys.dao.WebUserDao;
import dv.sys.entity.Torgmanage;
import dv.sys.entity.Tusruser;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebUser;

public class WebUserBizImpl implements WebUserBiz {
	private WebUserDao webUserDao;
	public WebUser getWebUser(String username) {
		return webUserDao.getWebUser(username);
	}
	public WebUserDao getWebUserDao() {
		return webUserDao;
	}
	public void setWebUserDao(WebUserDao webUserDao) {
		this.webUserDao = webUserDao;
	}
	public WebUser saveWebUser(WebUser webUser) {
		return webUserDao.saveWebUser(webUser);
	}
	public List<WebResource> getUserResource(WebUser webUser,String id,boolean bool) {
		return webUserDao.getUserResource(webUser,id,bool);
	}
	public List<WebRole> getUserRole(WebUser webUser) {
		return webUserDao.getUserRole(webUser);
	}
	public List<WebUser> doSplitPage(int page, int rows, String sort,
			String order, QueryWebUser queryWebUser) {
		return webUserDao.doSplitPage(page, rows, sort, order, queryWebUser);
	}
	public Long getUserTotal(QueryWebUser queryWebUser) {
		return webUserDao.getUserTotal(queryWebUser);
	}
	public void delUser(WebUser webUser) {
		webUserDao.delUser(webUser);
	}
	public List<Torgmanage> getOrgCode(WebUser webUser) {
		return webUserDao.getOrgCode(webUser);
	}
	public Torgmanage getCode(Torgmanage tor) {
		return webUserDao.getCode(tor);
	}
	public List<Tusruser> getCheckGh(WebUser user) {
		return webUserDao.getCheckGh(user);
	}
	public WebUser getWebUserid(String id) {
		// TODO Auto-generated method stub
		return webUserDao.getWebUserid(id);
	}
	public WebUser getUserAgentId(WebUser user) {
		// TODO Auto-generated method stub
		return webUserDao.getUserAgentId(user);
	}
	
}
