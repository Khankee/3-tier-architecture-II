package com.example;

import java.io.*;

@SuppressWarnings("serial")

public class Authenticator{
	private String uname = null;
	private String pwd = null;
	private String stored_username = null;
	private String stored_password = null;
	
	

	//Constructor
	Authenticator (String uname, String pwd) throws IOException{
		this.uname = uname;
		this.pwd = pwd;
	}

	public boolean authenticateUser() throws IOException{	
		stored_username = uname;
		stored_password = pwd;
		
		return DBcheck(uname + "_" + pwd);
	}
	
	public static boolean DBcheck(String usernameandpassword) throws IOException{
		boolean status = false;
		
		try {
		File f = new File("C:\\Users\\Арухан\\Desktop\\CS 1 year\\2020-2021-team-i\\database\\"+ usernameandpassword + ".txt");
		FileReader readhandle = new FileReader(f);
		
			if(f.exists())
			{
				status = true;
			}
			else {
				status = false;
			}
		}
		catch(FileNotFoundException e) {
			
		}
		return status;
	}

	public String getAuthenticationMessage(){
		return "Username or password is incorrect";
	}

	public String getUsername(){
		return this.stored_username;
	}
}
