package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * JoinInfo entity. @author MyEclipse Persistence Tools
 */

public class JoinInfo implements java.io.Serializable {

	// Fields

	private Long joinId;
	private String joinContent;
	private Date joinDate;
	private Double joinSales;
	private Set businessInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public JoinInfo() {
	}

	/** minimal constructor */
	public JoinInfo(Long joinId) {
		this.joinId = joinId;
	}

	/** full constructor */
	public JoinInfo(Long joinId, String joinContent, Date joinDate,
			Double joinSales, Set businessInfos) {
		this.joinId = joinId;
		this.joinContent = joinContent;
		this.joinDate = joinDate;
		this.joinSales = joinSales;
		this.businessInfos = businessInfos;
	}

	// Property accessors

	public Long getJoinId() {
		return this.joinId;
	}

	public void setJoinId(Long joinId) {
		this.joinId = joinId;
	}

	public String getJoinContent() {
		return this.joinContent;
	}

	public void setJoinContent(String joinContent) {
		this.joinContent = joinContent;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Double getJoinSales() {
		return this.joinSales;
	}

	public void setJoinSales(Double joinSales) {
		this.joinSales = joinSales;
	}

	public Set getBusinessInfos() {
		return this.businessInfos;
	}

	public void setBusinessInfos(Set businessInfos) {
		this.businessInfos = businessInfos;
	}

}