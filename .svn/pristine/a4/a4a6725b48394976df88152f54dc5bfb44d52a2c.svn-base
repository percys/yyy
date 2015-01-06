package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SituationInfo entity. @author MyEclipse Persistence Tools
 */

public class SituationInfo implements java.io.Serializable {

	// Fields

	private Long situationId;
	private Long situationRegion;
	private String situationSurround;
	private String situationStore;
	private String situationSituation;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SituationInfo() {
	}

	/** minimal constructor */
	public SituationInfo(Long situationId, Long situationRegion) {
		this.situationId = situationId;
		this.situationRegion = situationRegion;
	}

	/** full constructor */
	public SituationInfo(Long situationId, Long situationRegion,
			String situationSurround, String situationStore,
			String situationSituation, Set personInfos) {
		this.situationId = situationId;
		this.situationRegion = situationRegion;
		this.situationSurround = situationSurround;
		this.situationStore = situationStore;
		this.situationSituation = situationSituation;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getSituationId() {
		return this.situationId;
	}

	public void setSituationId(Long situationId) {
		this.situationId = situationId;
	}

	public Long getSituationRegion() {
		return this.situationRegion;
	}

	public void setSituationRegion(Long situationRegion) {
		this.situationRegion = situationRegion;
	}

	public String getSituationSurround() {
		return this.situationSurround;
	}

	public void setSituationSurround(String situationSurround) {
		this.situationSurround = situationSurround;
	}

	public String getSituationStore() {
		return this.situationStore;
	}

	public void setSituationStore(String situationStore) {
		this.situationStore = situationStore;
	}

	public String getSituationSituation() {
		return this.situationSituation;
	}

	public void setSituationSituation(String situationSituation) {
		this.situationSituation = situationSituation;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}