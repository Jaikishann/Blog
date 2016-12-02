package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Content extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		HttpSession session=request.getSession(false);
		
		
		
		// Key key=KeyFactory.createKey("Blog", title);
		// Entity ent = lds.get(key);
		Query q = new Query("Blog").addFilter("title", FilterOperator.EQUAL, title);
		PreparedQuery pq = lds.prepare(q);
		for (Entity ent : pq.asIterable()) {
			if (ent.getProperty("username").equals(name)) {
				String content = (String) ent.getProperty("content");
				out.print("<div id=titlediv><h3 style=\"color:white\"><b>" + title + "</b></h3></div><br>");
				out.print("&emsp;<div id=contentdiv><p style=\"color:white\">" + content+"</p></div>");
				
				if (session.getAttribute("uname")!=null){
					String sessionName=(String)session.getAttribute("uname");
				if(sessionName.equals(name)){
					Key key=ent.getKey();
					//System.out.println(key);
					session.setAttribute("key", key);
					
					
					
				
					out.print("<br><button style=\"color:black\" onclick=\"editBlog()\"> edit </button>");}}
			}
		}
		out.print("<br><a href=\"/\">home</a>");

	}
}
