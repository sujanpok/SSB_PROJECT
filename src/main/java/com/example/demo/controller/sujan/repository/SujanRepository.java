package com.example.demo.controller.sujan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.entity.SujanLoginEntity;

@Repository
public interface SujanRepository extends JpaRepository<SujanEntity, Long> {

	void save(SujanLoginEntity insertLogin);

	//void insertError(SujanLoginEntity logincount);

}
