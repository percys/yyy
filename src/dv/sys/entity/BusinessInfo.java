package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * BusinessInfo entity. @author MyEclipse Persistence Tools
 */

public class BusinessInfo implements java.io.Serializable {

	// Fields

	private Long businessId;
	private ShopInfo shopInfo;
	private JoinInfo joinInfo;
	private OnceInfo onceInfo;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BusinessInfo() {
	}

	/** minimal constructor */
	public BusinessInfo(Long businessId) {
		this.businessId = businessId;
	}

	/** full constructor */
	public BusinessInfo(Long businessId, ShopInfo shopInfo, JoinInfo joinInfo,
			OnceInfo onceInfo, Set personInfos) {
		this.businessId = businessId;
		this.shopInfo = shopInfo;
		this.joinInfo = joinInfo;
		this.onceInfo = onceInfo;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public ShopInfo getShopInfo() {
		return this.shopInfo;
	}

	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

	public JoinInfo getJoinInfo() {
		return this.joinInfo;
	}

	public void setJoinInfo(JoinInfo joinInfo) {
		this.joinInfo = joinInfo;
	}

	public OnceInfo getOnceInfo() {
		return this.onceInfo;
	}

	public void setOnceInfo(OnceInfo onceInfo) {
		this.onceInfo = onceInfo;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}