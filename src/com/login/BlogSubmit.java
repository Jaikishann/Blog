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
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;



public class BlogSubmit extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		PrintWriter p=resp.getWriter();
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		resp.setContentType("text/html");
		HttpSession session=req.getSession();
		String name=(String)session.getAttribute("uname");
		com.google.appengine.api.datastore.Key key=KeyFactory.createKey("UserDetails", name);
		try {
			Entity e=ds.get(key);
			e.setProperty("title", title);
			e.setProperty("content", content);
			ds.put(e);
			p.print("updated");
			
			req.getRequestDispatcher("/").include(req, resp);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
