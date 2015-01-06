package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Mailbox entity. @author MyEclipse Persistence Tools
 */

public class Mailbox implements java.io.Serializable {

	// Fields

	private Integer mbId;
	private MailboxDetails mailboxDetails;
	private String receivename;
	private String sendname;
	private String mbState;

	// Constructors

	/** default constructor */
	public Mailbox() {
	}

	/** full constructor */
	public Mailbox(Integer mbId, MailboxDetails mailboxDetails,
			String receivename, String sendname, String mbState) {
		this.mbId = mbId;
		this.mailboxDetails = mailboxDetails;
		this.receivename = receivename;
		this.sendname = sendname;
		this.mbState = mbState;
	}

	// Property accessors

	public Integer getMbId() {
		return this.mbId;
	}

	public void setMbId(Integer mbId) {
		this.mbId = mbId;
	}

	public MailboxDetails getMailboxDetails() {
		return this.mailboxDetails;
	}

	public void setMailboxDetails(MailboxDetails mailboxDetails) {
		this.mailboxDetails = mailboxDetails;
	}

	public String getReceivename() {
		return this.receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getSendname() {
		return this.sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getMbState() {
		return this.mbState;
	}

	public void setMbState(String mbState) {
		this.mbState = mbState;
	}
}