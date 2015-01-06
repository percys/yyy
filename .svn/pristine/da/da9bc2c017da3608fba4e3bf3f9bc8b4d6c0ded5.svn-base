package dv.sys.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonBeanProcessor;
import net.sf.json.util.PropertyFilter;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = -3011859870039120904L;
	private static final Logger logger = Logger.getLogger(BaseAction.class);

	/**
	 * 获得request
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获得response
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获得session
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public void writeJSON(String json) throws Exception {
		logger.info("转换后的JSON字符串：" + json);
		getResponse().setContentType("text/html;charset=utf-8");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setHeader("cache-control", "no-cache");
		getResponse().setHeader("expires", "0");
		getResponse().getWriter().write(json);
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
	}
	
	public void writeJSONObject(String json) throws Exception {
		logger.info("转换后的JSON对象字符串：" + json);
		getResponse().setContentType("text/json;charset=utf-8");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setHeader("cache-control", "no-cache");
		getResponse().setHeader("expires", "0");
		getResponse().getWriter().write(json);
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
	}

	/**
	 * 把list转化成json数组
	 * @param list
	 * @return
	 */
	public String listToJsonArray(List<?> list) {
		logger.info("开始转换JSON数组");
		JSONArray jsonArr = JSONArray.fromObject(list);
		return jsonArr.toString();
	}
	/**
	 * 把list转化成json数组
	 * @param list
	 * @return
	 */
	public String listToJsonArray(final String[] filterFields, List<?> list) {
		logger.info("开始转换符合combobox的json字符串");
		String exclude="";
		for (String str : filterFields) {
			exclude=exclude+str+"  ";
		}
		logger.info("要过滤的属性：" + exclude);
		JsonConfig config = new JsonConfig();
		config.registerJsonBeanProcessor(Date.class,new JsDateJsonBeanProcessor());
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				for (String exclode : filterFields) {
					if (exclode.equals(name)) {
						return true;
					}
				}
				return false;
			}
		});
		JSONArray jsonArr = JSONArray.fromObject(list, config);
		return jsonArr.toString();
	}
	/**
	 * 转化对象为json格式
	 * @param json
	 * @return
	 */
	public String ObjectToJson(Object obj) {
		logger.info("开始转换JSON对象");
		JSONObject jsonObject= JSONObject.fromObject(obj);
		return jsonObject.toString();
	}

	/**
	 * 过滤掉指定的属性,返回符合easyui griddata类型的数据
	 * 
	 * @param filterField
	 *            需要过滤的属性
	 * @param list
	 *            原始列表
	 * @return
	 */
	public String modelBeanToJSON(final String[] filterFields, List<?> list, Long total) {
		logger.info("开始转换符合datagrid的json字符串");
		String exclude="";
		for (String str : filterFields) {
			exclude=exclude+str+"  ";
		}
		logger.info("要过滤的属性：" + exclude);
		JsonConfig config = new JsonConfig();
		config.registerJsonBeanProcessor(Date.class,new JsDateJsonBeanProcessor());
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				// 配置需要过滤的属性
				for (String exclode : filterFields) {
					if (exclode.equals(name)) {
						return true;
					}
				}
				return false;
			}
		});
		// 调用ExtHelper将你的JSONConfig传递过去
		JSONArray JsonArr = JSONArray.fromObject(list, config);
		StringBuffer buf = new StringBuffer();
		buf.append("{\"total\":");
		buf.append(total);
		buf.append(",\"rows\":");
		buf.append(JsonArr.toString());
		buf.append("}");
		return buf.toString();
	}
}
