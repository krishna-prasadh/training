package com.adduser;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adduser
 */
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = request.getRequestDispatcher("/adduser.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		Connection con;
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "1234";
		String query = "insert into `user` (user_name, password) values( ?,?)";
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			System.out.println("query is " + pst);

			count = pst.executeUpdate();
			response.sendRedirect("/login");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("failed to signup");
			System.out.println(e.getMessage());
			HttpSession hs= request.getSession();
			hs.setAttribute("message", e.getMessage());
			response.sendRedirect("/adduser/error");

			// e.printStackTrace();
		} // com.mysql.cj.jdbc.Driver
		System.out.println(count + " rows affected ");

	}

}
