package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PlanInfo entity. @author MyEclipse Persistence Tools
 */

public class PlanInfo implements java.io.Serializable {

	// Fields

	private Long planId;
	private Date planDate;
	private String planName;
	private Double planMoney;
	private Double planSource;
	private Double planFriends;
	private Double planBank;
	private Double planElse;
	private Double planStandby;
	private Long planLimit;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public PlanInfo() {
	}

	/** minimal constructor */
	public PlanInfo(Long planId, Date planDate, String planName,
			Double planMoney, Double planSource, Double planFriends,
			Double planBank, Double planElse, Double planStandby, Long planLimit) {
		this.planId = planId;
		this.planDate = planDate;
		this.planName = planName;
		this.planMoney = planMoney;
		this.planSource = planSource;
		this.planFriends = planFriends;
		this.planBank = planBank;
		this.planElse = planElse;
		this.planStandby = planStandby;
		this.planLimit = planLimit;
	}

	/** full constructor */
	public PlanInfo(Long planId, Date planDate, String planName,
			Double planMoney, Double planSource, Double planFriends,
			Double planBank, Double planElse, Double planStandby,
			Long planLimit, Set personInfos) {
		this.planId = planId;
		this.planDate = planDate;
		this.planName = planName;
		this.planMoney = planMoney;
		this.planSource = planSource;
		this.planFriends = planFriends;
		this.planBank = planBank;
		this.planElse = planElse;
		this.planStandby = planStandby;
		this.planLimit = planLimit;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getPlanId() {
		return this.planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getPlanMoney() {
		return this.planMoney;
	}

	public void setPlanMoney(Double planMoney) {
		this.planMoney = planMoney;
	}

	public Double getPlanSource() {
		return this.planSource;
	}

	public void setPlanSource(Double planSource) {
		this.planSource = planSource;
	}

	public Double getPlanFriends() {
		return this.planFriends;
	}

	public void setPlanFriends(Double planFriends) {
		this.planFriends = planFriends;
	}

	public Double getPlanBank() {
		return this.planBank;
	}

	public void setPlanBank(Double planBank) {
		this.planBank = planBank;
	}

	public Double getPlanElse() {
		return this.planElse;
	}

	public void setPlanElse(Double planElse) {
		this.planElse = planElse;
	}

	public Double getPlanStandby() {
		return this.planStandby;
	}

	public void setPlanStandby(Double planStandby) {
		this.planStandby = planStandby;
	}

	public Long getPlanLimit() {
		return this.planLimit;
	}

	public void setPlanLimit(Long planLimit) {
		this.planLimit = planLimit;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}