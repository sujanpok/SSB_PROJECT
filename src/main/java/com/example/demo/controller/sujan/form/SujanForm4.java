package com.example.demo.controller.sujan.form;


import lombok.Data;

@Data
public class SujanForm4 {
	private String userId;
    private String pwd;
    private String rePwd;
    


	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRePwd() {
		return rePwd;
	}
	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
