package com.example.demo.controller.sujan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.entity.SujanLoginEntity;
import com.example.demo.controller.sujan.entity.SujanProductEntity;

@Repository
public interface SujanRepositoryProduct extends JpaRepository<SujanProductEntity, Long> {
	
	public Page<SujanProductEntity> findAll(Pageable pageable);

}
