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
