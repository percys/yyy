package dv.sys.entity;

/**
 * WebDictionaryId entity. @author MyEclipse Persistence Tools
 */

public class WebDictionaryId implements java.io.Serializable {

	private static final long serialVersionUID = -4980326921119472040L;
	// Fields

	private String typename;
	private String itemcode;


	// Constructors

	/** default constructor */
	public WebDictionaryId() {
	}

	/** minimal constructor */
	public WebDictionaryId(String typename, String itemcode) {
		this.typename = typename;
		this.itemcode = itemcode;
	}


	// Property accessors

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WebDictionaryId))
			return false;
		WebDictionaryId castOther = (WebDictionaryId) other;

		return ((this.getTypename() == castOther.getTypename()) || (this
				.getTypename() != null
				&& castOther.getTypename() != null && this.getTypename()
				.equals(castOther.getTypename())))
				&& ((this.getItemcode() == castOther.getItemcode()) || (this
						.getItemcode() != null
						&& castOther.getItemcode() != null && this
						.getItemcode().equals(castOther.getItemcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTypename() == null ? 0 : this.getTypename().hashCode());
		result = 37 * result
				+ (getItemcode() == null ? 0 : this.getItemcode().hashCode());
		result = 37 * result;
		return result;
	}

}