$(document).ready(function(){
//	function loginShow(){
//		$("#welcome").hide();
//		$("#loginform").show();
//		$("#signupform").hide();
//	}
	$("#welcomelogin").click(function(){
		loginShow();	
	});
//	function signupShow(){
//		$("#welcome").hide();
//		$("#loginform").hide();
//		$("#signupform").show();
//	}
	$("#welcomesignup").click(function(){
		
		
		signupShow();	
	});


//	function welcomeShow(){
//		$("#welcome").show();
//		$("#loginform").hide();
//		$("#signupform").hide();
//	}
	$("#signupbutton").click(signUp);
	$("#loginbutton").click(login);
	
	
});
$("#logoutbutton").click(logout);
function logout(){
	console.log("logout");
	$.ajax({
		url:"logout.jsp",
	success:function(result){
		
		$("#welcome").html(result);
	}
	})
}
function signupShow(){
	
	$.ajax({
		url:"signup.jsp",
	success:function(result){
		$("#welcome").html(result);
	}});
}
function loginShow(){
	$.ajax({
		url:"login.jsp",
	success:function(result){
		$("#welcome").html(result);
	}})
}
function signUp(){
	//console.log("hi");
	var name=document.getElementById("signupname").value;
	//console.log("hi");
	var password=document.getElementById("signuppassword").value;
	var emailId=document.getElementById("emailId").value;
//	var url="SignupServlet?username="+name+"&password="+password+"&emailId="+emailId;
//	console.log("hi");
	
	$.post(
		"SignupServlet",
		{
			username: name,
			password: password,
			emailId: emailId
		},
	function(result){
		//document.location.href="/";	
		$("#signupform").html(result);
		//$("body").html(result);
		console.log("hi");

	}
	);
}

function login(){
	var name=document.getElementById("loginname").value;
	var password=document.getElementById("loginpassword").value;
	//var url="Login?name="+name+"&password="+password;
	$.post(
		"Login",{
			name: name,
			password: password
		},
		function(result){
			$("#loginform").html(result);
			
		}
	
	);
	
}
	
