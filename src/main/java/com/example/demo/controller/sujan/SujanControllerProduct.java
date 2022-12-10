package com.example.demo.controller.sujan;

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

import com.example.demo.controller.sujan.dto.SujanDtoProduct;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.entity.SujanProductEntity;
import com.example.demo.controller.sujan.product.ProductForm;
import com.example.demo.controller.sujan.productservice.SujanProductService;
import com.example.demo.controller.sujan.repository.SujanRepositoryProduct;

@Controller
public class SujanControllerProduct {
	@Autowired
	ModelMapper modelMapper = new ModelMapper();
	
	
	@Autowired
	SujanRepositoryProduct sujanRepositoryProduct;
	
	@Autowired
	SujanProductService SujanProductService;
	
	//product home page
	@RequestMapping("product/allList/{page}")
	public String productHomepage(@ModelAttribute ProductForm productForm,@PathVariable("page") int page,Model model) {
		//初期化
		init(productForm);
		//current page-page
	    //contact per page-10
		   Pageable pageable= PageRequest.of(page, 10);
		   Page<SujanProductEntity>productList=this.sujanRepositoryProduct.findAll(pageable);
		   model.addAttribute("productList", productList);
		   model.addAttribute("currentPage", page);
		   model.addAttribute("totalPage", productList.getTotalPages());
		
		
		return "sujan/product/allProductList";
	}
	private void init(ProductForm productForm) {
		productForm.setProductImage("");
		productForm.setProductName("");
		productForm.setProductPrize("");
		productForm.setProductStock(0);
	}
	@RequestMapping(value ="/addProduct",params = "send", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductForm productForm,SujanDtoProduct sujanDtoProduct,Model model) {
		
		//data marge
		modelMapper.map(sujanDtoProduct, productForm);
		// 商品情報の登録
		SujanProductService.insertProduct(sujanDtoProduct);
		
		
		return "redirect:product/allList/0";
	}
	
	@RequestMapping(value = "product/allList/detail/{id}", method = RequestMethod.GET)
	public String detailProduct(@PathVariable Long id, Model model) {
		SujanProductEntity productList = SujanProductService.findById(id);
		model.addAttribute("productList", productList);
		return "sujan/login/productDetail";
	}

	@GetMapping("product/detail/{id}/delete")
	public String deleteProduct(@PathVariable Long id, Model model) {
		// ユーザー情報の削除

		SujanProductService.delete(id);
		return "redirect:product/allList/0";

	}
	
}


