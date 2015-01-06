package dv.sys.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * WebResource entity. @author MyEclipse Persistence Tools
 */
public class WebResource implements java.io.Serializable {

	private static final long serialVersionUID = -7036244335491961028L;
	// Fields

	private String resid;
	private WebResource webResource;
	private String name;
	private String url;
	private String orderno;
	private String ico;
	private String ispage;
	private Set<WebResource> webResources = new HashSet<WebResource>(0);
	private Set<WebRole> webRoles = new HashSet<WebRole>(0);

	// Constructors

	/** default constructor */
	public WebResource() {
	}

	/** minimal constructor */
	public WebResource(String resid) {
		this.resid = resid;
	}


	// Property accessors

	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(obj == null){
			return false;
		}
		
		if(!(obj instanceof WebResource)){
			return false;
		}
		
		WebResource temp = (WebResource)obj;
		if(temp.getResid().equals(this.getResid())){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getResid().hashCode();
	}

	public String getResid() {
		return this.resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public WebResource getWebResource() {
		return this.webResource;
	}

	public void setWebResource(WebResource webResource) {
		this.webResource = webResource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getIco() {
		return this.ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getIspage() {
		return this.ispage;
	}

	public void setIspage(String ispage) {
		this.ispage = ispage;
	}

	public Set<WebResource> getWebResources() {
		return webResources;
	}

	public void setWebResources(Set<WebResource> webResources) {
		this.webResources = webResources;
	}

	public Set<WebRole> getWebRoles() {
		return webRoles;
	}

	public void setWebRoles(Set<WebRole> webRoles) {
		this.webRoles = webRoles;
	}

	@Override
	public String toString() {
		return "WebResource [resid=" + resid + ", name=" + name + ", url="
				+ url + ", orderno=" + orderno + ", ico=" + ico + ", ispage="
				+ ispage + "]";
	}
}