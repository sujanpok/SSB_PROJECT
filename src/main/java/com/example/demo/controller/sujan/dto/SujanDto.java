package com.example.demo.controller.sujan.dto;



import lombok.Data;
@Data
public class SujanDto  {
	
	private Long id;

	private String name;
    private String nationality;
    private String gender;
    private  String dateOfYear;
	private  String dateOfMonth;
    private  String dateOfDay;
    private String merriage;
    private String email;
    private String mobileNo1;
    private String mobileNo2;
    private String mobileNo3;
    private String postNO;
    private String address1;
	private String address2;
    private String livingSituation;
    private String housingLoan;
    private String drivingLicenseLabel;
    private String drivingLicense;
	
    
    private String userId;
    private String pwd;
    private String rePwd;
	

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfYear() {
		return dateOfYear;
	}
	public void setDateOfYear(String dateOfYear) {
		this.dateOfYear = dateOfYear;
	}
	public String getDateOfMonth() {
		return dateOfMonth;
	}
	public void setDateOfMonth(String dateOfMonth) {
		this.dateOfMonth = dateOfMonth;
	}
	public String getDateOfDay() {
		return dateOfDay;
	}
	public void setDateOfDay(String dateOfDay) {
		this.dateOfDay = dateOfDay;
	}
	public String getMerriage() {
		return merriage;
	}
	public void setMerriage(String merriage) {
		this.merriage = merriage;
	}
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
	public String getPostNO() {
		return postNO;
	}
	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}
	public String getLivingSituation() {
		return livingSituation;
	}
	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}
	public String getHousingLoan() {
		return housingLoan;
	}
	public void setHousingLoan(String housingLoan) {
		this.housingLoan = housingLoan;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
		
 	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDrivingLicenseLabel() {
		return drivingLicenseLabel;
	}
	public void setDrivingLicenseLabel(String drivingLicenseLabel) {
		this.drivingLicenseLabel = drivingLicenseLabel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
}
