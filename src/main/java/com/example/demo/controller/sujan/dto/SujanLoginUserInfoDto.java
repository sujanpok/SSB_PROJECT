package com.example.demo.controller.sujan.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SujanLoginUserInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int logincountError;
	private boolean adminORNot;
	private String name;
	private long totalAvaliableMoney;
	private long totalUseableMoney;
	private long totalUserdMoney;
	private boolean shoppingCart;
	private String LastloginTime;
	
	
}