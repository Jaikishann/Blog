<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#butt").click(function(){
	var message=$(this).attr('id');
	console.log(message);
	alert(message);
	
});
});

</script>
</head>
<body>
<div id=divid>
<%
String idval="butt";
out.print ("<input type=\"button\" id="+idval+" value=\"clickme\" ></div>");%>
</div>
</body>
</html>