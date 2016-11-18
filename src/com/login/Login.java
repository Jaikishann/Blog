package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		if (Validation.nullCheckLogin(name, password)) {

			Key key = KeyFactory.createKey("UserDetails", name);
			try {

				com.google.appengine.api.datastore.Entity ent = lds.get(key);
				// if (ent.getProperty("password").equals(password))

				if (Validation.isValidUser((ent.getProperty("password")),
						password)) {
//					out.print("<p style=\"color:#0BC356\">hi " + name
//							+ " your login is successfull</p>");
					// System.out.println("password"+password);
					HttpSession session = req.getSession();
					session.setAttribute("uname", name);
//					out.print("</br><a href=\"logout.jsp\"> Logout</a>");
					resp.sendRedirect("login.jsp");

				} else {
					out.print("<p style=\"color:red\">please enter valid details</p>");
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}

			// System.out.print(employee.toString());
			catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				out.println("<p style=\"color:red\">please signup first</p>");
				req.getRequestDispatcher("signup.jsp").include(req, resp);

				// System.out.println("Not found");
			}
		} else {
			out.print("<p style=\"color:red\">please fill every section</p>");
			req.getRequestDispatcher("login.jsp").include(req, resp);

		}

	}
}
