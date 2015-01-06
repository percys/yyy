package dv.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dv.biz.WebUserBiz;
import dv.sys.entity.WebResource;
import dv.sys.entity.WebUser;

public class FilterServlet extends HttpServlet implements Filter {
	private static final long serialVersionUID = 8695084834796044225L;
	private static Logger logger = Logger.getLogger(FilterServlet.class);
	private WebUserBiz webUserBiz;
  
    /**
     * 重定向的URL
     */
    private String redirectURl = null;
  
    public void init(FilterConfig filterConfig) throws ServletException {
        // 指定要重定向的页面
        redirectURl = "login.jsp";
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        webUserBiz=(WebUserBiz) context.getBean("webUserBiz");
    }

    /**
     * 在过滤器中实现权限控制
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,   
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri=request.getRequestURI();
        if (uri.indexOf("sys")==-1) {
        	uri=uri.substring(uri.lastIndexOf("/"));
        	if (uri.equals("/login.jsp")||uri.equals("/user_login.action")) {
        		filterChain.doFilter(servletRequest, servletResponse);
        	}else if (session.getAttribute("login") == null) {
        		response.sendRedirect(redirectURl);
        	}else{
        		filterChain.doFilter(servletRequest, servletResponse);
        	}
		}
        // 会话中存在用户，则验证用户是否存在当前页面的权限
        else {
        	WebUser webUser = (WebUser) session.getAttribute("login");
        	if (webUser==null) {
        		response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/error.jsp");
			}else{
		    	uri=uri.substring(uri.lastIndexOf("/")+1);
		    	List<WebResource> webResources=webUserBiz.getUserResource(webUser,null,true);
		    	boolean flag=false;
		    	for (WebResource webResource : webResources) {
					if (webResource.getUrl().equals(uri)) {
						flag=true;
						break;
					}
				}
		        try {
		            // 过滤器经过过滤后，过滤链继续传递请求和响应
		            if (flag) {
		                filterChain.doFilter(servletRequest, servletResponse);
		            } else {
		                // 如果用户没有当前页的权限,页面重新定向到登陆页面
		                response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/error.jsp");
		            }
		        } catch (Throwable e) {
		        	logger.error("权限过滤时候出现错误", e);
		            throw new RuntimeException("权限过滤时候出现错误", e);
		        }
			}
        }
    }
}
