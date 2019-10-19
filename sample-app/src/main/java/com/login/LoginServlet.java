package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cookie.MyCookie;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyCookie mc = new MyCookie();

		Cookie localCookie=mc.getCookieeByName(request,"training");
		
//		this.redirect(lout, request, response);
		if (localCookie == null) {
			response.sendRedirect("/login");
			//RequestDispatcher rdp = request.getRequestDispatcher("index.html");
		//	rdp.forward(request, response);
		} else {
			RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
			rdp.forward(request, response);

		}
		

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void redirect(boolean valid,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (!valid) {
			//res.sendRedirect("login");
			RequestDispatcher rdp = req.getRequestDispatcher("index.html");
			rdp.forward(req, res);
		} else {
			RequestDispatcher rdp = req.getRequestDispatcher("index.jsp");
			rdp.forward(req, res);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = res.getWriter();
		boolean valid = false;
		MyCookie mc = new MyCookie();

		String user_name = (String) req.getParameter("user_name");
		String pwd = (String) req.getParameter("password");
		if (user_name != null && pwd != null) {
			if (user_name.equals("user") && pwd.equals("1234")) {
				
				valid = true;
				mc.setCookie("training", user_name, res);

			}
		} else {
			valid = mc.getCookiee(req);
		}
		System.out.print("cookie "+valid);
		this.redirect(valid, req, res);
		

	}

}
