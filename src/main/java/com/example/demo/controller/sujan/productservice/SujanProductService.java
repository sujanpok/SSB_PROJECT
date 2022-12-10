package com.example.demo.controller.sujan.productservice;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.sujan.dto.SujanDtoProduct;
import com.example.demo.controller.sujan.entity.SujanProductEntity;
import com.example.demo.controller.sujan.repository.SujanRepositoryProduct;

@Service
@Transactional(rollbackFor = Exception.class)
public class SujanProductService {
	
	@Autowired
	SujanRepositoryProduct sujanRepositoryProduct;

	@Autowired
	private ModelMapper modelMapper;
	
	//product insert
	public void insertProduct(SujanDtoProduct sujanDtoProduct) {
		sujanRepositoryProduct.save(insertProductData(sujanDtoProduct));
		
	}
	
	//商品登録する
		public SujanProductEntity insertProductData(SujanDtoProduct sujanDtoProduct) {
			SujanProductEntity sujanProductEntity= new SujanProductEntity();
			modelMapper.map(sujanDtoProduct, sujanProductEntity);
			return sujanProductEntity;
			
		}

	//product list
	
	//ポイント③
    public void delete(Long id) {
    	sujanRepositoryProduct.deleteById(id);
    }

	public SujanProductEntity findById(Long id) {
		return sujanRepositoryProduct.findById(id).get();
	}

	
}
