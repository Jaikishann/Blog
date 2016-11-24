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
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;



public class BlogSubmit extends HttpServlet{
//	public ArrayList title=new ArrayList();
//	public ArrayList content=new ArrayList();
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		PrintWriter p=resp.getWriter();
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		resp.setContentType("text/html");
		HttpSession session=req.getSession();
		if(session.getAttribute("uname")!=null){
		String name=(String)session.getAttribute("uname");
		//com.google.appengine.api.datastore.Key key=KeyFactory.createKey("UserDetails", name);
		
			Entity blog=new Entity("Blog",title);
			//@SuppressWarnings("unchecked") 
			//ArrayList<String> title=(ArrayList<String>) e.getProperty("title");
			//@SuppressWarnings("unchecked")
			//ArrayList<String> content=(ArrayList<String>) e.getProperty("content");
//			title.add(title1);
//			content.add(content1);
			blog.setProperty("username", name);
			blog.setProperty("title", title);
			blog.setProperty("content", content);
			ds.put(blog);
			p.print("updated<br>");
			
			req.getRequestDispatcher("/").include(req, resp);
		
		}
		else{
			p.print("please login first");
		}
	}

}
