package dv.sys.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import dv.biz.WebResourceBiz;
import dv.biz.WebRoleBiz;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebRole;
import dv.util.Json;
import dv.util.Tree;

public class WebRoleAction extends BaseAction {
	private static final long serialVersionUID = 3493591241458205380L;
	private static final Logger logger = Logger.getLogger(WebRoleAction.class);
	private WebRoleBiz webRoleBiz;
	private WebResourceBiz webResourceBiz;
	private List<WebRole> webRoles;
	private WebRole webRole;//接收页面的参数信息
	private QueryWebRole queryWebRole;//接收页面的查询参数
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private String sort;//排序字段
	private String order;//排序顺序
	private String ids;
	private String quanxians;// 添加角色的权限名，JSON字符串
	private String id;
	private WebUser webUser;
	/**
	 * 获得所有角色信息，返回json字符串
	 * @return
	 * @throws Exception
	 */
	public String getAllRole() throws Exception {
		webRoles=webRoleBiz.getAllRole(null);
		writeJSON(listToJsonArray(new String[]{"webUsers","webResources","hibernateLazyInitializer"}, webRoles));
		return NONE;
	}

	public String resouce() throws Exception {
		List<WebResource> list=webResourceBiz.getAllResource(id);
		List<Tree> tree=new ArrayList<Tree>();
		for (WebResource webResource : list) {
			Tree node=new Tree();
			node.setId(webResource.getResid());//节点的值
			node.setText(webResource.getName());//节点上显示文本内容
			if (webResource.getWebResource()!=null) {
				node.setPid(webResource.getWebResource().getResid());//节点的父节点id
			}
			if (webResource.getWebResources()!=null&&webResource.getWebResources().size()!=0) {
				node.setState("closed");//节点状态，是否有子节点，如果有子节点，则是关闭状态，默认打开状态
			}
			node.setIconCls(webResource.getIco());//设置节点图标
			tree.add(node);
		}
		writeJSONObject(listToJsonArray(tree));
		return NONE;
	}
	
	public String list() throws Exception {
		total=webRoleBiz.getRoleTotal(queryWebRole);
		webRoles=webRoleBiz.doSplitPage(page, rows, sort, order, queryWebRole);
		//webUsers、webResources是需要过滤的
		String s=modelBeanToJSON(new String[]{"webUsers","webResources","hibernateLazyInitializer"}, webRoles,total);
		writeJSON(s);
		return NONE;
	}

	public String add() throws Exception {
		WebResource resource = null;
		logger.info("执行添加角色操作：");
		Json json1 = new Json();
		String[] resources = quanxians.split(",");// 分割字符串,批量添加
		Set<WebResource> webResources = new HashSet<WebResource>(0);
		for (String resid : resources) {
			resource = webResourceBiz.getResourceById(resid);
			resource.getWebRoles().add(webRole);
			webResources.add(resource);// 将资源添加至资源集合
		}
		webRole.setWebResources(webResources);// 将资源集合添加至角色
		try {
			logger.info("要添加的角色名称:"+webRole.getName());
			webRoleBiz.addRole(webRole);// 添加角色
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
	
	public String delete() throws Exception {
		logger.info("执行删除角色操作：");
		Json json=new Json();
		try {
			logger.info("要删除的角色项目id："+ids);
			webRoleBiz.delRole(ids);
			json.setSuccess(true);
			logger.info("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("删除失败!");
			logger.info("删除失败!原因："+e.getMessage());
		}
		writeJSONObject(super.ObjectToJson(json));//输出json
		return NONE;
	}
	
	public String ResouceById() throws Exception {
		List<WebResource> allResource=webResourceBiz.getAllResource(id);
		List<WebResource> myResource=webRoleBiz.getResourceById(webRole.getRoleid());
		List<Tree> tree=new ArrayList<Tree>();
		for (WebResource webResource : allResource) {
			Tree node=new Tree();
			node.setId(webResource.getResid());//节点的值
			node.setText(webResource.getName());//节点上显示文本内容
			if (webResource.getWebResource()!=null) {
				node.setPid(webResource.getWebResource().getResid());//节点的父节点id
			}
			if (webResource.getWebResources()!=null&&webResource.getWebResources().size()!=0) {
				node.setState("closed");//节点状态，是否有子节点，如果有子节点，则是关闭状态，默认打开状态
			}
			if (myResource.contains(webResource)) {
				node.setChecked(true);
			}
			node.setIconCls(webResource.getIco());//设置节点图标
			tree.add(node);
		}
		writeJSON(this.listToJsonArray(tree));
		return NONE;
	}

	public String updateOld() throws Exception {
		WebResource resource = null;
		webRole=webRoleBiz.getRole(webRole.getRoleid());
		logger.info("执行修改角色操作："+webRole.getName());
		Json json1 = new Json();
		String[] resources = quanxians.split(",");// 分割字符串,批量添加
		Set<WebResource> webResources = new HashSet<WebResource>(0);
		for (String resid : resources) {
			resource = webResourceBiz.getResourceById(resid);
			resource.getWebRoles().add(webRole);
			webResources.add(resource);// 将资源添加至资源集合
		}
		webRole.setWebResources(webResources);// 将资源集合添加至角色
		try {
			logger.info("要修改的角色项目");
			webRoleBiz.updateRole(webRole);// 添加角色
			json1.setSuccess(true);
			logger.info("修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			json1.setSuccess(false);
			json1.setMsg("修改失败!");
			logger.info("修改失败!原因：" + e.getMessage());
		}
		writeJSONObject(super.ObjectToJson(json1));// 输出json
		return NONE;
	}
	
	public String getUserRoles() throws Exception {
		webRoles=webRoleBiz.getAllRole(webUser);
		writeJSON(listToJsonArray(new String[]{"webUsers","webResources","hibernateLazyInitializer"}, webRoles));
		return NONE;
	}
	
	public WebRoleBiz getWebRoleBiz() {
		return webRoleBiz;
	}

	public void setWebRoleBiz(WebRoleBiz webRoleBiz) {
		this.webRoleBiz = webRoleBiz;
	}

	public List<WebRole> getWebRoles() {
		return webRoles;
	}

	public void setWebRoles(List<WebRole> webRoles) {
		this.webRoles = webRoles;
	}

	public WebRole getWebRole() {
		return webRole;
	}

	public void setWebRole(WebRole webRole) {
		this.webRole = webRole;
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

	public QueryWebRole getQueryWebRole() {
		return queryWebRole;
	}

	public void setQueryWebRole(QueryWebRole queryWebRole) {
		this.queryWebRole = queryWebRole;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getQuanxians() {
		return quanxians;
	}

	public void setQuanxians(String quanxians) {
		this.quanxians = quanxians;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WebResourceBiz getWebResourceBiz() {
		return webResourceBiz;
	}

	public void setWebResourceBiz(WebResourceBiz webResourceBiz) {
		this.webResourceBiz = webResourceBiz;
	}

	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}
}
