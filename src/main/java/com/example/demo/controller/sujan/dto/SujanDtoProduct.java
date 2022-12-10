package com.example.demo.controller.sujan.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SujanDtoProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String productName;
	private String productPrize;
	private String productImage;
	private int productStock;
	
}