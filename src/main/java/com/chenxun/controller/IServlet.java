package com.chenxun.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class IServlet
 */
public class IServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final Log  log = LogFactory.getLog(this.getClass());
   
    public IServlet() {
        super();
        log.info("====IServlet()===");
    }


	public void init() throws ServletException {
		log.info("====init(ServletConfig config)===");
	}


	public ServletConfig getServletConfig() {
		log.info("====getServletConfig()===");
		return null;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("====doGet===");
		String aa = request.getParameter("aa");
		response.getWriter().write(aa);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("====doPost===");
		this.doGet(request, response);
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}

}
