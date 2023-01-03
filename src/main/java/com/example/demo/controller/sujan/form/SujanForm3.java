package com.example.demo.controller.sujan.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SujanForm3 {
	@NotNull(message = "{require_check}")
	private String postNO;
	@NotNull(message = "{require_check}")
	private String address1;
	@NotNull(message = "{require_check}")
	private String address2;
	@NotBlank(message = "{select_check}")
	private String livingSituation;
	@NotBlank(message = "{select_check}")
	private String housingLoan;
	@NotBlank(message = "{select_check}")
	private String drivingLicenseLabel;

	private String drivingLicense;

	@AssertTrue(message = "有り選択の場合運転免許証番号入力してください。")
	public boolean isDrivingValid() {
		if(drivingLicenseLabel != null) {
		if (drivingLicenseLabel.equals("有り") && drivingLicense.equals("")) {
			return false;
		}
		}
		return true;

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
