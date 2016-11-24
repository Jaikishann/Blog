<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import= "com.google.appengine.api.datastore.*" %>
		<%@ page import= "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js"></script>
</head>
<body> 
	<div id=welcome style="display: inline-block">
	
	 
		
		<% HashMap<String,String> hm=new HashMap<String,String>();
		
		DatastoreService lds = DatastoreServiceFactory.getDatastoreService();
		Query q=new Query("Blog");
		PreparedQuery pq=lds.prepare(q);
		 for(Entity ent:pq.asIterable()){
			  
			String name=ent.getProperty("username").toString();
			String title=ent.getProperty("title").toString();
			if(title!=null&&title!=""){
			hm.put(name, title);}
			
		}
		%>
	
		<%
			if (session.getAttribute("uname") != null) {
				String name = (String) session.getAttribute("uname");
				out.print("welcome " + name);
				out.print("&emsp;  <input type=\"button\" value=\"createBlog\" onclick=\"blogformShow() \"/>");
				out.print("<input type=\"button\" value=\"logout\" onclick=\"logout() \"/>");
				try{
					for(Map.Entry<String, String> entry : hm.entrySet()) {
				
				    String key = entry.getKey();
				    String value = entry.getValue();
				    out.print("<div><br><b>"+key+"</b>:<a href=\"content.jsp?title="+value+"&name="+key+"\">"+value+"</a><div>");}}
				catch(Exception e){
					out.print("exception");
				}
				 	

			} else {
				out.print(
						"<div style=\"display:inline-block\"><b>WELCOME</b> &emsp;<input type=\"button\" value=\"signup\" id=welcomesignup><input type=\"button\" value=\"login\" id=welcomelogin></div>");
				try{
					for(Map.Entry<String, String> entry : hm.entrySet()) {
				
				    String key = entry.getKey();
				    String val = entry.getValue();
				    out.print("<div><br><b>"+key+"</b>:"+val+"<input type=\"button\" value=\"view\" id="+val+" onclick=\"contentShow()\"/><div>");
				    System.out.println(val);
				    //out.print("<br>");
				}}
				catch(Exception e){
					out.print("exception2");
				}
			
			
			}
		%>
	</div>
</body>
</html>