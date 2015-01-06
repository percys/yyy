package dv.sys.queryProperties;

import dv.sys.entity.Mailbox;
import dv.sys.entity.MailboxDetails;
import dv.sys.entity.WebUser;

public class QueryMailbox {
	
	private WebUser user;
	
	private MailboxDetails mDetails;
	
	private Mailbox mailbox;

	public WebUser getUser() {
		return user;
	}

	public void setUser(WebUser user) {
		this.user = user;
	}

	public MailboxDetails getmDetails() {
		return mDetails;
	}

	public void setmDetails(MailboxDetails mDetails) {
		this.mDetails = mDetails;
	}

	public Mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	
}
