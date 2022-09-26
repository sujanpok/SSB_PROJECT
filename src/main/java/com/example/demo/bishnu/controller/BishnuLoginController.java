package com.example.demo.bishnu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.bishnu.dto.BishnuDto;
import com.example.demo.bishnu.model.ChooseCard;
import com.example.demo.bishnu.model.LoginForm1;
import com.example.demo.bishnu.model.LoginForm2;
import com.example.demo.bishnu.model.LoginForm3;
import com.example.demo.bishnu.model.LoginForm4;


@Controller
@SessionAttributes(value = "bishnuDto", types = BishnuDto.class)
@RequestMapping("/bishnu")
public class BishnuLoginController {
  
  @Autowired
  private ModelMapper modelMapper;
  
  //Choose card page open
  @PostMapping("/chooseCard")
  public String cardChoose(ChooseCard chooseCard, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_Card_Choose");
    this.modelMapper.map(bishnuDto, chooseCard);
    return "login/chooseCard";
  }
  
  //login Page1 open
  @PostMapping("/login_page1")
  public String loginPage1(LoginForm1 loginForm1, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_login_page1");
    model.addAttribute("year", LoginForm1.yearMap());
    model.addAttribute("month", LoginForm1.getMonth());
    model.addAttribute("day", LoginForm1.getDay());
    model.addAttribute("gender", LoginForm1.getByGender());
    this.modelMapper.map(bishnuDto, loginForm1);
    return "bishnu/login_page1";
  }
  
  //Login Page 2 open (click Next button from login page1)
  @RequestMapping(value = "/login_page2", params = "next", method = RequestMethod.POST)
  public String loginPage2(@Valid LoginForm1 loginForm1, BindingResult result, LoginForm2 loginForm2, BishnuDto bishnuDto, Model model) {
   
    if(result.hasErrors()){
      model.addAttribute("title", "SSB_login_page1");
      model.addAttribute("year", LoginForm1.yearMap());
      model.addAttribute("month", LoginForm1.getMonth());
      model.addAttribute("day", LoginForm1.getDay());
      model.addAttribute("gender", LoginForm1.getByGender());
      model.addAttribute("message", "お手数ですが、赤字コメント項目をご確認いただき再入力をお願い致します。");
      this.modelMapper.map(bishnuDto, loginForm1);
      return "bishnu/login_page1";
        }
    model.addAttribute("title", "SSB_login_page2");
    this.modelMapper.map(bishnuDto, loginForm2);
    return "bishnu/login_page2";
  }

  //Choose card page open (click back button from login page1)
  @RequestMapping(value = "/login_page2", params = "back", method = RequestMethod.POST)
  public String loginPageReturn1(LoginForm2 loginForm2, ChooseCard chooseCard, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_login_chooseCard");
    this.modelMapper.map(bishnuDto, chooseCard);
    return "login/chooseCard";
  }
  
  //Login Page 3 open (click Next button from login page 2 )
  @RequestMapping(value = "/login_page3", params = "next", method = RequestMethod.POST)
  public String loginPage3(@Valid LoginForm2 loginForm2, BindingResult result, LoginForm3 loginForm3, BishnuDto bishnuDto, Model model) {
    
    if(result.hasErrors()){
      model.addAttribute("title", "SSB_login_page2");
      model.addAttribute("message", "お手数ですが、赤字コメント項目をご確認いただき再入力をお願い致します。");
      return "bishnu/login_page2";
    }
    model.addAttribute("title", "SSB_login_page3");
    model.addAttribute("livingCondition", LoginForm3.getLivingCondition());
    this.modelMapper.map(bishnuDto, loginForm3);
    return "bishnu/login_page3";
  }
  
  //Login Page 1 open (click Back button from login page 2 )
  @RequestMapping(value = "/login_page3", params = "back", method = RequestMethod.POST)
  public String loginPageReturn1(LoginForm1 loginForm1, LoginForm2 loginForm2, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_login_page1");
    model.addAttribute("year", LoginForm1.yearMap());
    model.addAttribute("month", LoginForm1.getMonth());
    model.addAttribute("day", LoginForm1.getDay());
    model.addAttribute("gender", LoginForm1.getByGender());
    this.modelMapper.map(bishnuDto, loginForm1);
    return "bishnu/login_page1";
  }
  
