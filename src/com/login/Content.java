package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class Content extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		String title=request.getParameter("title");
		// Key key=KeyFactory.createKey("Blog", title);
		// Entity ent = lds.get(key);
		Query q=new Query("Blog").addFilter("title", FilterOperator.EQUAL, title);
	}

}
