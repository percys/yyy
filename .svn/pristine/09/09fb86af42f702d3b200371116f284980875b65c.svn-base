package dv.biz.impl;

import java.util.List;

import dv.biz.WebResourceBiz;
import dv.sys.dao.WebResourceDao;
import dv.sys.entity.WebResource;

public class WebResourceBizImpl implements WebResourceBiz {
	private WebResourceDao webResourceDao;
	/**
	 * 获得所有资源
	 * @return
	 */
	public List<WebResource> getAllResource() {
		return webResourceDao.getAllResource();
	}
	/**
	 * 根据id获得子节点，没有id则表示查询所有根节点
	 * @param id 节点id
	 * @return
	 */
	public List<WebResource> getAllResource(String id) {
		return webResourceDao.getAllResource(id);
	}

	public WebResourceDao getWebResourceDao() {
		return webResourceDao;
	}

	public void setWebResourceDao(WebResourceDao webResourceDao) {
		this.webResourceDao = webResourceDao;
	}
	public WebResource getResourceById(String id) {
		return webResourceDao.getResourceById(id);
	}
}
