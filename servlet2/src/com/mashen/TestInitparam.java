package com.mashen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInitparam
 */
//@WebServlet("/TestInitparam")
public class TestInitparam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInitparam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savepath = request.getServletContext().getInitParameter("savepath");
		System.out.println("savepath:"+savepath);
		String user = this.getServletConfig().getInitParameter("user");
		System.out.println(user);
		
		String host = request.getHeader("Host");
		response.setHeader("Server", "ddddddddddddd");
		//response.setStatus(403);
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("中文");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
