package com.example.demo.controller.sujan.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.sujan.entity.SujanEntity;

@Repository
public class SujanRepositoryLogin {
	@Autowired
	private EntityManager entityManager;

	public List<SujanEntity> findOneUserAllDetail(String string) {

		String jpql = "SELECT a.name, a.email FROM entry_table a";

		TypedQuery<SujanEntity> query = entityManager.createQuery(jpql, SujanEntity.class);

		return query.getResultList();

	}
}
