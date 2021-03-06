package dv.sys.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import dv.biz.MailBoxBiz;
import dv.biz.WebRoleBiz;
import dv.biz.WebUnitBiz;
import dv.biz.WebUserBiz;
import dv.sys.entity.Torgmanage;
import dv.sys.entity.Tusruser;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebRole;
import dv.sys.entity.WebUser;
import dv.sys.queryProperties.QueryWebUser;
import dv.util.Json;
import dv.util.RandomNumUtil;

public class WebUserAction extends BaseAction {
	private static final long serialVersionUID = 3370673446409457338L;
	private static final Logger logger = Logger.getLogger(WebUserAction.class);
	private WebUserBiz webUserBiz;//用户服务层接口
	private WebUnitBiz webUnitBiz;//部门服务层接口
	private WebRoleBiz webRoleBiz;//角色服务层接口
	private WebUser webUser;
	private String oldPwd;//原始密码
	private String pwd;//要修改的密码
	private String rePwd;//重复密码
	private List<WebRole> webRoles;//用户拥有的角色
	private List<WebResource> webResources;//用户可以访问的资源
	private List<WebUser> webUsers;
	private int page;//要显示的页数
	private int rows;//显示的数据大小
	private Long total;//总记录数
	private String sort;//排序字段
	private String order;//排序顺序
	private String ids;//删除时的编号
	private QueryWebUser queryWebUser;//查询用的属性类
	private String roles;
	private List<Torgmanage> tor;
	private Torgmanage manage;//门店编码对象
	private List<Tusruser> tuser;//查询员工工号
	private List torlist;//用于查询user表id最大值
	private String max;
	private Integer num;	
	private ByteArrayInputStream inputStream;//验证码

	// 生成验证码方法
    public String getlist() throws Exception {
        RandomNumUtil rdnu = RandomNumUtil.Instance();
        this.setInputStream(rdnu.getImage());// 取得带有随机字符串的图片
        ActionContext.getContext().getSession().put("random", rdnu.getString());// 取得随机字符串放入HttpSession
        System.out.println("验证码生成的数字***************************"+rdnu.getString());
        return "check";
    }
	
	/**
	 * 用户登出系统
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		total=webUserBiz.getUserTotal(queryWebUser);
		webUsers=webUserBiz.doSplitPage(page, rows, sort, order, queryWebUser);
		//,"webResources","handler"
		writeJSON(modelBeanToJSON(new String[]{"webRoles","webUsers","webUnits","hibernateLazyInitializer"}, webUsers, total));
		return NONE;
	}
	
	/**
	 * 门店编码查询
	 * @return
	 * @throws Exception
	 */
	public String getOrgCode() throws Exception{
		tor=webUserBiz.getOrgCode(null);
		writeJSON(listToJsonArray(tor));
		return NONE;
	}
	/**
	 * 查询编辑用户所属门店
	 * @return
	 * @throws Exception
	 */
	public String getUserOrgCode() throws Exception{
		tor=webUserBiz.getOrgCode(webUser);
		writeJSON(listToJsonArray(tor));
		return NONE;
	}
	
