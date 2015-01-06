package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DegreeInfo entity. @author MyEclipse Persistence Tools
 */

public class DegreeInfo implements java.io.Serializable {

	// Fields

	private Long degreeId;
	private String degreeSchool;
	private Date degreeDate;
	private String degreeSkills;
	private String degreePrize;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public DegreeInfo() {
	}

	/** minimal constructor */
	public DegreeInfo(Long degreeId) {
		this.degreeId = degreeId;
	}

	/** full constructor */
	public DegreeInfo(Long degreeId, String degreeSchool, Date degreeDate,
			String degreeSkills, String degreePrize, Set personInfos) {
		this.degreeId = degreeId;
		this.degreeSchool = degreeSchool;
		this.degreeDate = degreeDate;
		this.degreeSkills = degreeSkills;
		this.degreePrize = degreePrize;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(Long degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeSchool() {
		return this.degreeSchool;
	}

	public void setDegreeSchool(String degreeSchool) {
		this.degreeSchool = degreeSchool;
	}

	public Date getDegreeDate() {
		return this.degreeDate;
	}

	public void setDegreeDate(Date degreeDate) {
		this.degreeDate = degreeDate;
	}

	public String getDegreeSkills() {
		return this.degreeSkills;
	}

	public void setDegreeSkills(String degreeSkills) {
		this.degreeSkills = degreeSkills;
	}

	public String getDegreePrize() {
		return this.degreePrize;
	}

	public void setDegreePrize(String degreePrize) {
		this.degreePrize = degreePrize;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}