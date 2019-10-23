package com.login;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

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

		Cookie localCookie = mc.getCookieeByName(request, "training");

//		this.redirect(lout, request, response);
		if (localCookie == null) {
			response.sendRedirect("/login");
			// RequestDispatcher rdp = request.getRequestDispatcher("index.html");
			// rdp.forward(request, response);
		} else {
			RequestDispatcher rdp = request.getRequestDispatcher("index.jsp");
			rdp.forward(request, response);

		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void redirect(boolean valid, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		if (!valid) {
			// res.sendRedirect("login");
			RequestDispatcher rdp = req.getRequestDispatcher("index.html");
			rdp.forward(req, res);
		} else {
			RequestDispatcher rdp = req.getRequestDispatcher("index.jsp");
			rdp.forward(req, res);

		}

	}

	public boolean validateUser(String name, String password)  {

		boolean validUser = false;
		String url = "jdbc:mysql://localhost:3306/test";
		String host = "root";
		String pwd = "1234";
		String query = "select count(*) as count from user where user_name='" + name + "' and password='" + password + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, host, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			
			int i = rs.getInt("count");
			if (i == 1) {
				validUser = true;
			}
		}
		 catch ( ClassNotFoundException e ) {
	            System.out.println("error loading calss");
	            System.out.println(e.getMessage());
		 }
		catch ( SQLException e ) {
            // TODO handle me
			 System.out.println("sql error ");
	            System.out.println(e.getMessage());
		
	 }
		

		return validUser;

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
			
				valid = validateUser(user_name, pwd);
			if(valid) {
				mc.setCookie("training", user_name, res);
			}
			else
			{
				res.sendRedirect("/login");
			}

		} else {
			valid = mc.getCookiee(req);
		}
		System.out.print("cookie " + valid);
		this.redirect(valid, req, res);

	}

}