	/**
	 * 添加用户
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Json json=new Json();
		//判断是否有此用户id，没有则继续保存，否则返回并提示信息
//		WebUser user=webUserBiz.getUserAgentId(webUser);
//		if (user!=null) {
//			json.setSuccess(false);
//			json.setMsg("添加用户失败!此员工id已存在!");
//			writeJSONObject(super.ObjectToJson(json));//输出json
//			return NONE;
//		}
		//首先验证增加的员工工号是否是公司员工 
		tuser=webUserBiz.getCheckGh(webUser);
		if(tuser.size()==0){
			json.setSuccess(false);
			json.setMsg("未找到此员工工号,请确认!");
			writeJSONObject(super.ObjectToJson(json));//输出json
			return NONE;
		}
		//找到门店
		manage=webUserBiz.getCode(manage);
		Set<WebRole> tempWebRoles=new HashSet<WebRole>();
		String[] rolesids=roles.split(",");
		WebRole tempRole=null;
		for (String rolesid : rolesids) {
			tempRole=webRoleBiz.getRole(rolesid);
			tempWebRoles.add(tempRole);
		}
		webUser.setOrgcode(manage.getOrgcode());
		webUser.setOrgname(manage.getOrgname());
		webUser.setIsuse("T");
		webUser.setWebRoles(tempWebRoles);
		webUser.setBz(tempRole.getName());
		//如果业务管理员增加系统管理员或业务管理员，不能添加
		if(((WebUser) getSession().getAttribute("login")).getBz().equals("业务管理员")){
			if(webUser.getBz().equals("系统管理员")){
				json.setSuccess(false);
				json.setMsg("您没有权限添加系统管理员!");
			}else if(webUser.getBz().equals("业务管理员")){
				json.setSuccess(false);
				json.setMsg("您没有权限添加业务管理员!");
			}
		}else{
			//Bz字段一定要在此处set，否则不能准确业务员修改的是否是系统管理员，必须在判断之后赋值
			webUser.setBz(tempRole.getName());
			webUser=webUserBiz.saveWebUser(webUser);
			if (webUser!=null) {
				json.setSuccess(true);
				json.setMsg("添加用户成功!");
			}else{
				json.setSuccess(false);
				json.setMsg("添加用户失败!");
			}
		}
		writeJSONObject(super.ObjectToJson(json));//输出json
		return NONE;
	}
	
	/**
	 * 修改用户
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		Json json=new Json();
		Set<WebRole> tempWebRoles=new HashSet<WebRole>();
		System.out.println(roles);
		String[] rolesids=roles.split(",");
		WebRole tempRole=null;
		for (String rolesid : rolesids) {
			tempRole=webRoleBiz.getRole(rolesid.trim());
			tempRole.getWebUsers().add(webUser);
			tempWebRoles.add(tempRole);
		}
		webUser.setWebRoles(tempWebRoles);
		//找到门店
		manage=webUserBiz.getCode(manage);
		webUser.setOrgcode(manage.getOrgcode());
		webUser.setOrgname(manage.getOrgname());
		//如果业务管理员增加系统管理员，不能添加
		if(((WebUser) getSession().getAttribute("login")).getBz().equals("业务管理员")){
			if(tempRole.getName().equals("系统管理员")){
				json.setSuccess(false);
				json.setMsg("您没有权限修改系统管理员!");
				writeJSONObject(super.ObjectToJson(json));//输出json
				return NONE;
			}else if(tempRole.getName().equals("业务管理员")){
				json.setSuccess(false);
				json.setMsg("您没有权限修改业务管理员!");
				writeJSONObject(super.ObjectToJson(json));//输出json
				return NONE;
			}
		}else{
			//Bz字段一定要在此处set，否则不能准确业务员修改的是否是系统管理员，必须在判断之后赋值
			webUser.setBz(tempRole.getName());
			webUser=webUserBiz.saveWebUser(webUser);
			if (webUser!=null) {
				json.setSuccess(true);
				json.setMsg("添加用户成功!");
			}else{
				json.setSuccess(false);
				json.setMsg("添加用户失败!");
			}
		}
		writeJSONObject(super.ObjectToJson(json));//输出json
		return NONE;
	}
	
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		logger.info("执行删除角色操作：");
		Json json=new Json();
		try {
			logger.info("要删除的角色项目id："+ids);
			String[] userids=ids.split(",");
			webUser=new WebUser();
			webUsers=new ArrayList<WebUser>();
			for (String userid : userids) {//判断删除用户是否存在管理员
				webUser=webUserBiz.getWebUserid(userid);
				if(webUser.getBz().equals("系统管理员")){
					json.setSuccess(false);
					json.setMsg("您没有权限删除系统管理员,请重新核对!");
					writeJSONObject(super.ObjectToJson(json));//输出json
					return NONE;
				}else if(webUser.getBz().equals("业务管理员")){
					json.setSuccess(false);
					json.setMsg("您没有权限删除业务管理员,请重新核对!");
					writeJSONObject(super.ObjectToJson(json));//输出json
					return NONE;
				}
				webUsers.add(webUser);//保存集合
			}
			for (int i = 0; i < webUsers.size(); i++) {//不存在删除
				webUserBiz.delUser(webUsers.get(i));
			}
			json.setSuccess(true);
			json.setMsg("删除成功!");
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
	private String txtcode;
	
	public String getTxtcode() {
		return txtcode;
	}
	public void setTxtcode(String txtcode) {
		this.txtcode = txtcode;
	}
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		logger.info("用户开始登录");
		Json json=new Json();
		String random = (String) ActionContext.getContext().getSession().get("random");
		if (random.equals(txtcode)) {//验证验证码
			String password=webUser.getPassword();
			webUser=webUserBiz.getWebUser(webUser.getUsername());
			if(webUser!=null){
				if (webUser.getPassword().equals(password)) {
					getSession().setAttribute("login", webUser);//存放用户信息到session中
					logger.info("用户"+webUser.getUsername()+"登录成功!");
					json.setSuccess(true);
				}else{
					json.setSuccess(false);
					json.setMsg("用户名或密码错误!");
				}
			}
		}else{
			json.setSuccess(false);
			json.setMsg("验证码错误!");
		}
		writeJSONObject(super.ObjectToJson(json));//输出json
		return NONE;
	}
	
	/**
	 * 用户登出系统
	 * @return
	 * @throws Exception
	 */
	public String exit() throws Exception {
		getSession().setAttribute("login", null);
		return LOGIN;
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws Exception
	 */
	public String editPwd() throws Exception {
		Json json=new Json();
		webUser=webUserBiz.getWebUser(((WebUser) getSession().getAttribute("login")).getUsername());
		if (!webUser.getPassword().equals(oldPwd)) {
			json.setSuccess(false);
			json.setMsg("原始密码不正确!");
		}else{
			webUser.setPassword(pwd);
			webUserBiz.saveWebUser(webUser);
			logger.info("用户"+webUser.getUsername()+"修改密码成功!");
			json.setSuccess(true);
			json.setMsg("修改密码成功!");
		}
		writeJSONObject(super.ObjectToJson(json));//输出json
		return NONE;
	}
	
	/**
	 * 查看用户个人信息
	 * @return
	 * @throws Exception
	 */
	public String info() throws Exception {
		webUser=webUserBiz.getWebUser(((WebUser) getSession().getAttribute("login")).getUsername());
		webResources=webUserBiz.getUserResource(webUser,null,true);
		webRoles=webUserBiz.getUserRole(webUser);
		return "info";
	}
	private String agentId;
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String valid() throws Exception {
		Json json=new Json();
		//首先验证增加的员工工号是否是公司员工 
//		webUser=new WebUser();
//		webUser.setAgentId(agentId);
		tuser=webUserBiz.getCheckGh(webUser);
		if(tuser.size()==0){
			json.setSuccess(false);
			json.setMsg("未找到此员工工号,请确认!");
			writeJSONObject(super.ObjectToJson(json));//输出json
			return NONE;
		}
		writeJSON(listToJsonArray(tuser));//输出json
		//找到门店
		return NONE;
	}
	//get/set...

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public List getTorlist() {
		return torlist;
	}

	public void setTorlist(List torlist) {
		this.torlist = torlist;
	}

	public List<Tusruser> getTuser() {
		return tuser;
	}

	public void setTuser(List<Tusruser> tuser) {
		this.tuser = tuser;
	}

	public Torgmanage getManage() {
		return manage;
	}

	public void setManage(Torgmanage manage) {
		this.manage = manage;
	}

	public List<Torgmanage> getTor() {
		return tor;
	}

	public void setTor(List<Torgmanage> tor) {
		this.tor = tor;
	}

	public WebUserBiz getWebUserBiz() {
		return webUserBiz;
	}

	public void setWebUserBiz(WebUserBiz webUserBiz) {
		this.webUserBiz = webUserBiz;
	}
	
	public WebUser getWebUser() {
		return webUser;
	}

	public void setWebUser(WebUser webUser) {
		this.webUser = webUser;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}

	public List<WebRole> getWebRoles() {
		return webRoles;
	}

	public void setWebRoles(List<WebRole> webRoles) {
		this.webRoles = webRoles;
	}

	public List<WebResource> getWebResources() {
		return webResources;
	}

	public void setWebResources(List<WebResource> webResources) {
		this.webResources = webResources;
	}

	public List<WebUser> getWebUsers() {
		return webUsers;
	}

	public void setWebUsers(List<WebUser> webUsers) {
		this.webUsers = webUsers;
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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public QueryWebUser getQueryWebUser() {
		return queryWebUser;
	}

	public void setQueryWebUser(QueryWebUser queryWebUser) {
		this.queryWebUser = queryWebUser;
	}

	public WebUnitBiz getWebUnitBiz() {
		return webUnitBiz;
	}

	public void setWebUnitBiz(WebUnitBiz webUnitBiz) {
		this.webUnitBiz = webUnitBiz;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public WebRoleBiz getWebRoleBiz() {
		return webRoleBiz;
	}

	public void setWebRoleBiz(WebRoleBiz webRoleBiz) {
		this.webRoleBiz = webRoleBiz;
	}
}
