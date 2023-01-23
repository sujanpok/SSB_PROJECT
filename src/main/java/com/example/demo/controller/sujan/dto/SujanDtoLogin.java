package com.example.demo.controller.sujan.dto;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.Data;

@Data
public class SujanDtoLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String userId;
	private String userPwd;
	
	private int countError;
	private boolean loginSucess;
	
	//login error status
	private String status;
	private Date loginLockTime;
	private Date lastLoginTime;
	
	
	private  int remainTimeToUnlock;
}