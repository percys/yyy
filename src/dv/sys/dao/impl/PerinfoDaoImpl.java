package dv.sys.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import dv.sys.dao.PerinfoDao;
import dv.sys.entity.PersonInfo;

public class PerinfoDaoImpl extends HibernateDaoSupport implements PerinfoDao {

	public void addPerinfo(PersonInfo perinfo) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(perinfo);
	}

}
