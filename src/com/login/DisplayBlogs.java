package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;

public class DisplayBlogs extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		PrintWriter out=response.getWriter();
		Query q=new Query("Blog").addSort("time", Query.SortDirection.DESCENDING);
		PreparedQuery pq=lds.prepare(q);
		 for(Entity ent:pq.asIterable()){
			  
				String name=ent.getProperty("username").toString();
				String title=ent.getProperty("title").toString();
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
				out.print("<div id=bloglink><b>"+name+"</b>: &nbsp;<a href=\"content?title="+title+"&name="+name+"\">"+title+"</a></div><br>");
//				out.println("<script src=\"blog.js\"></script>");
//				out.print("<button class=\"contentview\" id="+title+" value="+name+">view</button>");
				}
		 }
				
	

}
