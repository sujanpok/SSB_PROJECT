package com.example.demo.controller.sujan;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.login.LoginForm;

@Controller
public class SujanControllerLogin {
@Autowired
ModelMapper modelMapper = new ModelMapper();
	// first page
	@RequestMapping("/sujan/login")

	public String welcomePage(LoginForm loginForm) {
		return "sujan/login/userlogin";
	}



}
