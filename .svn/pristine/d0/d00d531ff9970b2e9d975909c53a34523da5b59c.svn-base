package dv.sys.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dv.sys.dao.WebResourceDao;
import dv.sys.entity.WebResource;

@SuppressWarnings("unchecked")
public class WebResourceDaoImpl extends HibernateDaoSupport implements
		WebResourceDao {
	/**
	 * 获得所有资源
	 * @return
	 */
	public List<WebResource> getAllResource() {
		return getHibernateTemplate().find("from WebResource");
	}
	/**
	 * 根据id获得子节点，没有id则表示查询所有根节点
	 * @param id 节点id
	 * @return
	 */
	public List<WebResource> getAllResource(String id) {
		String hql="from WebResource where 1=1";
		if (id!=null) {
			hql+=" and webResource.resid=?";
			return getHibernateTemplate().find(hql,id);
		}else{
			hql+=" and webResource.resid is null";
		}
		return getHibernateTemplate().find(hql);
	}
	
	public WebResource getResourceById(String id) {
		return getHibernateTemplate().get(WebResource.class, id);
	}
}
