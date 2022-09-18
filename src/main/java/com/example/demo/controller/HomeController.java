package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
  
  @GetMapping("/")
  public String creatHomer(Model model) {
	  model.addAttribute("title", "SSB_home_page");
    return "home";
  }
  
  @GetMapping("/abouts")
  public String abouts(Model model) {
	  model.addAttribute("title", "SSB_about_page");
	  return "abouts";
	  
  }
  
  @GetMapping("/services")
  public String services(Model model) {
	  model.addAttribute("title", "SSB_sercices_page");
	  return "services";
  }
  

  @GetMapping("/gmail")
  public String sengemail(Model model) {
	  model.addAttribute("title", "SSB_client_support_email_page");
	  return "gmail";
  }
	  


}
