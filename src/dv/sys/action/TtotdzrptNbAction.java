package dv.sys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dv.biz.TtotdzrptNbBiz;
import dv.sys.entity.TtotdzrptNb;
import dv.sys.queryProperties.QueryInternalNbjs;
import dv.util.CsvUtil;

public class TtotdzrptNbAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TtotdzrptNbBiz totdzrptNbBiz;
	public TtotdzrptNbBiz getTotdzrptNbBiz() {
		return totdzrptNbBiz;
	}
	public void setTotdzrptNbBiz(TtotdzrptNbBiz totdzrptNbBiz) {
		this.totdzrptNbBiz = totdzrptNbBiz;
	}
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private TtotdzrptNb totdzrptnb;//管理员内部门户对象
	private QueryInternalNbjs ttotdzrpt;//此查询类都可用
	private String begindate;
	private String enddate;
	private String orgcode;
	
	/**	 
	 * 显示根据页面传的对象来显示要显示的数据列表
	 */
	public String getAll()
	{
		
		//获得记录总条数
		total=totdzrptNbBiz.getCommodityTotal(ttotdzrpt);
		List<TtotdzrptNb> toto=new ArrayList<TtotdzrptNb>();
		toto=totdzrptNbBiz.doSplitPage(page, rows, ttotdzrpt);
		//"handler"
		String s=modelBeanToJSON(new String[]{"acc1","hibernateLazyInitializer"}, toto, total);
		System.out.println(s);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	/**
	 * csv导出数据
	 * @return
	 */
	public String csv()
	{
		String str="";
		total=totdzrptNbBiz.getCommodityTotal(ttotdzrpt);//获得记录总条数
		List<TtotdzrptNb> toto=new ArrayList<TtotdzrptNb>();
		toto=totdzrptNbBiz.doSplitPage(page, rows, ttotdzrpt);
		str = CsvUtil.dvtlistToStrnbjm(toto);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("GBK");
		resp.setContentType("text/csv;charset=GBK");
		String filename = "dvt_" + new Date().toLocaleString() + ".csv";
		resp.setHeader("Content-disposition", "attachment;filename="+ filename);
		try {
			PrintWriter out = resp.getWriter();
			out.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public TtotdzrptNb getTotdzrptnb() {
		return totdzrptnb;
	}
	public void setTotdzrptnb(TtotdzrptNb totdzrptnb) {
		this.totdzrptnb = totdzrptnb;
	}
	public QueryInternalNbjs getTtotdzrpt() {
		return ttotdzrpt;
	}
	public void setTtotdzrpt(QueryInternalNbjs ttotdzrpt) {
		this.ttotdzrpt = ttotdzrpt;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	};

}
