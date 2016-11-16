package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		com.google.appengine.api.datastore.DatastoreService ds = DatastoreServiceFactory
				.getDatastoreService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String emailId = req.getParameter("emailId");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
//		HttpSession session = req.getSession();
//		session.setAttribute("name", userName);
//		if(session.getAttribute("name")!=null){
		if (Validation.nullCheck(emailId, userName, password)) {

			

			Key key = KeyFactory.createKey("UserDetails", userName);
			// System.out.println(Validation.checkUser(key));
			if (Validation.checkUser(key) == false) {
				Entity user = new Entity("UserDetails", userName);
				user.setProperty("emailId", emailId);
				user.setProperty("userName", userName);
				user.setProperty("password", password);
				ds.put(user);
				out.print("<p style=\"color:#0BC356\">Your signup was successfull</p>");

				out.print("<a href=\"Logout\"> Logout</a>");
			}

			else {
				out.print("<p style=\"color:red\">User name already exists</p>");
				
				req.getRequestDispatcher("signup.html").include(req, resp);

			}}
		 else {
			out.print("<p style=\"color:red\">Please fill every section</p>");
			req.getRequestDispatcher("signup.html").include(req, resp);
			out.print("</br><a href=\"index.html\">home</a>");
		}

	}
}
