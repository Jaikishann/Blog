<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com.google.appengine.api.datastore.*" %>
    <%@ page import= "com.google.appengine.api.datastore.Query.FilterOperator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js"></script>
</head>
<body>
<%
DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
String title=request.getParameter("title");
String name=request.getParameter("name");
System.out.println(title);
System.out.println(name);
// Key key=KeyFactory.createKey("Blog", title);
// Entity ent = lds.get(key);
Query q=new Query("Blog").addFilter("title", FilterOperator.EQUAL, title);
PreparedQuery pq=lds.prepare(q);
for(Entity ent:pq.asIterable()){
	if(ent.getProperty("name").equals(name)){
String content=(String)ent.getProperty("content");
out.print(title+":<br>");
out.print("&emsp;"+content);
out.print("<a href=\"/\">home</a>");}

}	




%>
</body>
</html>