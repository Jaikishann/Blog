<html>
<head>

<title>Welcome</title>

</head>
<body>
<%
if(session!=null){
String name=session.getAttribute("uname");
out.print("welcome"+name);
}
else{
<%@ include file="index.html" %>
	%>
	</body>
	</head>
	