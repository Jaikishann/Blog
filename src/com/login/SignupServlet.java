package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
//import com.google.appengine.repackaged.com.google.api.client.util.Key;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		com.google.appengine.api.datastore.DatastoreService ds = DatastoreServiceFactory
				.getDatastoreService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String emailId = req.getParameter("emailId");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		//if (Validation.nullCheck(emailId, userName, password)) {
			Entity user = new Entity("UserDetails", userName);

			com.google.appengine.api.datastore.Key key = KeyFactory.createKey("userDetails", userName);
			
			try {
				Entity ent = ds.get(key);
				
				if (!(ent.getProperty("userName").equals(userName))) {
					user.setProperty("emailId", emailId);
					user.setProperty("userName", userName);
					user.setProperty("password", password);
					ds.put(user);
					
					out.print("<p>Your signup was successfull</p>");
					out.print("<a href=\"ProfileServlet\"> Profile</a>");
					out.print("<a href=\"LogoutServlet\"> Logout</a>");
				} else {
					out.print("<p>Please Enter Valid Details</p>");
				}
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				out.print("excp");
			}

		}

	}
//}
