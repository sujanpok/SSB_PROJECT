package com.example.demo.controller.sujan.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.demo.controller.sujan.entity.EntryTable;
import com.example.demo.controller.sujan.entity.UserLoginInfoDao;

@Repository
public class SujanRepositoryLoginDetail implements UserLoginInfoDao<EntryTable> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	
	public SujanRepositoryLoginDetail(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<EntryTable> findAllLoginDetailWithLoginID(String loginID) {
		@SuppressWarnings("unchecked")
		List<EntryTable> list = entityManager.createQuery("SELECT f.name,f.email,f.total_money FROM EntryTable f WHERE f.user_id = :loginID")
				.setParameter("loginID",loginID)
				.getResultList();
		return list;
	}
}
