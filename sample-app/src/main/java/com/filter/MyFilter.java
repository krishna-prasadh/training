package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cookie.MyCookie;

/**
 * Servlet Filter implementation class Filter
 */
public class MyFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("url is --" + req.getServletPath());
		MyCookie mc = new MyCookie();
		Cookie browserCookie = mc.getCookieeByName(req, "training");

		if (browserCookie == null) {
			// System.out.print();req.getRequestURI().toString().equals("login")

			if (req.getServletPath().equals("/login") ||req.getServletPath().equals("/validations.js") || req.getServletPath().equals("/adduser/error") ||req.getServletPath().equals("/app/adduser") || (req.getParameter("user_name") != null
					&& req.getParameter("password") != null && req.getServletPath().equals("/home"))) {
				chain.doFilter(request, response);
			} else
				res.sendRedirect("http://localhost:8080/login");

		} else {

			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
