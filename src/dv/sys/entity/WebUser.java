package dv.sys.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dv.sys.entity.Mailbox;

/**
 * WebUser entity. @author MyEclipse Persistence Tools
 */

public class WebUser implements java.io.Serializable {

	private static final long serialVersionUID = 6463826999747814173L;
	// Fields

	private String userid;
	private WebUnit webUnit;
	private String username;
	private String password;
	private String phoneno;
	private String bz;
	private String userType;
	private String isuse = "T";
	private String email;
	private String agentId;
	private String orgcode;
	private String orgname;
	private Set<WebRole> webRoles = new HashSet<WebRole>(0);
	private List<WebResource> webResources = new ArrayList<WebResource>();
	// Constructors

	/** default constructor */
	public WebUser() {
	}

	/** minimal constructor */
	public WebUser(String userid, String isuse,String agentId, String orgcode, String orgname) {
		this.userid = userid;
		this.isuse = isuse;
		this.agentId = agentId;
		this.orgcode = orgcode;
		this.orgname = orgname;
	}


	public List<WebResource> getWebResources() {
		return webResources;
	}

	public void setWebResources(List<WebResource> webResources) {
		this.webResources = webResources;
	}

	// Property accessors
	public String getUserid() {
		return this.userid;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public WebUnit getWebUnit() {
		if(this.webUnit==null){
			this.webUnit = new WebUnit();
		}
		return this.webUnit;
	}

	public void setWebUnit(WebUnit webUnit) {
		this.webUnit = webUnit;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIsuse() {
		return this.isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<WebRole> getWebRoles() {
		return webRoles;
	}

	public void setWebRoles(Set<WebRole> webRoles) {
		this.webRoles = webRoles;
	}
	
	public String getWebUnitString(){
		if(this.webUnit!= null){
			return this.webUnit.getName();
		}else{
			return "";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((isuse == null) ? 0 : isuse.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneno == null) ? 0 : phoneno.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebUser other = (WebUser) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isuse == null) {
			if (other.isuse != null)
				return false;
		} else if (!isuse.equals(other.isuse))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneno == null) {
			if (other.phoneno != null)
				return false;
		} else if (!phoneno.equals(other.phoneno))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}