package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		com.google.appengine.api.datastore.DatastoreService ds = DatastoreServiceFactory
				.getDatastoreService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String emailId = req.getParameter("emailId");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
//		
		if (Validation.nullCheck(emailId, userName, password)) {

			

			Key key = KeyFactory.createKey("UserDetails", userName);
			
			if (Validation.checkUser(key) == false) {
				Entity user = new Entity("UserDetails", userName);
				user.setProperty("emailId", emailId);
				user.setProperty("userName", userName);
				user.setProperty("password", password);
				
				ds.put(user);
				
				HttpSession session=req.getSession(true);
				session.setAttribute("uname", userName);
				
				out.print("<p>hi</p>"+userName+"<p>Your signup was successfull</p>");

				out.print("<script src=\"blog.js\"></script><br><input type=\"button\" value=\"login\" id=welcomelogin>");
				
				
			}

			else {
				out.print("<p style=\"color:red\">User name already exists</p>");
				
				
				
				req.getRequestDispatcher("signup.jsp").include(req, resp);
				//out.print("false");

			}}
		 else {
			out.print("<p style=\"color:red\">Please fill every section</p>");
			req.getRequestDispatcher("signup.jsp").include(req, resp);
			
			// out.print("empty");
		}

	}
}
