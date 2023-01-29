package com.example.demo.controller.sujan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.dto.SujanLoginUserInfoDto;
import com.example.demo.controller.sujan.entity.EntryloginInfoTable;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.entity.SujanProductEntity;
import com.example.demo.controller.sujan.login.LoginForm;
import com.example.demo.controller.sujan.repository.SujanRepository;
import com.example.demo.controller.sujan.repository.SujanRepositoryLoginDetail;
import com.example.demo.controller.sujan.repository.SujanRepositoryProduct;
import com.example.demo.controller.sujan.service.SujanService;

@Controller
public class SujanControllerLogin {
	public static int loginerrorLock = 4;
	@Autowired
	SujanService sujanService;
	
	@Autowired
	  HttpSession session; 

	@Autowired
	SujanRepository sujanRepository;
	@PersistenceContext
	EntityManager entityManager;

	SujanRepositoryLoginDetail userLoginInfoDao;
	
	@Autowired
	SujanRepositoryProduct sujanRepositoryProduct;

	@PostConstruct
	public void init() {
		userLoginInfoDao = new SujanRepositoryLoginDetail(entityManager);
	}

	// login page
	@RequestMapping("/sujan/login")
	public String loginPage(@ModelAttribute LoginForm loginForm, Model model) {
		return "sujan/login/userlogin";
	}
	
	
	
	// logout page
	@RequestMapping("sujan/logout")
	public String logoutPage(@ModelAttribute LoginForm loginForm, Model model) {
		
		session.invalidate(); // クリア
		return "sujan/login/userlogin";
	}

	// user welcome page
	@RequestMapping(value = "logined", params = "next", method = RequestMethod.POST)
	public String loginCheckMethod(@ModelAttribute LoginForm loginForm,RedirectAttributes redirectAttributes, Model model) {
		SujanDtoLogin login = new SujanDtoLogin();
		login.setUserId(loginForm.getLoginId());
		login.setUserPwd(loginForm.getLoginPw());

		if (sujanService.loginCheck(login)) {

			// login admin
			if (login.getUserId().equals("admin")) {

				model.addAttribute("message", "welcome home!");
				return "sujan/login/adminHome";
				// user
			} else {
				 ModelMap modelMap = new ModelMap();
				 modelMap.addAttribute("mydata", login);
				 session.setAttribute("mydata", login);
				 redirectAttributes.addFlashAttribute("model", modelMap);
				
				//model.addAttribute("login", login);
				//model.addAttribute("userDetail", user);
				return "redirect:/userHome";
				//return "sujan/login/userHome";
			}

			// error
		} else {

			if ("lock".equals(login.getStatus())) {
				model.addAttribute("errormessage", "アカウントロックされました。30分後再ログインお願いいたします。");
			} else if ("notFound".equals(login.getStatus())) {
				model.addAttribute("errormessage", "IDが登録されていません！！");
			} else if ("wrong".equals(login.getStatus())) {
				model.addAttribute("errormessage", "IDまたはパスワードが間違っています。");
			}else if("remainTime".equals(login.getStatus())) {
				model.addAttribute("errormessage", "まだ30分超えていません");
			}
		}
		return "sujan/login/userlogin";

	}
	
	@GetMapping("/userHome")
	 public String sample(@ModelAttribute("model")ModelMap modelMap, Model model) {
		
		//String data = session.getAttribute("mydata");  // 取得
		SujanDtoLogin login = (SujanDtoLogin) session.getAttribute("mydata");  // 取得
		// ユーザー情報
		SujanLoginUserInfoDto user = new SujanLoginUserInfoDto();
		user.setUserId(login.getUserId());
		user.setUserPwd(login.getUserPwd());

		
		// ユーザー検索

		List<EntryloginInfoTable> loginUserInfo = new ArrayList<EntryloginInfoTable>();
		// LoginUserInfo = sujanRepositoryLogin.findOneUserAllDetail(user.getUserId());
		loginUserInfo = userLoginInfoDao.findAllLoginDetailWithLoginID(user.getUserId());
		
		for (EntryloginInfoTable ele : loginUserInfo) {
			user.setName(ele.getName());
			user.setEmail(ele.getEmail());
			user.setAccount_no(ele.getAccount_no());
			user.setTotal_money(ele.getTotal_money());
			user.setAval_money(ele.getAval_money());
			user.setUsed_money(ele.getUsed_money());
			
		}
	
		
		model.addAttribute("login", login);
		model.addAttribute("userDetail", user);
	      return "sujan/login/userHome";
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
		List<SujanEntity> registerList = sujanRepository.findAll();
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
	
	//user Shopping site
	@GetMapping("user/shoppingSite")
	public String userShopping(Model model) {
		List<SujanProductEntity>productList=sujanRepositoryProduct.findAll();
		model.addAttribute("productList", productList);
		
		
		return "sujan/product/shopping/shoppingHome";

	}
	
	//user Shopping site
		@GetMapping("user/user/shoppingSite/cart")
		public String userShoppingcart(Model model) {
			
			return "sujan/product/shopping/cart";

		}
		
	
	@GetMapping("/returnHome")
	public String returnHome(Model model) {
		
		return "redirect:/userHome";

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
