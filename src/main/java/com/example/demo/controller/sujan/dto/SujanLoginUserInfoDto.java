package com.example.demo.controller.sujan.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SujanLoginUserInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int logincountError;
	private boolean adminORNot;
	private String name;
	private String userId;
	private String userPwd;
	
	private Long account_no;
	private String email;
	private Integer total_money;
	private Integer aval_money;
	private Integer used_money;
	
	
}