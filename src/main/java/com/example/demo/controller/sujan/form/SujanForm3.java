package com.example.demo.controller.sujan.form;

import lombok.Data;

@Data
public class SujanForm3 {
	private String postNO;
    private String Adress1;
    private String Adress2;
    private String livingSituation;
    private String HousingLoan;
    private boolean drivingLicenseLabel;
    private String drivingLicense;
    
	 public String getPostNO() {
		return postNO;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
	}

	public String getAdress1() {
		return Adress1;
	}

	public void setAdress1(String adress1) {
		Adress1 = adress1;
	}

	public String getAdress2() {
		return Adress2;
	}

	public void setAdress2(String adress2) {
		Adress2 = adress2;
	}

	public String getLivingSituation() {
		return livingSituation;
	}

	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}

	public String getHousingLoan() {
		return HousingLoan;
	}

	public void setHousingLoan(String housingLoan) {
		HousingLoan = housingLoan;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public boolean isDrivingLicenseLabel() {
		return drivingLicenseLabel;
	}

	public void setDrivingLicenseLabel(boolean drivingLicenseLabel) {
		this.drivingLicenseLabel = drivingLicenseLabel;
	}

	
	    
}
