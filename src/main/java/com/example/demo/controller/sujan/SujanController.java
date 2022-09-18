package com.example.demo.controller.sujan;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.form.SujanForm1;
import com.example.demo.controller.sujan.form.SujanForm2;
import com.example.demo.controller.sujan.form.SujanForm3;

@Controller
public class SujanController {
	//gender
    private Map<String, String> genderItem;

    private Map<String, String> initRadioGender() {
        Map<String, String> radio = new LinkedHashMap<>();
        radio.put("0", "男性");
        radio.put("1", "女性");
        return radio;
    }
    
    
    
    
	@GetMapping("/sujan")
	public String welcomePage() {
		return "sujan/welcome_page";
	}
	@GetMapping("sujan/form1")
public String personalInfo1(SujanForm1 sujanForm1, Model model) {
	
		
		genderItem = initRadioGender();
        model.addAttribute("genderItem", genderItem);
        //male
        sujanForm1.setGender("0");
        sujanForm1.setNationality(true);
        model.addAttribute("sujanForm1", sujanForm1);
        
    
		
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
