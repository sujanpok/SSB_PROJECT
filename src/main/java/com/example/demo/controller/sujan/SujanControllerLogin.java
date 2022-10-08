package com.example.demo.controller.sujan;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.login.LoginForm;
import com.example.demo.controller.sujan.service.SujanService;

@Controller
public class SujanControllerLogin {

	@Autowired
	SujanService sujanService;

	// login page
	@RequestMapping("/sujan/login")
	public String loginPage(@ModelAttribute LoginForm loginForm, Model model) {
		return "sujan/login/userlogin";
	}

	// user welcome page
	@RequestMapping(value = "logined", params = "next", method = RequestMethod.POST)
	public String loginCheckMethod(@ModelAttribute LoginForm loginForm, Model model) {
		SujanDtoLogin login = new SujanDtoLogin();
		login.setUserId(loginForm.getLoginId());
		login.setUserPwd(loginForm.getLoginPw());

		if (sujanService.loginCheck(login)) {
			List<SujanEntity> customersList = sujanService.findAllListCustomer();
			model.addAttribute("customersList", customersList);
			model.addAttribute("message", "welcome home。");
			return "sujan/login/userHome";

		} else {
			model.addAttribute("errormessage", "IDまたはパスワードが間違っています。");
			return "sujan/login/userlogin";
		}

	}

	@GetMapping(value = "logined")
	public String AllList(Model model) {
		List<SujanEntity> customersList = sujanService.findAllListCustomer();
		model.addAttribute("customersList", customersList);
		return "sujan/login/userHome";
	}

	@GetMapping("{id}")
	public String detailUser(@PathVariable Long id, Model model) {
		SujanEntity userList = sujanService.findById(id);
		model.addAttribute("userList", userList);
		return "sujan/login/userDetailAdmin";
	}

	@GetMapping("{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		// ユーザー情報の削除

		sujanService.delete(id);
		return "redirect:/logined";
	}

}
