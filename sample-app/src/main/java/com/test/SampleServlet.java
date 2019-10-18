package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet(name = "SampleServlet", urlPatterns = "/SampleServlet2")
*/
/**
 * Servlet implementation class SampleServlet
 */
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleServlet() {
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
		response.sendRedirect("home");
//		RequestDispatcher rdp = request.getRequestDispatcher("index.jsp"); 
//		  rdp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		 String typ = request.getParameter("Type");
		 
		 if(typ==null) {
			 
			 RequestDispatcher rdp = request.getRequestDispatcher("index.jsp"); 
			  rdp.forward(request, response);
			 
		 }
		 else {
			 SampleService ser = new SampleService();
			  List items=ser.getItems(typ);
			  
			  System.out.print(typ);
			  
			  request.setAttribute("type", items);
			  RequestDispatcher rdp = request.getRequestDispatcher("result.jsp"); 
			  rdp.forward(request, response);
			 
		 }
		  
		  
		 

	}

}
