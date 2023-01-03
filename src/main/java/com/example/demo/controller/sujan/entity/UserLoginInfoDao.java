package com.example.demo.controller.sujan.entity;

import java.io.Serializable;
import java.util.List;

public interface UserLoginInfoDao<T> extends Serializable{
	public List<T> findAllLoginDetailWithLoginID(String LoginID);
}