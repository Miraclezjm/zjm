package com.mashen;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestSession")
public class TestSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session用于服务端保存用户状态信息
		//request.getSession()等同于request.getSession(true)
		//处理过程：根据sessionid查询当前是否有session，如果有则直接返回一个session对象
		//如果没有，则新建一个session对象
		
		//request.getSession(false)
		//处理过程：根据sessionid查询当前是否有session，如果有则直接返回一个session对象
		//如果没有，则返回null值
		
		request.setAttribute("user", "admin1");
		HttpSession ss = request.getSession();
		ss.setAttribute("user", "admin2");
		System.out.println("Sessionid: "+ss.getId());
		
		//Cookie用于客户端保存用户状态信息
		Cookie ck = new Cookie("token", UUID.randomUUID().toString());
		//负数表示浏览器级别，浏览器关闭则cookie销毁
		//0表示删除cookie
		//正数表示保存到客户端硬盘的时间，单位为秒
		ck.setMaxAge(120);
		
		ck.setPath(request.getContextPath()+"/TestCookie");
		
		ck.setDomain(".baidu.com");
		
		response.addCookie(ck);
		System.out.println("添加了Cookie token:"+ck.getValue());
		
		
		
		
						//request.getSession(true);
						//request.getSession(false);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
