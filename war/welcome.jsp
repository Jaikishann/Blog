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
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body> 
<div>
	<div id=welcome style="text-align:center;">
	
	 
		
		
	
		<%
			if (session.getAttribute("uname") != null) {
				String name = (String) session.getAttribute("uname");
				out.print("<p style=\"color:white\">welcome " + name+"</p>");
				out.print("&emsp;  <input type=\"button\" value=\"createBlog\" onclick=\"blogformShow() \"/>");
				out.print("<input type=\"button\" value=\"logout\" onclick=\"logout() \"/>");
				
				
				}
				 	

			 else {
				out.print(
						"<div style=\"display:inline-block\"><h3 style=\"color:white\"><b>WELCOME</b><h3><input type=\"button\" class=\"button\" value=\"signup\" id=welcomesignup><input type=\"button\" class=\"button\" value=\"login\" id=welcomelogin></div>");
				
				}
			
			
			
		%>
	</div>
	<div id=displayblogs></div>
	<div id=blogcontent style="text-align:center;"></div>
</div>
</body>
</html>