package com.example.demo.controller.sujan.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.sujan.dto.SujanDto;
import com.example.demo.controller.sujan.dto.SujanDtoLogin;
import com.example.demo.controller.sujan.entity.SujanEntity;
import com.example.demo.controller.sujan.entity.SujanLoginEntity;
import com.example.demo.controller.sujan.mapper.LoginCheck;
import com.example.demo.controller.sujan.repository.SujanRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class SujanService {
	@Autowired
	SujanRepository sujanRepository;

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private LoginCheck checkMapper;

	// insert data entry table
	public void insertData(SujanDto sujanDto) {

		sujanRepository.save(insert(sujanDto));
		sujanRepository.save(insertLogin(sujanDto));
	}

	// date insert

	private SujanEntity insert(SujanDto sujanDto) {
		Date now = new Date();
		SujanEntity dataEntry = new SujanEntity();
		modelMapper.map(sujanDto, dataEntry);
		dataEntry.setCreateDate(now);
		dataEntry.setUpdateDate(now);
		return dataEntry;

	}
	
	//login check
	public boolean loginCheck(SujanDtoLogin login) {

		int count = checkMapper.loginUserCountCheck(login);
		if (count <= 0) {
			int errorcount = 0;
			if (count == 0) {

				for (int i = 0; i < 4; i++) {
					errorcount++;
				}
			}
			login.setCountError(errorcount);
			return false;

		} else {
			return true;
		}

	}
	
	//login table
	private SujanLoginEntity insertLogin(SujanDto sujanDto) {
		Date now = new Date();
		SujanLoginEntity dataEntry = new SujanLoginEntity();
		modelMapper.map(sujanDto, dataEntry);
		dataEntry.setCreateDate(now);
		dataEntry.setUpdateDate(now);
		return dataEntry;

	}
	
	//all list
	public List<SujanEntity> findAllListCustomer() {
        return sujanRepository.findAll();
    }
	
	//ポイント②
    public void update(SujanDto sujanDto) {
    	sujanRepository.save(sujanDto);
    }
    
    
  //ポイント③
    public void delete(Long id) {
    	sujanRepository.deleteById(id);
    }

	public SujanEntity findById(Long id) {
		return sujanRepository.findById(id).get();
	}
}
