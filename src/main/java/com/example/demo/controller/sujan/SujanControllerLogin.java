package com.example.demo.controller.sujan;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.dto.SujanLoginUserInfoDto;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.login.LoginForm;
import com.example.demo.controller.sujan.repository.SujanRepository;
import com.example.demo.controller.sujan.repository.SujanRepositoryLogin;
import com.example.demo.controller.sujan.service.SujanService;

@Controller
public class SujanControllerLogin {
	@Autowired
	SujanService sujanService;

	@Autowired
	SujanRepository sujanRepository;
	@Autowired
	private SujanRepositoryLogin sujanRepositoryLogin;
	@Autowired
	private ModelMapper modelMapper;

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
			
			
			//login admin
			if (login.getUserId().equals("admin")) {

				model.addAttribute("message", "welcome home!");
				return "sujan/login/adminHome";
				//user
			} else {
				
				// ユーザー情報
				SujanLoginUserInfoDto user =  new SujanLoginUserInfoDto();
				user.setUserId(login.getUserId());
				user.setUserId(login.getUserPwd());
				// ユーザー検索
				
				List<SujanEntity> LoginUserInfo= new ArrayList<SujanEntity>();
				LoginUserInfo = sujanRepositoryLogin.findOneUserAllDetail(user.getUserId());
				//model.addAttribute("userDetailList", userList);
				return "sujan/login/userHome";
			}
			
			//error
		} else {
			model.addAttribute("errormessage", "IDまたはパスワードが間違っています。");
			return "sujan/login/userlogin";
		}

	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		return "sujan/login/adminHome";
	}

	@GetMapping("allList/{page}")
	public String showContact(@PathVariable("page") int page, Model model) {
		// current page-page
		// contact per page-5
		Pageable pageable = PageRequest.of(page, 5);
		Page<SujanEntity> contacts = this.sujanRepository.findAll(pageable);
		List<SujanEntity>registerList=sujanRepository.findAll();
		model.addAttribute("registerList", registerList.size());
		model.addAttribute("contacts", contacts);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", contacts.getTotalPages());
		return "sujan/login/allUserList";
	}

	@RequestMapping(value = "allList/detail/{id}", method = RequestMethod.GET)
	public String detailUser(@PathVariable Long id, Model model) {
		SujanEntity userList = sujanService.findById(id);
		model.addAttribute("userList", userList);
		return "sujan/login/userDetailAdmin";
	}

	@GetMapping("allList/detail/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		// ユーザー情報の削除

		sujanService.delete(id);
		return "redirect:/allList/0";

	}

	// csv download
	@GetMapping("/csv")
	public String csvDownload() {
		return null;

	}

	// pdf download
	@GetMapping("/pdf")
	public String pdfDownload() {
		return null;

	}

}
