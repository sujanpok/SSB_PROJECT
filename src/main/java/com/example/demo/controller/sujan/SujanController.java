package com.example.demo.controller.sujan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.form.SujanForm1;
import com.example.demo.controller.sujan.form.SujanForm2;
import com.example.demo.controller.sujan.form.SujanForm3;
import com.example.demo.controller.sujan.form.SujanForm4;

@Controller
public class SujanController {

	// first page
	@RequestMapping("/sujan/chooseCard")
	public String welcomePage() {
		return "sujan/welcome_page";
	}

	// entry page1
	@RequestMapping(value = "/form1", method = RequestMethod.GET)
	public String personalInfo1(@ModelAttribute SujanForm1 sujanForm1, Model model) {

		// male
		sujanForm1.setGender("1");
		sujanForm1.setNationality(true);

		model.addAttribute("genderItem", SujanForm1.getGenderItem());
		model.addAttribute("merriageStsList", SujanForm1.getMerriageItems());
		model.addAttribute("dateOfYearList", SujanForm1.getYearItems());
		model.addAttribute("dateOfMonthList", SujanForm1.getMonthItems());
		model.addAttribute("dateOfDayList", SujanForm1.getDayItems());

		SujanDto sujanDto = new SujanDto();

		sujanDto.setName(sujanForm1.getName());
		sujanDto.setGender(sujanForm1.getGender());

		if (sujanForm1.isNationality()) {
			sujanDto.setNationality("外国籍");
		} else {
			sujanDto.setNationality("日本");
		}

		sujanDto.setMerriage(sujanForm1.getMerriageSts());
		sujanDto.setDateOfYear(sujanForm1.getDateOfYear());
		sujanDto.setDateOfMonth(sujanForm1.getDateOfMonth());
		sujanDto.setDateOfDay(sujanForm1.getDateOfDay());
		return "sujan/personalInfoForm1";
	}

	// first page return
	@RequestMapping(value = "form2", params = "back", method = RequestMethod.POST)
	public String welcomePageBack(@ModelAttribute SujanDto sujanDto, Model model) {
		sujanDto.setName("");
		sujanDto.setGender("");
		sujanDto.setNationality("");
		sujanDto.setMerriage("");
		sujanDto.setDateOfYear("");
		sujanDto.setDateOfMonth("");
		sujanDto.setDateOfDay("");

		return "sujan/welcome_page";
	}

	// page2
	@RequestMapping(value = "form2", params = "next", method = RequestMethod.POST)
	public String personalInfo2(@ModelAttribute SujanForm2 sujanForm2, Model model) {
		SujanDto sujanDto = new SujanDto();
		sujanDto.setEmail(sujanForm2.getEmail());
		sujanDto.setMobileNo1(sujanForm2.getMobileNo1());
		sujanDto.setMobileNo2(sujanForm2.getMobileNo2());
		sujanDto.setMobileNo3(sujanForm2.getMobileNo3());
		return "sujan/personalInfoForm2";
	}

	// page2 back
	@RequestMapping(value = "form3", params = "back", method = RequestMethod.POST)
	public String personalInfo2Back(@ModelAttribute SujanDto sujanDto, SujanForm1 sujanForm1, Model model) {

		sujanDto.setEmail("");
		sujanDto.setMobileNo1("");
		sujanDto.setMobileNo2("");
		sujanDto.setMobileNo3("");
		return "sujan/personalInfoForm1";
	}

	// entry page3
	@RequestMapping(value = "form3", params = "next", method = RequestMethod.POST)
	public String personalInfo3(@ModelAttribute SujanForm3 sujanForm3, Model model) {

		model.addAttribute("livingSituationList", SujanForm3.getLivingSituationList());
		model.addAttribute("housingLoanButton", SujanForm3.getHousingLoanButton());
		model.addAttribute("drivingLicenseLabelButton", SujanForm3.getDrivingLicenseLabelButton());

		SujanDto dto = new SujanDto();
		dto.setPostNO(sujanForm3.getPostNO());
		dto.setAddress1(sujanForm3.getAddress1());
		dto.setAddress2(sujanForm3.getAddress2());
		dto.setLivingSituation(sujanForm3.getLivingSituation());
		dto.setHousingLoan(sujanForm3.getHousingLoan());
		dto.setDrivingLicenseLabel(sujanForm3.getDrivingLicenseLabel());
		dto.setDrivingLicense(sujanForm3.getDrivingLicense());

		return "sujan/personalInfoForm3";
	}

	// entry page4
	@RequestMapping(value = "form4", params = "next", method = RequestMethod.POST)
	public String personalInfo4(@ModelAttribute SujanForm4 sujanForm4, Model model) {

		return "sujan/personalInfoForm4";
	}

	// page3 back
	@RequestMapping(value = "form4", params = "back", method = RequestMethod.POST)
	public String personalInfo3Back(@ModelAttribute SujanDto sujanDto, SujanForm2 sujanForm2, Model model) {

		sujanDto.setPostNO("");
		sujanDto.setAddress1("");
		sujanDto.setAddress2("");
		sujanDto.setLivingSituation("");
		sujanDto.setHousingLoan("");
		sujanDto.setDrivingLicenseLabel("");
		sujanDto.setDrivingLicense("");

		return "sujan/personalInfoForm2";
	}

	// check page
	@RequestMapping(value = "form5", params = "next", method = RequestMethod.POST)
	public String personalInfo5(@ModelAttribute SujanDto sujanDto, Model model) {

		model.addAttribute("sujanDto", sujanDto);

		return "sujan/confirmationScreen";
	}

	// page4 back
	@RequestMapping(value = "form5", params = "back", method = RequestMethod.POST)
	public String personalInfo4Back(@ModelAttribute SujanDto sujanDto, SujanForm3 sujanForm3, Model model) {

		return "sujan/personalInfoForm3";

	}

	@RequestMapping(value = "sendData", params = "send", method = RequestMethod.POST)
	public String DbInsert(Model model) {
		model.addAttribute("message", "お申し込みが完了しました。");
		return "sujan/thankYou";
	}

}
