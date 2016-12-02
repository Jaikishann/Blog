package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long time=timestamp.getTime();
		HttpSession session=req.getSession();
		if(session.getAttribute("key")!=null){
			Key key=(Key) session.getAttribute("key");
			
				try {
					Entity ent=ds.get(key);
					ent.setProperty("title", title);
					ent.setProperty("content", content);
					ent.setProperty("time", time);
					ds.put(ent);
					p.print("updated successfully");
					req.getRequestDispatcher("/").include(req, resp);
					
				} catch (EntityNotFoundException e) {
					System.out.println("invalid "+key);
				}
			
			
			
		}
		else{
		String name=(String)session.getAttribute("uname");
		//com.google.appengine.api.datastore.Key key=KeyFactory.createKey("UserDetails", name);
		
			Entity blog=new Entity("Blog");
			
			blog.setProperty("username", name);
			blog.setProperty("title", title);
			blog.setProperty("content", content);
			blog.setProperty("time", time);
			
			ds.put(blog);
			p.print("Your Blog has been updated<br>");
			
			req.getRequestDispatcher("/").include(req, resp);
		
		}}
		
	}


