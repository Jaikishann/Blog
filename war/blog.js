$(document).ready(function(){
	function loginShow(){
		$("#welcome").hide();
		$("#loginform").show();
		$("#signupform").hide();
	}
	$("#welcomelogin").click(function(){
		loginShow();
	});
	function signupShow(){
		$("#welcome").hide();
		$("#loginform").hide();
		$("#signupform").show();
	}
	$("#welcomesignup").click(function(){
		signupShow();
	})
	function welcomeShow(){
		$("#welcome").show();
		$("#loginform").hide();
		$("#signupform").hide();
	}
	$("#signupbutton").click(signUp);
	$("#loginbutton").click(login);
	
});
function signUp(){
	var name=document.getElementById("signupname").value;
	
	var password=document.getElementById("signuppassword").value;
	var emailId=document.getElementById("emailId").value;
	var url="SignupServlet?username="+name+"&password="+password+"&emailId="+emailId;
	
	$.ajax({
		url:url,
	success:function(result){
		$("#signupform").html(result);
	}
	});
}
function login(){
	var name=document.getElementById("loginname").value;
	var password=document.getElementById("loginpassword").value;
	var url="Login?name="+name+"&password="+password;
	$.ajax({
		url:url,
		success:function(result){
			$("#loginform").html(result);
			
		}
	
	});
	
}
	
