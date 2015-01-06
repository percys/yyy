package dv.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport {
	public List<?> doSplitPage(final String hql,final int page, final int rows,final Map<String, Object> map){
		return (List<?>) getHibernateTemplate().execute(new HibernateCallback<Object>(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				if (map!=null&&!map.isEmpty()) {
					for (String key : map.keySet()) {
						query.setParameter(key, map.get(key));
					}
				}
				return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
			}
		});
	}
	
	/**
	 * 获得总记录
	 * @param hql 拼接好的HQL语句
	 * @param map 要注入的属性值
	 * @return 总记录数量
	 */
	public Long getTotal(final String hql,final Map<String, Object> map){
		return (Long) getHibernateTemplate().execute(new HibernateCallback<Object>(){
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				if (map!=null&&!map.isEmpty()) {
					for (String key : map.keySet()) {
						query.setParameter(key, map.get(key));
					}
					map.clear();
				}
				return (Long)query.uniqueResult();
			}
		});
	}
}
