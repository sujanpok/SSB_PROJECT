package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bishnu")
public class BishnuLoginController {
  
  @PostMapping("/chooseCard")
  public String cardChoose(Model model) {
    model.addAttribute("title", "SSB_Card_Choose");
    return "login/chooseCard";
  }
  
  @PostMapping("/login_page1")
  public String loginPage1(Model model) {
    model.addAttribute("title", "SSB_login_page1");
    return "login/login_page1";
  }
  

}
