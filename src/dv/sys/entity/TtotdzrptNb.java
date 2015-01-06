package dv.sys.entity;

/**
 * TtotdzrptNb entity. @author MyEclipse Persistence Tools
 */

public class TtotdzrptNb implements java.io.Serializable {

	// Fields

	private Long tid;
	private String entid;
	private String rptdate;
	private String orgcode;
	private String orgname;
	private Double qctotal;
	private Double pstotal;
	private Double thtotal;
	private Double bstotal;
	private Double qmtotal;
	private Double xstotalA;
	private Double sunhaototal;
	private Double xstotalB;
	private Double xstotalDiff;
	private Double kdtotal;
	private Double gqtotal;
	private Double mdzl;
	private Double hdtotal;

	// Constructors

	/** default constructor */
	public TtotdzrptNb() {
	}

	/** full constructor */
	public TtotdzrptNb(Long tid, String entid, String rptdate, String orgcode,
			String orgname, Double qctotal, Double pstotal, Double thtotal,
			Double bstotal, Double qmtotal, Double xstotalA,
			Double sunhaototal, Double xstotalB, Double xstotalDiff,
			Double kdtotal, Double gqtotal, Double mdzl, Double hdtotal) {
		this.tid = tid;
		this.entid = entid;
		this.rptdate = rptdate;
		this.orgcode = orgcode;
		this.orgname = orgname;
		this.qctotal = qctotal;
		this.pstotal = pstotal;
		this.thtotal = thtotal;
		this.bstotal = bstotal;
		this.qmtotal = qmtotal;
		this.xstotalA = xstotalA;
		this.sunhaototal = sunhaototal;
		this.xstotalB = xstotalB;
		this.xstotalDiff = xstotalDiff;
		this.kdtotal = kdtotal;
		this.gqtotal = gqtotal;
		this.mdzl = mdzl;
		this.hdtotal = hdtotal;
	}

	// Property accessors

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getEntid() {
		return this.entid;
	}

	public void setEntid(String entid) {
		this.entid = entid;
	}

	public String getRptdate() {
		return this.rptdate;
	}

	public void setRptdate(String rptdate) {
		this.rptdate = rptdate;
	}

	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Double getQctotal() {
		return this.qctotal;
	}

	public void setQctotal(Double qctotal) {
		this.qctotal = qctotal;
	}

	public Double getPstotal() {
		return this.pstotal;
	}

	public void setPstotal(Double pstotal) {
		this.pstotal = pstotal;
	}

	public Double getThtotal() {
		return this.thtotal;
	}

	public void setThtotal(Double thtotal) {
		this.thtotal = thtotal;
	}

	public Double getBstotal() {
		return this.bstotal;
	}

	public void setBstotal(Double bstotal) {
		this.bstotal = bstotal;
	}

	public Double getQmtotal() {
		return this.qmtotal;
	}

	public void setQmtotal(Double qmtotal) {
		this.qmtotal = qmtotal;
	}

	public Double getXstotalA() {
		return this.xstotalA;
	}

	public void setXstotalA(Double xstotalA) {
		this.xstotalA = xstotalA;
	}

	public Double getSunhaototal() {
		return this.sunhaototal;
	}

	public void setSunhaototal(Double sunhaototal) {
		this.sunhaototal = sunhaototal;
	}

	public Double getXstotalB() {
		return this.xstotalB;
	}

	public void setXstotalB(Double xstotalB) {
		this.xstotalB = xstotalB;
	}

	public Double getXstotalDiff() {
		return this.xstotalDiff;
	}

	public void setXstotalDiff(Double xstotalDiff) {
		this.xstotalDiff = xstotalDiff;
	}

	public Double getKdtotal() {
		return this.kdtotal;
	}

	public void setKdtotal(Double kdtotal) {
		this.kdtotal = kdtotal;
	}

	public Double getGqtotal() {
		return this.gqtotal;
	}

	public void setGqtotal(Double gqtotal) {
		this.gqtotal = gqtotal;
	}

	public Double getMdzl() {
		return this.mdzl;
	}

	public void setMdzl(Double mdzl) {
		this.mdzl = mdzl;
	}

	public Double getHdtotal() {
		return this.hdtotal;
	}

	public void setHdtotal(Double hdtotal) {
		this.hdtotal = hdtotal;
	}

}