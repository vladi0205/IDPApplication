package com.vlad.myIDPApp;

public class Authentication {
	
	public String username;
	public String password;
	
	public Authentication() {
		setUsername("");
		setPassword("");
	}
	
	public Authentication(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	private void setUsername(String username) {
		this.username = username;
	}
	
	private String getUsername(){
		return this.username;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	private String getPassword(){
		return this.password;
	}
	
	public Boolean authenticate(String username, String password){
		if(username.equals(getUsername()) && password.equals(getPassword())){
			return true;
		}
		return false;
	}

}
