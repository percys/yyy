package dv.sys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import dv.biz.ExternalBiz;
import dv.sys.entity.TtotdzrptShnbjs;
import dv.sys.entity.TtotdzrptShwbjs;
import dv.sys.queryProperties.QueryInternalNbjs;
import dv.util.CsvUtil;

public class ExternalAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5771872288008009393L;
	
	private ExternalBiz externalbiz;
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private TtotdzrptShwbjs ttotdzrptShwbjs;//管理员外部门户对象
	private QueryInternalNbjs internb;//查询条件
	private String begindate;
	private String enddate;
	private String orgcode;
	
	/**	 * 显示根据页面传的对象来显示要显示的数据列表
	 */
	public String getAll()
	{
			total=externalbiz.getCommodityTotal(internb);//获得记录总条数
			List<TtotdzrptShwbjs> toto=new ArrayList<TtotdzrptShwbjs>();
			toto=externalbiz.doSplitPage(page, rows, internb);
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
		String str="";
		total=externalbiz.getCommodityTotal(internb);//获得记录总条数
		List<TtotdzrptShwbjs> toto=new ArrayList<TtotdzrptShwbjs>();
		toto=externalbiz.doSplitPage(page, rows, internb);
		str = CsvUtil.dvtlistToStrwb(toto);
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
	public QueryInternalNbjs getInternb() {
		return internb;
	}

	public void setInternb(QueryInternalNbjs internb) {
		this.internb = internb;
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

	public TtotdzrptShwbjs getTtotdzrptShwbjs() {
		return ttotdzrptShwbjs;
	}

	public void setTtotdzrptShwbjs(TtotdzrptShwbjs ttotdzrptShwbjs) {
		this.ttotdzrptShwbjs = ttotdzrptShwbjs;
	}
	
	public ExternalBiz getExternalbiz() {
		return externalbiz;
	}

	public void setExternalbiz(ExternalBiz externalbiz) {
		this.externalbiz = externalbiz;
	}

}
