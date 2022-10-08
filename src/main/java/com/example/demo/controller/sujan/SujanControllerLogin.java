package com.example.demo.controller.sujan;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.ValidationSeq.All;
import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.form.SujanForm1;
import com.example.demo.controller.sujan.form.SujanForm2;
import com.example.demo.controller.sujan.login.LoginForm;
import com.example.demo.controller.sujan.service.SujanService;

@Controller
public class SujanControllerLogin {

	@Autowired
	SujanService sujanService;
	// login page
	@RequestMapping("/sujan/login")
	public String loginPage(@ModelAttribute LoginForm loginForm,Model model) {
		return "sujan/login/userlogin";
	}
	// user welcome page
		@RequestMapping(value = "logined", params = "next",method = RequestMethod.POST)
		public String loginCheckMethod(@ModelAttribute LoginForm loginForm, Model model) {
			SujanDtoLogin login =new SujanDtoLogin();
					login.setUserId(loginForm.getLoginId());
			login.setUserPwd(loginForm.getLoginPw());
			
			
			
			if (sujanService.loginCheck(login)) {
				model.addAttribute("message", "welcome home。");
				return "sujan/login/userHome";
			} else {
				model.addAttribute("errormessage", "IDまたはパスワードが間違っています。");
				return "sujan/login/userlogin";
			}

		}

}
