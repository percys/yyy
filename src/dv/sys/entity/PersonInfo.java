package dv.sys.entity;

/**
 * PersonInfo entity. @author MyEclipse Persistence Tools
 */

public class PersonInfo implements java.io.Serializable {

	// Fields

	private Long personId;
	private UserInfo userInfo;
	private BusinessInfo businessInfo;
	private WorkInfo workInfo;
	private ResourcesInfo resourcesInfo;
	private SituationInfo situationInfo;
	private DegreeInfo degreeInfo;
	private PlanInfo planInfo;

	// Constructors

	/** default constructor */
	public PersonInfo() {
	}

	/** minimal constructor */
	public PersonInfo(Long personId, UserInfo userInfo,
			ResourcesInfo resourcesInfo, SituationInfo situationInfo,
			PlanInfo planInfo) {
		this.personId = personId;
		this.userInfo = userInfo;
		this.resourcesInfo = resourcesInfo;
		this.situationInfo = situationInfo;
		this.planInfo = planInfo;
	}

	/** full constructor */
	public PersonInfo(Long personId, UserInfo userInfo,
			BusinessInfo businessInfo, WorkInfo workInfo,
			ResourcesInfo resourcesInfo, SituationInfo situationInfo,
			DegreeInfo degreeInfo, PlanInfo planInfo) {
		this.personId = personId;
		this.userInfo = userInfo;
		this.businessInfo = businessInfo;
		this.workInfo = workInfo;
		this.resourcesInfo = resourcesInfo;
		this.situationInfo = situationInfo;
		this.degreeInfo = degreeInfo;
		this.planInfo = planInfo;
	}

	// Property accessors

	public Long getPersonId() {
		return this.personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public BusinessInfo getBusinessInfo() {
		return this.businessInfo;
	}

	public void setBusinessInfo(BusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}

	public WorkInfo getWorkInfo() {
		return this.workInfo;
	}

	public void setWorkInfo(WorkInfo workInfo) {
		this.workInfo = workInfo;
	}

	public ResourcesInfo getResourcesInfo() {
		return this.resourcesInfo;
	}

	public void setResourcesInfo(ResourcesInfo resourcesInfo) {
		this.resourcesInfo = resourcesInfo;
	}

	public SituationInfo getSituationInfo() {
		return this.situationInfo;
	}

	public void setSituationInfo(SituationInfo situationInfo) {
		this.situationInfo = situationInfo;
	}

	public DegreeInfo getDegreeInfo() {
		return this.degreeInfo;
	}

	public void setDegreeInfo(DegreeInfo degreeInfo) {
		this.degreeInfo = degreeInfo;
	}

	public PlanInfo getPlanInfo() {
		return this.planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

}