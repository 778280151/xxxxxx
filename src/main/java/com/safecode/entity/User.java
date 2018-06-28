package com.safecode.entity;

public class User {
	
	private int u_id;
    private String u_username;
    private String u_password;
    private String u_nickname;
    
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_nickname="
				+ u_nickname + "]";
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public User() {
		super();
	}
	public User(int u_id, String u_username, String u_password,String u_nickname) {
		super();
		this.u_id = u_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_nickname = u_nickname;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
    

	
}
