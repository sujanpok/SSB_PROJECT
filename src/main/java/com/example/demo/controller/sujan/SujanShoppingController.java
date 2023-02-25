package com.example.demo.controller.sujan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.sujan.dto.CartDto;
import com.example.demo.controller.sujan.entity.SujanProductEntity;
import com.example.demo.controller.sujan.repository.SujanRepositoryProduct;

@Controller
public class SujanShoppingController {
	@Autowired
	SujanRepositoryProduct sujanRepositoryProduct;

	// user Shopping site
	@GetMapping("user/shoppingSite")
	public String userShopping(CartDto cartDto,Model model) {
		List<SujanProductEntity> productList = sujanRepositoryProduct.findAll();
		model.addAttribute("productList", productList);
		init(cartDto);
		model.addAttribute("cartDto", cartDto);
		
		return "sujan/product/shopping/shoppingHome";

	}

	// user Shopping site
	@PostMapping(value = "/shoppingSite/cart")
	public String userShoppingcart(CartDto cartDto,Model model) {
		List<SujanProductEntity> productList = sujanRepositoryProduct.findAll();
		model.addAttribute("productList", productList);
		model.addAttribute("cartDto", cartDto);
		return "sujan/product/shopping/cart";

	}

	

	// user Shopping site
	@GetMapping(value = "/cart")
	public String usercart(Model model) {

		return "sujan/product/shopping/cart";

	}
	
	
	private void init(CartDto cartDto) {
		cartDto.setPName(null);
		cartDto.setPPrize(null);
		cartDto.setPQty(1);
		cartDto.setPTotal(null);
		
		
	}

}
