package dv.sys.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dv.biz.WebUnitBiz;
import dv.sys.entity.WebUnit;
import dv.sys.queryProperties.QueryWebUnit;
import dv.util.Json;
import dv.util.Tree;

public class WebUnitAction extends BaseAction{
	private static final long serialVersionUID = -7769169621744081609L;
	private static final Logger logger = Logger.getLogger(WebRoleAction.class);
	private WebUnitBiz webUnitBiz;
	private List<WebUnit> webUnits;
	private QueryWebUnit queryWebUnit;//筛选条件
	private WebUnit webUnit; //接收页面的添加信息
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private String sort;//排序字段
	private String order;//排序顺序
	private String ids;//删除时的编号
	private String id;
	
	/**
	 * 加载部门树
	 * @return
	 * @throws Exception
	 */
	public String unitTree() throws Exception {
		List<WebUnit> list=webUnitBiz.getAllUnit(id);
		List<Tree> tree=new ArrayList<Tree>();
		for (WebUnit webUnit : list) {
			Tree node=new Tree();
			node.setId(webUnit.getUnitid());//节点的值
			node.setText(webUnit.getName());//节点上显示文本内容
			if (webUnit.getWebUnit()!=null) {
				node.setPid(webUnit.getWebUnit().getUnitid());//节点的父节点id
			}
			if (webUnit.getWebUnits()!=null&&webUnit.getWebUnits().size()!=0) {
				node.setState("closed");//节点状态，是否有子节点，如果有子节点，则是关闭状态，默认打开状态
			}
			tree.add(node);
		}
		writeJSONObject(listToJsonArray(tree));
		return NONE;
	}
	
	/**
	 * 显示列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		total=webUnitBiz.getUnitsTotal(queryWebUnit);
		webUnits=webUnitBiz.doSplitPage(page, rows, sort, order,queryWebUnit);//分页
		String s=modelBeanToJSON(new String[]{"webUnits","webUsers","hibernateLazyInitializer"}, webUnits, total);
		writeJSON(s);
		return NONE;
	}

	/**
	 * 增加部门信息
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		logger.info("执行添加部门操作：");
		Json json1 = new Json();
		try {
			webUnitBiz.addUnit(webUnit);// 添加角色
			json1.setSuccess(true);
			logger.info("添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			json1.setSuccess(false);
			json1.setMsg("添加失败!");
			logger.info("添加失败!原因：" + e.getMessage());
		}
		writeJSONObject(super.ObjectToJson(json1));// 输出json
		return NONE;
	}
	
	public String update() throws Exception {
		Json json1 = new Json();
		try {
			webUnit=webUnitBiz.updateUnit(webUnit);
			if (webUnit!=null) {
				json1.setSuccess(true);
				logger.info("修改成功!");
			}else{
				json1.setSuccess(false);
				json1.setMsg("修改失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json1.setSuccess(false);
			json1.setMsg("修改失败!");
			logger.info("修改失败!原因：" + e.getMessage());
		}
		writeJSONObject(super.ObjectToJson(json1));// 输出json
		return NONE;
	}
	
	/**
	 * 删除部门	
	 * @return	
	 * @throws Exception	
	 */
	public String delete() throws Exception {
		logger.info("执行删除角色操作：");
		Json json=new Json();
		try {
			logger.info("要删除的角色项目id："+ids);
			webUnitBiz.delUnit(ids);
			json.setSuccess(true);
			logger.info("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("删除失败!");
			logger.info("删除失败!原因："+e.getMessage());
		}
		writeJSONObject(super.ObjectToJson(json));		//输出json
		return NONE;
	}
	
	public QueryWebUnit getQueryWebUnit() {
		return queryWebUnit;
	}
	public void setQueryWebUnit(QueryWebUnit queryWebUnit) {
		this.queryWebUnit = queryWebUnit;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public WebUnitBiz getWebUnitBiz() {
		return webUnitBiz;
	}
	public void setWebUnitBiz(WebUnitBiz webUnitBiz) {
		this.webUnitBiz = webUnitBiz;
	}
	public int getPage() {
		return page;
	}
	public List<WebUnit> getWebUnits() {
		return webUnits;
	}
	public void setWebUnits(List<WebUnit> webUnits) {
		this.webUnits = webUnits;
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WebUnit getWebUnit() {
		return webUnit;
	}

	public void setWebUnit(WebUnit webUnit) {
		this.webUnit = webUnit;
	}
}
