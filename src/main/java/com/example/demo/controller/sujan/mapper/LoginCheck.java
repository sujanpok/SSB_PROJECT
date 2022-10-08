package com.example.demo.controller.sujan.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.controller.sujan.dto.SujanDtoLogin;

@Mapper
public interface LoginCheck {
	//login check
	int loginUserCountCheck(SujanDtoLogin sujanDtoLogin);
	
	
	
}
