$(document).ready(function(){
//	function loginShow(){
//		$("#welcome").hide();
//		$("#loginform").show();
//		$("#signupform").hide();
//	}
	$("#welcomelogin").click(function(){
		window.location.href="login.html";	
	});
//	function signupShow(){
//		$("#welcome").hide();
//		$("#loginform").hide();
//		$("#signupform").show();
//	}
	$("#welcomesignup").click(function(){
		
		window.location.href="signup.html";	
	});
//	function welcomeShow(){
//		$("#welcome").show();
//		$("#loginform").hide();
//		$("#signupform").hide();
//	}
	$("#signupbutton").click(signUp);
	$("#loginbutton").click(login);
	
});
function signupShow(){
	console.log("show");
	$("#signupform").show();
}

function signUp(){
	console.log("hi");
	var name=document.getElementById("signupname").value;
	console.log("hi");
	var password=document.getElementById("signuppassword").value;
	var emailId=document.getElementById("emailId").value;
	var url="SignupServlet?username="+name+"&password="+password+"&emailId="+emailId;
	console.log("hi");
	
	$.ajax({
		url:url,
	success:function(result){
		//document.location.href="/";	
		$("#signupform").html(result);
		//$("body").html(result);
		console.log("hi");
		//$("#welcome").html(result);
//		$(document).ready(function(){
//			console.log("hi dd");
//			$("#bodyid").html(result);});
//		if(result=="true"){
//			document.write("your login was successfull");
//		}
//		else if(result=="false"){
//			document.write("username already exists");
//			$("div").load("signup.html");
//			}
//		else{
//			document.write("please fill every section!");
//		}
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
	
