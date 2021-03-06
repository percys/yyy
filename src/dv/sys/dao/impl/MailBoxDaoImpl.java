package dv.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dv.sys.dao.MailBoxDao;
import dv.sys.entity.Mailbox;
import dv.sys.entity.MailboxDetails;
import dv.sys.entity.WebUser;

public class MailBoxDaoImpl extends HibernateDaoSupport implements MailBoxDao {

	public List<MailboxDetails> getUnReadInfo(WebUser user) {
		return super.getHibernateTemplate().find("from Mailbox mb inner join fetch mb.mailboxDetails md where md.mdId=mb.mbId and mb.sendname=?",user.getUsername());
	}
	
	public List<MailboxDetails> getMailInfo(WebUser user,MailboxDetails mds) {
		return super.getHibernateTemplate().find("from Mailbox mb inner join fetch mb.mailboxDetails md where md.mdId=mb.mbId and mb.receivename=? and md.mdId=?",user.getUsername(),mds.getMdId());
	}

	public int addsend(Mailbox maibox) {
		super.getHibernateTemplate().save(maibox);
		return maibox.getMbId();
	}

	public void updateMail(Mailbox mb) {
		super.getHibernateTemplate().update(mb);
	}
	public Long getCount(WebUser user)
	{
		String hql = "select count(*) from Mailbox where receivename='"+user.getUsername()+"' and mbState=0";
		return (Long) getHibernateTemplate().find(hql).listIterator().next();
	}
	public Long getCommodityTotal(WebUser user) {
		String hql = "select count(*) from Mailbox where receivename='"+user.getUsername()+"'";
		return (Long) getHibernateTemplate().find(hql).listIterator().next();
	}

	public List<Mailbox> doSplitPage(final int page,final int rows,
			final WebUser user) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
//				from Mailbox mb inner join fetch mb.mailboxDetails md where md.mdId=mb.mbId and mb.receivename='"+user.getUsername()+"'";
				String hql = "from Mailbox where receivename='"+user.getUsername()+"' order by mbId desc";
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1) * rows);
				query.setMaxResults(rows);
				List list = query.list();
				return list;
			}
		});
		return list;
	}
	public Long getCommodityTotals(WebUser user) {
		String hql = "select count(*) from Mailbox where sendname='"+user.getUsername()+"'";
		return (Long) getHibernateTemplate().find(hql).listIterator().next();
	}

	public List<Mailbox> doSplitPages(final int page,final int rows,
			final WebUser user) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
//				from Mailbox mb inner join fetch mb.mailboxDetails md where md.mdId=mb.mbId and mb.receivename='"+user.getUsername()+"'";
				String hql = "from Mailbox where sendname='"+user.getUsername()+"' order by mbId desc";
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1) * rows);
				query.setMaxResults(rows);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	public Mailbox getMailbox(Integer id) {
		// TODO Auto-generated method stub
		return (Mailbox) super.getHibernateTemplate().find("from Mailbox where mbId='"+id+"'").get(0);
	}

	public MailboxDetails saveMbDetail(MailboxDetails detail) {
		// TODO Auto-generated method stub
		return (MailboxDetails) super.getHibernateTemplate().save(detail);
	}

}