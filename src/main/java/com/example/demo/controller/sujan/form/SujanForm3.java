package com.example.demo.controller.sujan.form;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SujanForm3 {
	private String postNO;
	private String address1;
	private String address2;
	private String livingSituation;
	private String housingLoan;
	private String drivingLicenseLabel;
	private String drivingLicense;

	public String getPostNO() {
		return postNO;
	}

	public void setPostNO(String postNO) {
		this.postNO = postNO;
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

	public String getDrivingLicenseLabel() {
		return drivingLicenseLabel;
	}

	public void setDrivingLicenseLabel(String drivingLicenseLabel) {
		this.drivingLicenseLabel = drivingLicenseLabel;
	}

	// gender

	public static Map<String, String> getLivingSituationList() {
		Map<String, String> livingMap = new LinkedHashMap<>();
		livingMap.put("自己・家族所有", "自己・家族所有");
		livingMap.put("社宅", "社宅");
		livingMap.put("賃貸", "賃貸");
		livingMap.put("寮・下宿", "寮・下宿");
		return livingMap;
	}

	public static Map<String, String> getHousingLoanButton() {
		Map<String, String> housingLoan = new LinkedHashMap<String, String>();
		housingLoan.put("有り", "有り");
		housingLoan.put("無し", "無し");
		return housingLoan;
	}

	public static Map<String, String> getDrivingLicenseLabelButton() {
		Map<String, String> drivingLicense = new LinkedHashMap<String, String>();
		drivingLicense.put("有り", "有り");
		drivingLicense.put("無し", "無し");
		return drivingLicense;
	}

}
