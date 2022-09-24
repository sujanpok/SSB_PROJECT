package com.example.demo.bishnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.bishnu.model.LoginForm1;
import com.example.demo.bishnu.model.LoginForm3;

@Controller
@RequestMapping("/bishnu")
public class BishnuLoginController {
  
  @PostMapping("/chooseCard")
  public String cardChoose(Model model) {
    model.addAttribute("title", "SSB_Card_Choose");
    return "login/chooseCard";
  }
  
  @PostMapping("/login_page1")
  public String loginPage1(LoginForm1 loginForm1, Model model) {
    model.addAttribute("title", "SSB_login_page1");
    model.addAttribute("year", LoginForm1.yearMap());
    model.addAttribute("month", LoginForm1.getMonth());
    model.addAttribute("day", LoginForm1.getDay());
    model.addAttribute("gender", LoginForm1.getByGender());
    return "bishnu/login_page1";
  }
  
  @RequestMapping(value = "/login_page2", params = "next", method = RequestMethod.POST)
  public String loginPage2(Model model) {
    model.addAttribute("title", "SSB_login_page2");
    return "bishnu/login_page2";
  }

  @RequestMapping(value = "/login_page1", params = "back", method = RequestMethod.POST)
  public String loginPageReturn1(Model model) {
    model.addAttribute("title", "SSB_login_page2");
    return "bishnu/login_page1";
  }
  
  @PostMapping("/login_page3")
  public String loginPage3(LoginForm3 loginForm3, Model model) {
    model.addAttribute("title", "SSB_login_page3");
    model.addAttribute("livingCondition", LoginForm3.getLivingCondition());
    return "bishnu/login_page3";
  }
  
  @PostMapping("/login_page4")
  public String loginPage4(Model model) {
    model.addAttribute("title", "SSB_login_page4");
    return "bishnu/login_page4";
  }
  
  @PostMapping("/login_conform_page")
  public String login_conform_page(Model model) {
    model.addAttribute("title", "SSB_login_conform");
    return "bishnu/login_conform_page";
  }
  
  @PostMapping("/login_success_page")
  public String login_success_page(Model model) {
    model.addAttribute("title", "SSB_login_success");
    return "bishnu/login_success_page";
  }
  
  @GetMapping("/login_success_home")
  public String login_success_home_page(Model model) {
    model.addAttribute("title", "SSB_home_page");
    return "home";
  }
}
