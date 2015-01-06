package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OnceInfo entity. @author MyEclipse Persistence Tools
 */

public class OnceInfo implements java.io.Serializable {

	// Fields

	private Long onceId;
	private String onceContent;
	private Date onceDate;
	private Double onceSales;
	private Set businessInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public OnceInfo() {
	}

	/** minimal constructor */
	public OnceInfo(Long onceId) {
		this.onceId = onceId;
	}

	/** full constructor */
	public OnceInfo(Long onceId, String onceContent, Date onceDate,
			Double onceSales, Set businessInfos) {
		this.onceId = onceId;
		this.onceContent = onceContent;
		this.onceDate = onceDate;
		this.onceSales = onceSales;
		this.businessInfos = businessInfos;
	}

	// Property accessors

	public Long getOnceId() {
		return this.onceId;
	}

	public void setOnceId(Long onceId) {
		this.onceId = onceId;
	}

	public String getOnceContent() {
		return this.onceContent;
	}

	public void setOnceContent(String onceContent) {
		this.onceContent = onceContent;
	}

	public Date getOnceDate() {
		return this.onceDate;
	}

	public void setOnceDate(Date onceDate) {
		this.onceDate = onceDate;
	}

	public Double getOnceSales() {
		return this.onceSales;
	}

	public void setOnceSales(Double onceSales) {
		this.onceSales = onceSales;
	}

	public Set getBusinessInfos() {
		return this.businessInfos;
	}

	public void setBusinessInfos(Set businessInfos) {
		this.businessInfos = businessInfos;
	}

}