package com.example.demo.controller.sujan.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SujanDtoLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String userId;
	private String pwd;
}