package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * WorkInfo entity. @author MyEclipse Persistence Tools
 */

public class WorkInfo implements java.io.Serializable {

	// Fields

	private Long workId;
	private Date workDate;
	private String workName;
	private String workType;
	private String workPosition;
	private String workContent;
	private Double workMoney;
	private String workLeave;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public WorkInfo() {
	}

	/** minimal constructor */
	public WorkInfo(Long workId) {
		this.workId = workId;
	}

	/** full constructor */
	public WorkInfo(Long workId, Date workDate, String workName,
			String workType, String workPosition, String workContent,
			Double workMoney, String workLeave, Set personInfos) {
		this.workId = workId;
		this.workDate = workDate;
		this.workName = workName;
		this.workType = workType;
		this.workPosition = workPosition;
		this.workContent = workContent;
		this.workMoney = workMoney;
		this.workLeave = workLeave;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getWorkId() {
		return this.workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
	}

	public Date getWorkDate() {
		return this.workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getWorkName() {
		return this.workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkType() {
		return this.workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkPosition() {
		return this.workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public String getWorkContent() {
		return this.workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public Double getWorkMoney() {
		return this.workMoney;
	}

	public void setWorkMoney(Double workMoney) {
		this.workMoney = workMoney;
	}

	public String getWorkLeave() {
		return this.workLeave;
	}

	public void setWorkLeave(String workLeave) {
		this.workLeave = workLeave;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}