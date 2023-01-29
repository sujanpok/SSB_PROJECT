package com.example.demo.controller.sujan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.sujan.dto.SujanDtoProduct;
import com.example.demo.controller.sujan.entity.SujanProductEntity;
import com.example.demo.controller.sujan.product.ProductForm;
import com.example.demo.controller.sujan.productservice.SujanProductService;
import com.example.demo.controller.sujan.repository.SujanRepositoryProduct;

@Controller
public class SujanControllerProduct {
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir")+"/src/main/resources/static/img/sujan/productImg";
	@Autowired
	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	SujanRepositoryProduct sujanRepositoryProduct;

	@Autowired
	SujanProductService SujanProductService;

	// product home page
	@RequestMapping("product/allList/{page}")
	public String productHomepage(@ModelAttribute ProductForm productForm, @PathVariable("page") int page,
			Model model) {
		// 初期化
		init(productForm);
		// current page-page
		// contact per page-10
		// int page1=0;
		Pageable pageable = PageRequest.of(page, 5);
		Page<SujanProductEntity> productListpage = this.sujanRepositoryProduct.findAll(pageable);
		List<SujanProductEntity>productList=sujanRepositoryProduct.findAll();
		model.addAttribute("productListcount", productList.size());
		model.addAttribute("productList", productListpage);
		model.addAttribute("productList", productListpage);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", productListpage.getTotalPages());
		return "sujan/product/allProductList";
	}

	private void init(ProductForm productForm) {
		productForm.setProductImageName(null);
		productForm.setProductImageUrl(null);
		productForm.setProductName("");
		productForm.setProductPrize(null);
		productForm.setProductStock(0);
	}

	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductForm productForm, SujanDtoProduct sujanDtoProduct, Model model,
			@RequestParam("image") MultipartFile file)throws IOException  {
		
		//image upload
		StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
		// data marge
        sujanDtoProduct.setProductImageName(file.getOriginalFilename());
        sujanDtoProduct.setProductImageUrl("/img/sujan/productImg/"+file.getOriginalFilename().toString().trim());
		modelMapper.map(sujanDtoProduct, productForm);
		// 商品情報の登録
		SujanProductService.insertProduct(sujanDtoProduct);

		return "redirect:product/allList/0";
	}

	@GetMapping("product/allList/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		// ユーザー情報の削除

		SujanProductService.delete(id);
		return "redirect:/product/allList/0";

	}
}
