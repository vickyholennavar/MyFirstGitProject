package com.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Login.Dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginDao logindao=new LoginDao();
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		if(logindao.check(uname, pass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("Welcome.jsp");
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
	}

}
