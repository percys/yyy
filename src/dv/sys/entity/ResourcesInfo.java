package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ResourcesInfo entity. @author MyEclipse Persistence Tools
 */

public class ResourcesInfo implements java.io.Serializable {

	// Fields

	private Long resourcesId;
	private String resourcesSituaction;
	private String resourcesArea;
	private String resourcesVehicle;
	private String resourcesEstate;
	private String resourcesInvestment;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public ResourcesInfo() {
	}

	/** minimal constructor */
	public ResourcesInfo(Long resourcesId) {
		this.resourcesId = resourcesId;
	}

	/** full constructor */
	public ResourcesInfo(Long resourcesId, String resourcesSituaction,
			String resourcesArea, String resourcesVehicle,
			String resourcesEstate, String resourcesInvestment, Set personInfos) {
		this.resourcesId = resourcesId;
		this.resourcesSituaction = resourcesSituaction;
		this.resourcesArea = resourcesArea;
		this.resourcesVehicle = resourcesVehicle;
		this.resourcesEstate = resourcesEstate;
		this.resourcesInvestment = resourcesInvestment;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getResourcesId() {
		return this.resourcesId;
	}

	public void setResourcesId(Long resourcesId) {
		this.resourcesId = resourcesId;
	}

	public String getResourcesSituaction() {
		return this.resourcesSituaction;
	}

	public void setResourcesSituaction(String resourcesSituaction) {
		this.resourcesSituaction = resourcesSituaction;
	}

	public String getResourcesArea() {
		return this.resourcesArea;
	}

	public void setResourcesArea(String resourcesArea) {
		this.resourcesArea = resourcesArea;
	}

	public String getResourcesVehicle() {
		return this.resourcesVehicle;
	}

	public void setResourcesVehicle(String resourcesVehicle) {
		this.resourcesVehicle = resourcesVehicle;
	}

	public String getResourcesEstate() {
		return this.resourcesEstate;
	}

	public void setResourcesEstate(String resourcesEstate) {
		this.resourcesEstate = resourcesEstate;
	}

	public String getResourcesInvestment() {
		return this.resourcesInvestment;
	}

	public void setResourcesInvestment(String resourcesInvestment) {
		this.resourcesInvestment = resourcesInvestment;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}