package dv.sys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dv.biz.TtotdzrptBiz;
import dv.sys.entity.Ttotdzrpt;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.queryProperties.QueryInternalNbjs;
import dv.util.CsvUtil;

public class TtotdzrptAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4562003174261089083L;
	private TtotdzrptBiz totdzrptBiz;//Spring注入的管理员内部门户
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private Ttotdzrpt totdzrpt;//管理员内部门户对象
	private QueryInternalNbjs internb;
	private String begindate;
	private String enddate;
	private String orgcode;
	
	
	/**	 * 显示根据页面传的对象来显示要显示的数据列表
	 */
	public String getAll()
	{
			total=totdzrptBiz.getCommodityTotal(internb);//获得记录总条数
			List<Ttotdzrpt> toto=new ArrayList<Ttotdzrpt>();
			toto=totdzrptBiz.doSplitPage(page, rows, internb);
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
		
	};
	
	/**
	 * csv导出数据
	 * @return
	 */
	public String csv()
	{
		internb=new QueryInternalNbjs();
		internb.setBeginDate(begindate);
		internb.setEndDate(enddate);
		internb.setOrgcode(orgcode);
		String str="";
		total=totdzrptBiz.getCommodityTotal(internb);//获得记录总条数
		List<Ttotdzrpt> toto=new ArrayList<Ttotdzrpt>();
		toto=totdzrptBiz.doSplitPage(page, rows, internb);
		str = CsvUtil.dvtlistToStrzy(toto);
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
	};
	
	
	
	
	
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
	}
	public Ttotdzrpt getTotdzrpt() {
		return totdzrpt;
	}
	
	public void setTotdzrpt(Ttotdzrpt totdzrpt) {
		this.totdzrpt = totdzrpt;
	}
	
	public TtotdzrptBiz getTotdzrptBiz() {
		return totdzrptBiz;
	}
	public void setTotdzrptBiz(TtotdzrptBiz totdzrptBiz) {
		this.totdzrptBiz = totdzrptBiz;
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

	public QueryInternalNbjs getInternb() {
		return internb;
	}

	public void setInternb(QueryInternalNbjs internb) {
		this.internb = internb;
	}
}
