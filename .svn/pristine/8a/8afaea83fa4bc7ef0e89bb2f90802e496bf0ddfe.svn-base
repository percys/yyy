package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ShopInfo entity. @author MyEclipse Persistence Tools
 */

public class ShopInfo implements java.io.Serializable {

	// Fields

	private Long shopId;
	private String shopContent;
	private Date shopDate;
	private Double shopSales;
	private Set businessInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShopInfo() {
	}

	/** minimal constructor */
	public ShopInfo(Long shopId) {
		this.shopId = shopId;
	}

	/** full constructor */
	public ShopInfo(Long shopId, String shopContent, Date shopDate,
			Double shopSales, Set businessInfos) {
		this.shopId = shopId;
		this.shopContent = shopContent;
		this.shopDate = shopDate;
		this.shopSales = shopSales;
		this.businessInfos = businessInfos;
	}

	// Property accessors

	public Long getShopId() {
		return this.shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopContent() {
		return this.shopContent;
	}

	public void setShopContent(String shopContent) {
		this.shopContent = shopContent;
	}

	public Date getShopDate() {
		return this.shopDate;
	}

	public void setShopDate(Date shopDate) {
		this.shopDate = shopDate;
	}

	public Double getShopSales() {
		return this.shopSales;
	}

	public void setShopSales(Double shopSales) {
		this.shopSales = shopSales;
	}

	public Set getBusinessInfos() {
		return this.businessInfos;
	}

	public void setBusinessInfos(Set businessInfos) {
		this.businessInfos = businessInfos;
	}

}