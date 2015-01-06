package dv.sys.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dv.sys.dao.TtotdzrptWbYgDao;
import dv.sys.entity.TtotdzrptWb;
import dv.sys.queryProperties.QueryInternalNbjs;

public class TtotdzrptWbYgDaoImpl extends HibernateDaoSupport implements
		TtotdzrptWbYgDao {

	public Long getCommodityTotal(QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from TtotdzrptWb where 1=1 and orgcode='"+toto.getOrgcode()+"'";
		List<String> values = new ArrayList<String>();
		if (toto != null) {
			hql = jointHQL(hql, toto, values);
		} 
		return (Long) getHibernateTemplate().find(hql).listIterator().next();
	}

	public List<TtotdzrptWb> doSplitPage(final int page, final int rows,
			final QueryInternalNbjs toto) {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from TtotdzrptWb where 1=1 and orgcode='"+toto.getOrgcode()+"'";
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
	 * @param query 要注入的查询属性
	 * @param values 存放属性的集合
	 * @return 拼接好的hql
	 */
	private String jointHQL(String hql,QueryInternalNbjs query,List<String> values) {
		String nowday=Time(40);
		//员工只有日期查询条件，只有两种情况..
		if (query!=null) {
			if(!("".equals(query.getBeginDate())||null==query.getBeginDate()) && !("".equals(query.getEndDate())||null==query.getEndDate())){//日期有,查询本范围日期内所有门店数据
				hql = hql + " and  rptdate >='"+query.getBeginDate()+"' and rptdate <='"+query.getEndDate()+"' order by rptdate desc";
			}else if(null==query.getBeginDate() && null==query.getEndDate()){//日期为空，查询此门店30天的数据
				hql = hql + " and rptdate >='"+nowday+"' order by rptdate desc";
			}
		}
		return hql;
	}
	//得到设定时间
	public static String Time(Integer dd){
			 Calendar cal = Calendar.getInstance();
			 cal.add(Calendar.DATE, -dd);
			 String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			 return yesterday;
	}
}
