package dv.sys.entity;

/**
 * Torgmanage entity. @author MyEclipse Persistence Tools
 */

public class Torgmanage implements java.io.Serializable {

	// Fields

	private String orgcode;
	private String inorgcode;
	private String orgname;
	private Double area;
	private String orgtype;
	private String preorgcode;
	private String orgclass;
	private String ismanastock;
	private String forgcode;
	private String zborgcode;
	private String wlareacode;
	private String acclevel;
	private String dbsvrname;
	private String dbname;
	private String commmode;
	private String businessmode;
	private String facecode;
	private String commpathout;
	private String commpathin;
	private Integer yhpri;
	private String ismbzq;
	private Double rkbjrate;
	private Double ckbjrate;
	private Double gqbjrate;
	private String remark;
	private String dbid;
	private String isenable;
	private String pricemode;
	private Integer poscount;
	private String poscountverify;
	private String shorpgrade;
	private String modalshop;
	private String quotearea;
	private String machineconfig;
	private String creditkzorgcode;
	private String paygrpcode;

	// Constructors

	/** default constructor */
	public Torgmanage() {
	}

	/** minimal constructor */
	public Torgmanage(String inorgcode, String orgname, Double area,
			String orgtype, String preorgcode, String orgclass,
			String ismanastock, Integer yhpri, String ismbzq, Double rkbjrate,
			String dbid, String isenable, String pricemode,
			String machineconfig, String paygrpcode) {
		this.inorgcode = inorgcode;
		this.orgname = orgname;
		this.area = area;
		this.orgtype = orgtype;
		this.preorgcode = preorgcode;
		this.orgclass = orgclass;
		this.ismanastock = ismanastock;
		this.yhpri = yhpri;
		this.ismbzq = ismbzq;
		this.rkbjrate = rkbjrate;
		this.dbid = dbid;
		this.isenable = isenable;
		this.pricemode = pricemode;
		this.machineconfig = machineconfig;
		this.paygrpcode = paygrpcode;
	}

	/** full constructor */
	public Torgmanage(String inorgcode, String orgname, Double area,
			String orgtype, String preorgcode, String orgclass,
			String ismanastock, String forgcode, String zborgcode,
			String wlareacode, String acclevel, String dbsvrname,
			String dbname, String commmode, String businessmode,
			String facecode, String commpathout, String commpathin,
			Integer yhpri, String ismbzq, Double rkbjrate, Double ckbjrate,
			Double gqbjrate, String remark, String dbid, String isenable,
			String pricemode, Integer poscount, String poscountverify,
			String shorpgrade, String modalshop, String quotearea,
			String machineconfig, String creditkzorgcode, String paygrpcode) {
		this.inorgcode = inorgcode;
		this.orgname = orgname;
		this.area = area;
		this.orgtype = orgtype;
		this.preorgcode = preorgcode;
		this.orgclass = orgclass;
		this.ismanastock = ismanastock;
		this.forgcode = forgcode;
		this.zborgcode = zborgcode;
		this.wlareacode = wlareacode;
		this.acclevel = acclevel;
		this.dbsvrname = dbsvrname;
		this.dbname = dbname;
		this.commmode = commmode;
		this.businessmode = businessmode;
		this.facecode = facecode;
		this.commpathout = commpathout;
		this.commpathin = commpathin;
		this.yhpri = yhpri;
		this.ismbzq = ismbzq;
		this.rkbjrate = rkbjrate;
		this.ckbjrate = ckbjrate;
		this.gqbjrate = gqbjrate;
		this.remark = remark;
		this.dbid = dbid;
		this.isenable = isenable;
		this.pricemode = pricemode;
		this.poscount = poscount;
		this.poscountverify = poscountverify;
		this.shorpgrade = shorpgrade;
		this.modalshop = modalshop;
		this.quotearea = quotearea;
		this.machineconfig = machineconfig;
		this.creditkzorgcode = creditkzorgcode;
		this.paygrpcode = paygrpcode;
	}

	// Property accessors

	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getInorgcode() {
		return this.inorgcode;
	}

