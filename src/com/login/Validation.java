package com.login;

public class Validation {
	public static boolean nullCheck(String emailId,String userName , String password){
		if (emailId!=""&&userName!=""&&password!=""){
			return true;
		}
		else{
			return false;
		}
		
	}
//	public static boolean duplicateUserNameCheck(){
		
	}

//}
