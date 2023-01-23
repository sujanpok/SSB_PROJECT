package com.example.demo.controller.sujan.entity;

import java.io.Serializable;
import java.util.List;

public interface UserLoginInfoDao extends Serializable{
	public List<EntryloginInfoTable> findAllLoginDetailWithLoginID(String loginId);
}