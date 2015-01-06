package dv.sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dv.biz.WebUserBiz;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebUser;
import dv.util.Tree;

public class WebResourceAction extends BaseAction {
	private static final long serialVersionUID = 141228192468110369L;
	private String id;
	private WebUserBiz webUserBiz;

	/**
	 * 加载首页左侧的树
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		WebUser webUser = (WebUser) getSession().getAttribute("login");
		List<WebResource> list = webUserBiz.getUserResource(webUser,id,false);
		List<Tree> tree = new ArrayList<Tree>();
		if (list != null) {
			for (WebResource webResource : list) {
				Tree node = new Tree();
				node.setId(webResource.getResid());// 节点的值
				node.setText(webResource.getName());// 节点上显示文本内容
				if (webResource.getWebResource() != null) {
					node.setPid(webResource.getWebResource().getResid());// 节点的父节点id
				}
				if (webResource.getWebResources() != null&& webResource.getWebResources().size() != 0) {
					node.setState("closed");// 节点状态，是否有子节点，如果有子节点，则是关闭状态，默认打开状态
				}
				node.setIconCls(webResource.getIco());// 设置节点图标
				Map<String, String> attributes = new HashMap<String, String>();
				attributes.put("url", webResource.getUrl());// 设置节点url
				node.setAttributes(attributes);
				tree.add(node);
			}
		}
		writeJSON(this.listToJsonArray(tree));
		return NONE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WebUserBiz getWebUserBiz() {
		return webUserBiz;
	}

	public void setWebUserBiz(WebUserBiz webUserBiz) {
		this.webUserBiz = webUserBiz;
	}
}
