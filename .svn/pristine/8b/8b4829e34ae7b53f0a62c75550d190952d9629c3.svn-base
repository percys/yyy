package dv.sys.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dv.sys.dao.internalDao;
import dv.sys.entity.TtotdzrptShnbjs;
import dv.sys.queryProperties.QueryInternalNbjs;

public class internalDaoImpl extends HibernateDaoSupport implements internalDao {

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		String hql = "select count(*) from TtotdzrptShnbjs where 1=1";
		List<String> values = new ArrayList<String>();
		if (toto != null) {
			hql = jointHQL(hql, toto, values);
		} 
		return (Long) getHibernateTemplate().find(hql).listIterator().next();
	}

	public List<TtotdzrptShnbjs> doSplitPage(final int page,final int rows,final QueryInternalNbjs toto) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TtotdzrptShnbjs where 1=1";
				List<String> values = new ArrayList<String>();
				if (toto != null) {
					hql = jointHQL(hql, toto, values);
				}
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1) * rows);
				query.setMaxResults(rows);
				List list = query.list();
				return list;
			}
		});
		return list;
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
	
	private String jointHQL(String hql,QueryInternalNbjs query,List<String> values) {		
		if (query!=null) {
			if(!("".equals(query.getBeginDate())) && !("".equals(query.getEndDate())) && query.getOrgcode().equals("")){//日期有，门店编码无，查询本范围日期内所有门店数据
				hql = hql + " and  rptdate >='"+query.getBeginDate()+"' and rptdate <='"+query.getEndDate()+"' order by rptdate desc";
			}else if(query.getBeginDate().equals("") && query.getEndDate().equals("") && !("".equals(query.getOrgcode()))){//日期无，门店编码有，查询此门店当天的数据
				hql = hql + " and orgcode='"+query.getOrgcode()+"' order by rptdate desc";
			}else if(!("".equals(query.getBeginDate())) && !("".equals(query.getEndDate())) && !("".equals(query.getOrgcode()))){//都有，查询范围内该门店的数据
				hql = hql + " and rptdate>='"+query.getBeginDate()+"' and rptdate<= '"+query.getEndDate()+"' and orgcode='"+query.getOrgcode()+"' order by rptdate desc";
			}
		}
		return hql;
	}
}
