package com.wanpin.sys.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.SecurityHelper;
import com.wanpin.entity.User;

public class SessionInterceptor implements HandlerInterceptor {
	
	private String loginUrl;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		User userInfo = SecurityHelper.getUserInfo(request);
		if (userInfo == null) {
			boolean ajax = "XMLHttpRequest".equals( request.getHeader("X-Requested-With") );
			String ajaxFlag = null == request.getParameter("ajax") ?  "false": request.getParameter("ajax") ;
		    boolean isAjax = ajax || ajaxFlag.equalsIgnoreCase("true");
		    if (isAjax) {
		    	request.getSession().setAttribute("redirectUrl", request.getParameter("targetUrl"));
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("status", SystemEnum.RESP_SESSION_INVALID);
		    	map.put("loginUrl", loginUrl);
				response.getWriter().write(JSONUtils.toJSONString(map));
			} else {
				request.getSession().setAttribute("redirectUrl", request.getRequestURL());
				response.getWriter().write("<script>top.window.location.href='"+request.getContextPath()+loginUrl+"'</script>");
			}
			return false;
		} else {
			return true;
		}
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

}
