package dv.sys.entity;

/**
 * WebDictionary entity. @author MyEclipse Persistence Tools
 */

public class WebDictionary implements java.io.Serializable {

	private static final long serialVersionUID = 6799577829223569730L;
	// Fields
	private WebDictionaryId id;
	private String itemdesc;
	private String orderno;
	private String isvisible;
	private String memo;
	// Constructors

	/** default constructor */
	public WebDictionary() {
	}

	/** full constructor */
	public WebDictionary(WebDictionaryId id) {
		this.id = id;
	}

	// Property accessors

	public WebDictionaryId getId() {
		return this.id;
	}

	public void setId(WebDictionaryId id) {
		this.id = id;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getIsvisible() {
		return isvisible;
	}
	

	public void setIsvisible(String isvisible) {
		this.isvisible = isvisible;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	public String getItemcode() {
		return id.getItemcode();
	}

	public void setItemcode(String itemcode) {
		if(this.id==null) this.id = new WebDictionaryId();
		this.id.setItemcode(itemcode);
	}

	public String getTypename() {
		return id.getTypename();
	}

	public void setTypename(String typename) {
		if(this.id==null) this.id = new WebDictionaryId();
		this.id.setTypename(typename);
	}
}