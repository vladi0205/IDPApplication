package com.vlad.myIDPApp;

import java.util.HashMap;

public class User {
	
	private String username;
	private String password;
	private String status = "active";
	public HashMap<Integer, String> userDocs;
	
	public User() {
		//dummyLoadDocuments();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
