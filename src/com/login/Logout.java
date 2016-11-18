package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		HttpSession session=req.getSession(false);
		

		session.invalidate();
		out.print("you have been successfully logged out");
		req.getRequestDispatcher("index.html").include(req, resp);
		}
			
		
	}

