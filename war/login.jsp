<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js"></script>
</head>
<body>  
<% if(session.getAttribute("uname")!=null){
	response.sendRedirect("/");
}
%>
<div id=loginform>
		<b>Name: </b><input type="text" placeholder="enter your name" id="loginname" > <br> 
		<b>Password:</b><input type="password" placeholder="enter your password" id="loginpassword"> <br>
		 <input type="button" value="login" id=loginbutton class="button">
	</div>

</body>
</html>