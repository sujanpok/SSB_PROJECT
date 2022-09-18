package com.example.demo.controller.sujan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.form.SujanForm1;
import com.example.demo.controller.sujan.form.SujanForm2;
import com.example.demo.controller.sujan.form.SujanForm3;

@Controller
public class SujanController {
	@GetMapping("/sujan")
	public String welcomePage() {
		return "sujan/welcome_page";
	}
	@GetMapping("sujan/form1")
public String personalInfo1(@ModelAttribute SujanForm1 sujanForm1) {
		
		SujanDto dto = new SujanDto();
	return "sujan/personalInfoForm1";
}
	@PostMapping("sujan/form2")
	public String personalInfo2(@ModelAttribute SujanForm2 sujanForm2) {
		SujanDto dto = new SujanDto();
		return "sujan/personalInfoForm2";
	}
	@PostMapping("sujan/form3")
	public String personalInfo3(@ModelAttribute SujanForm3 sujanForm3) {
		SujanDto dto = new SujanDto();
		return "sujan/personalInfoForm3";
	}
	@PostMapping("sujan/confirmation")
	public String confirmationScreen(@ModelAttribute SujanDto sujanDto) {
		return "sujan/confirmationScreen";
	}
	@PostMapping("sujan/insertDb")
	public String DbInsert(@ModelAttribute SujanDto sujanDto) {
		return "sujan/thankYou";
	}
	
	
}
