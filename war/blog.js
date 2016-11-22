$(document).ready(function(){

	$("#welcomelogin").click(function(){
		loginShow();	
	});

	$("#welcomesignup").click(function(){
		
		
		signupShow();	
	});



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
		$("body").html(result);
	}})
}
function blogformShow(){
	$.ajax({
		url:"blogform.jsp",
		success:function(result){
			$("body").html(result);
		}
	
	})
}

function signUp(){
	
	var name=document.getElementById("signupname").value;
	
	var password=document.getElementById("signuppassword").value;
	var emailId=document.getElementById("emailId").value;
 
	
	$.post(
		"SignupServlet",
		{
			username: name,
			password: password,
			emailId: emailId
		},
	function(result){
			
		$("body").html(result);
		
		

	}
	);
}

function login(){
	var name=document.getElementById("loginname").value;
	var password=document.getElementById("loginpassword").value;
	
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
	
