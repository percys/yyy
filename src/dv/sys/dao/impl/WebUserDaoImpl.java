package dv.sys.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;

import dv.sys.dao.WebUserDao;
import dv.sys.entity.Torgmanage;
import dv.sys.entity.Tusruser;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebUser;

@SuppressWarnings("unchecked")
public class WebUserDaoImpl extends BaseDaoImpl implements WebUserDao {
	/**
	 * 根据id获得用户,此处两个查询条件是因为用户名和门店编码都可以登录
	 * @param userid 用户id
	 */
	public WebUser getWebUser(String username) {
//		return getHibernateTemplate().get(WebUser.class, userid);
		return (WebUser) getHibernateTemplate().find("from WebUser u where u.username='"+username+"' or u.orgcode='"+username+"'").get(0);
	}
	/**
	 * 查找删除用户id，获得用户
	 * @param userid 用户id
	 */
	public WebUser getWebUserid(String id) {
		// TODO Auto-generated method stub
		return (WebUser) getHibernateTemplate().find("from WebUser u where u.userid='"+id+"'").get(0);
	}
	/**
	 * 批量删除用户
	 * @param ids
	 */
	public void delUser(WebUser webUser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(webUser);
	}
	/**
	 * 保存或更新用户对象
	 */
	public WebUser saveWebUser(WebUser webUser) {
		webUser=getHibernateTemplate().merge(webUser);
		getHibernateTemplate().saveOrUpdate(webUser);
		return webUser;
	}

	/**
	 * 获得用户可以访问的资源
	 * @param webUser 用户对象
	 * @parma id 节点id	
	 * @param bool 
	 */
	public List<WebResource> getUserResource(WebUser webUser,String id,boolean bool) {
		String hql="";
		if (bool) {
			hql="from WebResource r inner join fetch r.webRoles ro inner join fetch ro.webUsers us where us.userid=?";
			return getHibernateTemplate().find(hql,webUser.getUserid());
		}
		if (id!=null) {
			hql="from WebResource r inner join fetch r.webRoles ro inner join fetch ro.webUsers us where us.userid=? and r.webResource.resid=?";
			return getHibernateTemplate().find(hql,webUser.getUserid(),id);
		}else{
//			hql="from WebResource r where r.webResource.resid=0 and (select count(*) from WebResource re where re.webResource.resid=r.resid)>0";
			hql="from WebResource where webResource.resid is null";
			return getHibernateTemplate().find(hql);
		}
	}
	
	/**
	 * 获得用户拥有的角色
	 */
	public List<WebRole> getUserRole(WebUser webUser) {
		String hql="from WebRole r inner join fetch r.webUsers u where u.userid=?";
		return getHibernateTemplate().find(hql,webUser.getUserid());
	}
	
	public List<WebUser> doSplitPage(int page, int rows, String sort,
			String order, QueryWebUser queryWebUser) {
		StringBuilder hql=new StringBuilder("from WebUser where 1=1");
		Map<String, Object> map=new HashMap<String,Object>();
		hql=jointHQL(hql, queryWebUser,map, sort, order);
		return (List<WebUser>) super.doSplitPage(hql.toString(), page, rows, map);
	}
	
	public Long getUserTotal(QueryWebUser queryWebUser) {
		StringBuilder hql=new StringBuilder("select count(*) from WebUser where 1=1");
		Map<String, Object> map=new HashMap<String,Object>();
		hql=jointHQL(hql, queryWebUser, map, null, null);
		return getTotal(hql.toString(), map);
	}
	
	/**
	 * 拼接hql
	 * @param hql 要拼接的hql
	 * @param queryWebUser 要注入的查询属性
	 * @param map 存放属性的集合
	 * @param sort 排序字段
	 * @param order 排序方式
	 * @return 拼接好的hql
	 */
	private StringBuilder jointHQL(StringBuilder hql,QueryWebUser queryWebUser,Map<String, Object> map,String sort,String order) {
		if (queryWebUser!=null) {
			if (queryWebUser.getUserid()!=null&&!queryWebUser.getUserid().trim().equals("")) {
				hql.append(" and userid like :userid");
				map.put("userid", "%"+queryWebUser.getUserid()+"%");
			}
			if (queryWebUser.getUsername()!=null&&!queryWebUser.getUsername().trim().equals("")) {
				hql.append(" and username like :username");
				map.put("username", "%"+queryWebUser.getUsername()+"%");
			}
			if (queryWebUser.getWebUnit().getName()!=null&&!queryWebUser.getWebUnit().getName().trim().equals("")) {
				hql.append(" and webUnit.name like :webUnitName");
				map.put("webUnitName", "%"+queryWebUser.getWebUnit().getName()+"%");
			}
			if (queryWebUser.getIsuse()!=null&&!queryWebUser.getIsuse().trim().equals("")) {
				hql.append(" and isuse=:isuse");
				map.put("isuse", queryWebUser.getIsuse());
			}
			if (queryWebUser.getBz()!=null&&!queryWebUser.getBz().trim().equals("")) {
				hql.append(" and bz=:bz");
				map.put("bz", queryWebUser.getBz());
			}
		}
		if (sort!=null&&!sort.trim().equals("")&&order!=null&&!order.trim().equals("")) {
			hql.append(" order by :sort :order");
			map.put("sort", sort);
			map.put("order", order);
		}
		return hql;
	}
	public List<Torgmanage> getOrgCode(WebUser webUser) {
		if(webUser==null){
			return getHibernateTemplate().find("from Torgmanage");
		}
		return getHibernateTemplate().find("from Torgmanage where orgcode=?",webUser.getOrgcode());
	}
	public Torgmanage getCode(Torgmanage tor) {
		return (Torgmanage) getHibernateTemplate().find("from Torgmanage where orgcode='"+tor.getOrgcode()+"'").get(0);
	}
	public List<Tusruser> getCheckGh(WebUser user) {
		return getHibernateTemplate().find("from Tusruser where usercode='"+user.getAgentId()+"'");
	}
	public WebUser getUserAgentId(WebUser user) {
		// TODO Auto-generated method stub
		return (WebUser)getHibernateTemplate().find("from WebUser where agentId='"+user.getAgentId()+"'").get(0);
	}
	
}
