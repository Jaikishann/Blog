package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Content extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		
		// Key key=KeyFactory.createKey("Blog", title);
		// Entity ent = lds.get(key);
		Query q = new Query("Blog").addFilter("title", FilterOperator.EQUAL, title);
		PreparedQuery pq = lds.prepare(q);
		for (Entity ent : pq.asIterable()) {
			if (ent.getProperty("username").equals(name)) {
				String content = (String) ent.getProperty("content");
				out.print("<h3 style=\"color:white\"><b>" + title + ":</b></h3><br>");
				out.print("&emsp;<p style=\"color:white\">" + content+"</p>");
			}
		}
		out.print("<br><a href=\"/\">home</a>");

	}
}
