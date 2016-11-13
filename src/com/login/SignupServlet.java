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

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		com.google.appengine.api.datastore.DatastoreService ds = DatastoreServiceFactory
				.getDatastoreService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String emailId = req.getParameter("emailId");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		if (Validation.nullCheck(emailId, userName, password)) {

			Entity user = new Entity("UserDetails", userName);
			Key key = KeyFactory.createKey("UserDetails", userName);
			// System.out.println(Validation.checkUser(key));
			if (Validation.checkUser(key) == false) {
				user.setProperty("emailId", emailId);
				user.setProperty("userName", userName);
				user.setProperty("password", password);
				ds.put(user);
				out.print("<p>Your signup was successfull</p>");

				out.print("<a href=\"LogoutServlet\"> Logout</a>");
			}

			else {
				out.print("<p>User name already exists</p>");
				req.getRequestDispatcher("signup.html").include(req, resp);

			}
		} else {
			out.print("<p>Please fill every section</p>");
			req.getRequestDispatcher("signup.html").include(req, resp);
		}

	}
}