	public void setInorgcode(String inorgcode) {
		this.inorgcode = inorgcode;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getPreorgcode() {
		return this.preorgcode;
	}

	public void setPreorgcode(String preorgcode) {
		this.preorgcode = preorgcode;
	}

	public String getOrgclass() {
		return this.orgclass;
	}

	public void setOrgclass(String orgclass) {
		this.orgclass = orgclass;
	}

	public String getIsmanastock() {
		return this.ismanastock;
	}

	public void setIsmanastock(String ismanastock) {
		this.ismanastock = ismanastock;
	}

	public String getForgcode() {
		return this.forgcode;
	}

	public void setForgcode(String forgcode) {
		this.forgcode = forgcode;
	}

	public String getZborgcode() {
		return this.zborgcode;
	}

	public void setZborgcode(String zborgcode) {
		this.zborgcode = zborgcode;
	}

	public String getWlareacode() {
		return this.wlareacode;
	}

	public void setWlareacode(String wlareacode) {
		this.wlareacode = wlareacode;
	}

	public String getAcclevel() {
		return this.acclevel;
	}

	public void setAcclevel(String acclevel) {
		this.acclevel = acclevel;
	}

	public String getDbsvrname() {
		return this.dbsvrname;
	}

	public void setDbsvrname(String dbsvrname) {
		this.dbsvrname = dbsvrname;
	}

	public String getDbname() {
		return this.dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getCommmode() {
		return this.commmode;
	}

	public void setCommmode(String commmode) {
		this.commmode = commmode;
	}

	public String getBusinessmode() {
		return this.businessmode;
	}

	public void setBusinessmode(String businessmode) {
		this.businessmode = businessmode;
	}

	public String getFacecode() {
		return this.facecode;
	}

	public void setFacecode(String facecode) {
		this.facecode = facecode;
	}

	public String getCommpathout() {
		return this.commpathout;
	}

	public void setCommpathout(String commpathout) {
		this.commpathout = commpathout;
	}

	public String getCommpathin() {
		return this.commpathin;
	}

	public void setCommpathin(String commpathin) {
		this.commpathin = commpathin;
	}

	public Integer getYhpri() {
		return this.yhpri;
	}

	public void setYhpri(Integer yhpri) {
		this.yhpri = yhpri;
	}

	public String getIsmbzq() {
		return this.ismbzq;
	}

	public void setIsmbzq(String ismbzq) {
		this.ismbzq = ismbzq;
	}

	public Double getRkbjrate() {
		return this.rkbjrate;
	}

	public void setRkbjrate(Double rkbjrate) {
		this.rkbjrate = rkbjrate;
	}

	public Double getCkbjrate() {
		return this.ckbjrate;
	}

	public void setCkbjrate(Double ckbjrate) {
		this.ckbjrate = ckbjrate;
	}

	public Double getGqbjrate() {
		return this.gqbjrate;
	}

	public void setGqbjrate(Double gqbjrate) {
		this.gqbjrate = gqbjrate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDbid() {
		return this.dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}

	public String getIsenable() {
		return this.isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}

	public String getPricemode() {
		return this.pricemode;
	}

	public void setPricemode(String pricemode) {
		this.pricemode = pricemode;
	}

	public Integer getPoscount() {
		return this.poscount;
	}

	public void setPoscount(Integer poscount) {
		this.poscount = poscount;
	}

	public String getPoscountverify() {
		return this.poscountverify;
	}

	public void setPoscountverify(String poscountverify) {
		this.poscountverify = poscountverify;
	}

	public String getShorpgrade() {
		return this.shorpgrade;
	}

	public void setShorpgrade(String shorpgrade) {
		this.shorpgrade = shorpgrade;
	}

	public String getModalshop() {
		return this.modalshop;
	}

	public void setModalshop(String modalshop) {
		this.modalshop = modalshop;
	}

	public String getQuotearea() {
		return this.quotearea;
	}

	public void setQuotearea(String quotearea) {
		this.quotearea = quotearea;
	}

	public String getMachineconfig() {
		return this.machineconfig;
	}

	public void setMachineconfig(String machineconfig) {
		this.machineconfig = machineconfig;
	}

	public String getCreditkzorgcode() {
		return this.creditkzorgcode;
	}

	public void setCreditkzorgcode(String creditkzorgcode) {
		this.creditkzorgcode = creditkzorgcode;
	}

	public String getPaygrpcode() {
		return this.paygrpcode;
	}

	public void setPaygrpcode(String paygrpcode) {
		this.paygrpcode = paygrpcode;
	}

}