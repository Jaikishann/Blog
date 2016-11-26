$(document).ready(function(){
	
//	$(".contentview").click(function(){
//		alert($(this).attr('id'));
//	})
	$("#welcomelogin").click(function(){
		loginShow();	
	});

	$("#welcomesignup").click(function(){
	
		
		signupShow();	
	});
	
	$.ajax({
		url:"DisplayBlogs",
	success:function(result){
		
		$("#displayblogs").html(result);
		
	}
	})


	$("#signupbutton").click(signUp);
	$("#loginbutton").click(login);
	
//	$(".viewbutton").click(function(){
//		alert($(this).attr('name'));
//		var title=$(this).attr('name');
//		var name=$(this).attr('id');
//		console.log(title);
//		var url="content?title="+title+"&name="+name;
//		$.ajax({
//			url:url,
//			success:function(result){
//				$("body").html(result);
//			}
//				});
//	});
	
});


$("#blogSubmitButton").click(blogSubmit);
$("#logoutbutton").click(logout);
function logout(){
	console.log("logout");
	$.ajax({
		url:"logout.jsp",
	success:function(result){
		
		$("body").html(result);
	}
	})
}
//function contentDisplay(lname,ltitle){
//	var name=lname;
//	var title=ltitle;
//	var url="content?title="+title+"&name="+name;
//	$.ajax({
//		url:url,
//	success:function(result){
//		$("body").html(result);
//	}});
//	
//} 
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
function contentShow(name,title){
//	alert($(this).attr('id'));
	var title=title;
	console.log(title);
	
	var name=name;
	console.log(name);
	var url="content?title="+title+"&name="+name;
	$.ajax({
		url:url,
		success:function(result){
			$("#blogcontent").html(result);
		}
			});
	
}
function blogformShow(){
	$.ajax({
		url:"blogform.jsp",
		success:function(result){
			$("body").html(result);
		}
	
	})
}
function blogSubmit(){
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	$.post(
		"BlogSubmit",
		{
			title: title,
			content: content
		}, function(result){
			$("body").html(result);
		}
	
	)
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
			
		$("#signupform").html(result);
		
		

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
			$("body").html(result);
			
		}
	
	);
	
}
	
