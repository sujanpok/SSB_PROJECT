package com.example.demo.controller.sujan.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.controller.sujan.dto.SujanDtoLogin;

@Mapper
public interface LoginCheck {
	//login check
	int loginUserCountCheck(SujanDtoLogin sujanDtoLogin);
	
	
	int loginUsercheck(SujanDtoLogin sujanDtoLogin);
	
	//update
	Object loginUserUpdate(SujanDtoLogin sujanDtoLogin);
	//set lats time login
	Object lastloginUserTime(SujanDtoLogin sujanDtoLogin);
	
	//get  login error count
	SujanDtoLogin countErrorUser(SujanDtoLogin sujanDtoLogin);
	
	//set  login error count per each 
	SujanDtoLogin countErrorSetUser(SujanDtoLogin sujanDtoLogin);
	
	
	//userLogin data
	//public List<SujanLoginUserInfoDto> searchUser(SujanLoginUserInfoDto user);
	//public List<MUser> findAllMUser();
	
	
}
