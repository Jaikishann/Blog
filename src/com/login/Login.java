package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out=resp.getWriter();
		DatastoreService lds=DatastoreServiceFactory.getDatastoreService();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		Key key=KeyFactory.createKey("UserDetails", name);
		try {
			 com.google.appengine.api.datastore.Entity ent=lds.get(key);
				if (ent.getProperty("password").equals(password)){
					out.print("your login is successfull");
					System.out.println("password"+password);
				}
				else{
					out.print("please enter valid details");
				}
				//System.out.print(employee.toString());
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				out.println("please signup first");
				
				//System.out.println("Not found");
			}
		
	}
}
