<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js">
</script>
</head>
<body>
<div id=welcome>
<% 
if(session.getAttribute("uname")!=null){
String name=(String)session.getAttribute("uname");
out.print("welcome "+name);
out.print("<br><input type=\"button\" value=\"logout\" onclick=\"logout()\"/>");

}
else
{
	out.print("<div><h1>WELCOME</h1><br><input type=\"button\" value=\"signup\" id=welcomesignup><input type=\"button\" value=\"login\" id=welcomelogin></div>");
}
%>
	</div>
	</body>
</html>