package com.login;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

public class Validation {
	public static boolean nullCheck(String emailId,String userName , String password){
		if (emailId!=""&&userName!=""&&password!=""){
			return true;
		}
		else{
			return false;
		}
		
	}
	public static boolean nullCheckLogin(String userName , String password){
		if (userName!=""&&password!=""){
			return true;
		}
		else{
			return false;
		}
		
	}
//	public static boolean duplicateUserNameCheck(){
		
	

//}
public static boolean checkUser(Key name){
	boolean status = false;
	DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	
	
	try {
	Entity ent1 = ds.get(name);
		status = true;
		//System.out.print(employee.toString());
	} catch (EntityNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		status = false;
		//System.out.println("Not found");
	}
	
	return status;
}
public static boolean isValidUser(Object a,String b){
 
	if(a.equals(b)) {
	
	return true;
	}
else{
	return false;
		
	}
}
}


