package com.dtc.test.qsm.server;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import org.springframework.web.context.support.WebApplicationContextUtils;

import us.dontcareabout.gwt.server.WebSocketServer;

@WebFilter(urlPatterns="*")
public final class QSMoniterFilter implements Filter {
	private WebSocketServer wsServer;

	public QSMoniterFilter() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		Gson gson = new Gson();
		HttpServletRequest request = (HttpServletRequest) req;
		Data data = new Data();
		data.setPage(request.getRequestURL().toString());
		data.setParameter(request.getParameterMap());
		wsServer.broadcast(gson.toJson(data));
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		wsServer = WebApplicationContextUtils
			.getWebApplicationContext(arg0.getServletContext())
			.getBean(WebSocketServer.class);
	}
}

class Data {
	private String page;
	private Map<String, String[]> parameter;

	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Map<String, String[]> getParameter() {
		return parameter;
	}
	public void setParameter(Map<String, String[]> parameter) {
		this.parameter = parameter;
	}
}