  //Login Page 4 open (click Next button from login page 3)
  @RequestMapping(value = "/login_page4", params = "next", method = RequestMethod.POST)
  public String loginPage4(@Valid LoginForm3 loginForm3, BindingResult result, LoginForm4 loginForm4, BishnuDto bishnuDto, Model model) {
    if(result.hasErrors()) {
      model.addAttribute("title", "SSB_login_page3");
      model.addAttribute("livingCondition", LoginForm3.getLivingCondition());
      model.addAttribute("message", "お手数ですが、赤字コメント項目をご確認いただき再入力をお願い致します。");
      return "bishnu/login_page3";
    }
    model.addAttribute("title", "SSB_login_page4");
    this.modelMapper.map(bishnuDto, loginForm4);
    return "bishnu/login_page4";
  }
  
  //Login Page 2 open (click back button from login page 3)
  @RequestMapping(value = "/login_page4", params = "back", method = RequestMethod.POST)
  public String loginPageReturn2(LoginForm3 loginForm3, LoginForm2 loginForm2, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_login_page2");
    this.modelMapper.map(bishnuDto, loginForm2);
    return "bishnu/login_page2";
  }
  
  //Login conform page open (click next button from login login page 4)
  @RequestMapping(value = "/login_conform_page", params = "next", method = RequestMethod.POST)
  public String login_conform_page(@Valid LoginForm4 loginForm4, BindingResult result, BishnuDto bishnuDto, Model model) {
   if(result.hasErrors()) {
     model.addAttribute("title", "SSB_login_page4");
     model.addAttribute("message", "お手数ですが、赤字コメント項目をご確認いただき再入力をお願い致します。");
     return "bishnu/login_page4";
   }
    
    if(loginForm4.getPassword().equals(loginForm4.getRe_password())) {
      model.addAttribute("title", "SSB_login_conform");
    this.modelMapper.map(bishnuDto, loginForm4);
    return "bishnu/login_conform_page";
  } else {
    model.addAttribute("title", "SSB_login_page4");
    model.addAttribute("message1", "Please enter a same password....");
    return "bishnu/login_page4";
  }
  }
  
  //Login page 3 open (click back button from login login page 4)
  @RequestMapping(value = "/login_conform_page", params = "back", method = RequestMethod.POST)
  public String login_conform_pageReturn(BishnuDto bishnuDto, LoginForm3 loginForm3, Model model) {
    model.addAttribute("title", "SSB_login_page3");
    model.addAttribute("livingCondition", LoginForm3.getLivingCondition());
    this.modelMapper.map(bishnuDto, loginForm3);
    return "bishnu/login_page3";
  }
  
  //Login Success page open (click next button from login conform page)
  @RequestMapping(value = "/login_success_page", params = "next", method = RequestMethod.POST)
  public String login_success_page(BishnuDto bishnuDto,  Model model) {
    model.addAttribute("title", "SSB_login_success");
    model.addAttribute("bishnuDto", bishnuDto);
    return "bishnu/login_success_page";
  }
  
  //Login  page 4 open (click back button from login conform page)
  @RequestMapping(value = "/login_success_page", params = "back", method = RequestMethod.POST)
  public String login_success_pageReturn(LoginForm4 loginForm4, BishnuDto bishnuDto, Model model) {
    model.addAttribute("title", "SSB_login_page4");
    this.modelMapper.map(bishnuDto, loginForm4);
    return "bishnu/login_page4";
  }
  
  @GetMapping("/login_success_home")
  public String login_success_home_page(BishnuDto bishnuDto, HttpSession session, SessionStatus status, Model model) {
    model.addAttribute("title", "SSB_home_page");
    //db insert
    
    status.setComplete();
    session.removeAttribute("bishnuDto");
    return "home";
  }
}
