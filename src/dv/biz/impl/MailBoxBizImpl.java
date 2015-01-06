package dv.biz.impl;

import java.util.List;

import dv.biz.MailBoxBiz;
import dv.sys.dao.MailBoxDao;
import dv.sys.entity.Mailbox;
import dv.sys.entity.MailboxDetails;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryMailbox;

public class MailBoxBizImpl implements MailBoxBiz {

	private MailBoxDao md;
	
	public MailBoxDao getMd() {
		return md;
	}

	public void setMd(MailBoxDao md) {
		this.md = md;
	}

	public List<MailboxDetails> getUnReadInfo(WebUser user) {
		return md.getUnReadInfo(user);
	}

	public int addsend(Mailbox maibox) {
		return md.addsend(maibox);
	}

	public List<MailboxDetails> getMailInfo(WebUser user, MailboxDetails mds) {
		return md.getMailInfo(user, mds);
	}

	public void updateMail(Mailbox mb) {
		md.updateMail(mb);
	}

	public Long getCommodityTotal(WebUser user) {
		return md.getCommodityTotal(user);
	}
	public Long getCommodityTotals(WebUser user) {
		return md.getCommodityTotals(user);
	}
	public Long getCount(WebUser user){
		return md.getCount(user);
	}
	public List<Mailbox> doSplitPage(int page, int rows,
			WebUser user) {
		return md.doSplitPage(page, rows, user);
	}
	public List<Mailbox> doSplitPages(int page, int rows,
			WebUser user) {
		return md.doSplitPages(page, rows, user);
	}
	public Mailbox getMailbox(Integer id) {
		// TODO Auto-generated method stub
		return md.getMailbox(id);
	}

	public MailboxDetails saveMbDetail(MailboxDetails detail) {
		// TODO Auto-generated method stub
		return md.saveMbDetail(detail);
	}

}
