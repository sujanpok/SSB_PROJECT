package com.example.demo.controller.sujan.form;

import lombok.Data;

@Data

public class SujanForm2 {
	private String email;
    private String mobileNo1;
    private String mobileNo2;
    private String mobileNo3;

	 public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo1() {
		return mobileNo1;
	}
	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}
	public String getMobileNo2() {
		return mobileNo2;
	}
	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}
	public String getMobileNo3() {
		return mobileNo3;
	}
	public void setMobileNo3(String mobileNo3) {
		this.mobileNo3 = mobileNo3;
	}
	
	
}
