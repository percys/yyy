package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * MailboxDetails entity. @author MyEclipse Persistence Tools
 */

public class MailboxDetails implements java.io.Serializable {

	// Fields

	private Integer mdId;
	private String mdTitle;
	private String mdContent;
	private String mdSendTime;
	private Set mailboxes = new HashSet(0);

	// Constructors

	/** default constructor */
	public MailboxDetails() {
	}

	/** minimal constructor */
	public MailboxDetails(Integer mdId, String mdTitle, String mdContent,
			String mdSendTime) {
		this.mdId = mdId;
		this.mdTitle = mdTitle;
		this.mdContent = mdContent;
		this.mdSendTime = mdSendTime;
	}

	/** full constructor */
	public MailboxDetails(Integer mdId, String mdTitle, String mdContent,
			String mdSendTime, Set mailboxes) {
		this.mdId = mdId;
		this.mdTitle = mdTitle;
		this.mdContent = mdContent;
		this.mdSendTime = mdSendTime;
		this.mailboxes = mailboxes;
	}

	// Property accessors

	public Integer getMdId() {
		return this.mdId;
	}

	public void setMdId(Integer mdId) {
		this.mdId = mdId;
	}

	public String getMdTitle() {
		return this.mdTitle;
	}

	public void setMdTitle(String mdTitle) {
		this.mdTitle = mdTitle;
	}

	public String getMdContent() {
		return this.mdContent;
	}

	public void setMdContent(String mdContent) {
		this.mdContent = mdContent;
	}

	public String getMdSendTime() {
		return this.mdSendTime;
	}

	public void setMdSendTime(String mdSendTime) {
		this.mdSendTime = mdSendTime;
	}

	public Set getMailboxes() {
		return this.mailboxes;
	}

	public void setMailboxes(Set mailboxes) {
		this.mailboxes = mailboxes;
	}

}