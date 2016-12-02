<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js"></script>
</head>
<body>
	<%!String content;
	String title;%>

	<%
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
			content = request.getParameter("content");
			// 	System.out.println("skdn "+keyy);
			// 	Key key = KeyFactory.createKey("Blog", keyy);
			// 	Entity ent=lds.get(key);
			// 	content=(String)ent.getProperty("content");
			// 	title=(String)ent.getProperty("title");
		}
	%>

	<div>
		<b>Enter the title: </b><input type="text" id=title
			value="<%if (request.getParameter("title") != null) {
				out.print(title);
			}%>" /><br>
		<b>Enter your Blog: </b> <br>
		<textarea rows="30" cols="70" id=content style="color: #354841;">
			<%
				if (request.getParameter("title") != null) {
					out.print(content);
				}
			%>
		</textarea>
		<br>
		<input type="button" value="submit" id=blogSubmitButton>

	</div>
</body>
</html>