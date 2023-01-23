package com.example.demo.controller.sujan.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.demo.controller.sujan.entity.EntryloginInfoTable;
import com.example.demo.controller.sujan.entity.UserLoginInfoDao;

@Repository
public class SujanRepositoryLoginDetail{
	
	/**
	 * 
	 */
	private EntityManager entityManager;
	
	public SujanRepositoryLoginDetail(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@SuppressWarnings("unchecked")
	public List<EntryloginInfoTable> findAllLoginDetailWithLoginID(String loginId) {
		
		List<EntryloginInfoTable> list = entityManager.createQuery("SELECT f FROM EntryloginInfoTable f WHERE f.user_id = :loginID")
				.setParameter("loginID",loginId)
				.getResultList();
		return list;
	}
}
