package dv.sys.entity;

/**
 * Ttotdzrpt entity. @author MyEclipse Persistence Tools
 */

public class Ttotdzrpt implements java.io.Serializable {

	// Fields

	private Long tid;
	private String entid;
	private String rptdate;
	private String orgcode;
	private String orgname;
	private Double qctotal;
	private Double pstotal;
	private Double thtotal;
	private Double dbtotal;
	private Double bstotal;
	private Double qmtotal;
	private Double xstotalA;
	private Double sunhaototal;
	private Double xstotalB;
	private Double xstotalDiff;
	private Double xsyjtotal;
	private Double savetotal;
	private Double sstotal;
	private Double zjtotal;
	private Double jktotal;
	private Double cqtotal;
	private Double zctotal;

	// Constructors

	/** default constructor */
	public Ttotdzrpt() {
	}

	/** full constructor */
	public Ttotdzrpt(String entid, String rptdate, String orgcode,
			String orgname, Double qctotal, Double pstotal, Double thtotal,
			Double dbtotal, Double bstotal, Double qmtotal, Double xstotalA,
			Double sunhaototal, Double xstotalB, Double xstotalDiff,
			Double xsyjtotal, Double savetotal, Double sstotal, Double zjtotal,
			Double jktotal, Double cqtotal, Double zctotal) {
		this.entid = entid;
		this.rptdate = rptdate;
		this.orgcode = orgcode;
		this.orgname = orgname;
		this.qctotal = qctotal;
		this.pstotal = pstotal;
		this.thtotal = thtotal;
		this.dbtotal = dbtotal;
		this.bstotal = bstotal;
		this.qmtotal = qmtotal;
		this.xstotalA = xstotalA;
		this.sunhaototal = sunhaototal;
		this.xstotalB = xstotalB;
		this.xstotalDiff = xstotalDiff;
		this.xsyjtotal = xsyjtotal;
		this.savetotal = savetotal;
		this.sstotal = sstotal;
		this.zjtotal = zjtotal;
		this.jktotal = jktotal;
		this.cqtotal = cqtotal;
		this.zctotal = zctotal;
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

	public Double getDbtotal() {
		return this.dbtotal;
	}

	public void setDbtotal(Double dbtotal) {
		this.dbtotal = dbtotal;
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

	public Double getXsyjtotal() {
		return this.xsyjtotal;
	}

	public void setXsyjtotal(Double xsyjtotal) {
		this.xsyjtotal = xsyjtotal;
	}

	public Double getSavetotal() {
		return this.savetotal;
	}

	public void setSavetotal(Double savetotal) {
		this.savetotal = savetotal;
	}

	public Double getSstotal() {
		return this.sstotal;
	}

	public void setSstotal(Double sstotal) {
		this.sstotal = sstotal;
	}

	public Double getZjtotal() {
		return this.zjtotal;
	}

	public void setZjtotal(Double zjtotal) {
		this.zjtotal = zjtotal;
	}

	public Double getJktotal() {
		return this.jktotal;
	}

	public void setJktotal(Double jktotal) {
		this.jktotal = jktotal;
	}

	public Double getCqtotal() {
		return this.cqtotal;
	}

	public void setCqtotal(Double cqtotal) {
		this.cqtotal = cqtotal;
	}

	public Double getZctotal() {
		return this.zctotal;
	}

	public void setZctotal(Double zctotal) {
		this.zctotal = zctotal;
	}

}