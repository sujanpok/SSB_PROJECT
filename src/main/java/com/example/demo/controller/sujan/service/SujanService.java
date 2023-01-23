
package com.example.demo.controller.sujan.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public static Integer getnull= null;
	@Autowired
	SujanRepository sujanRepository;

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private LoginCheck checkMapper;
	private int errorcount;

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

	// login check
	
	public boolean loginCheck(SujanDtoLogin login) {
		int userFound = checkMapper.loginUsercheck(login);
		if (userFound <= 0) {
			login.setLoginSucess(false);
			login.setStatus("notFound");
			return false;
		} else {
			//login check
			int count = checkMapper.loginUserCountCheck(login);
			
			//error count check
			SujanDtoLogin loginDto= checkMapper.countErrorUser(login);
			// loginCount
			if (count <= 0) {
				errorcount=loginDto.getCountError();
				errorcount++;
				login.setCountError(errorcount);
				//insert error count
				checkMapper.countErrorSetUser(login);
				
				
				//4回以上
				if (login.getCountError() >= 4) {
					erroLoginTime(login);
					checkMapper.loginUserUpdate(login);
					login.setLoginSucess(false);
					login.setStatus("lock");
					return false;
				}
				login.setLoginSucess(false);
				login.setStatus("wrong");
				return false;

			} else {
				Date date =  new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.MINUTE, -1);
				
				if (loginDto.getLoginLockTime().after(calendar.getTime())) {
					lastLoginTime(login);
					checkMapper.lastloginUserTime(login);
					login.setCountError(0);
					
					login.setStatus("ok");
					login.setLoginSucess(true);
					//insert error count
					checkMapper.countErrorSetUser(login);
					return true;
				} else {
					login.setLoginSucess(false);
					login.setStatus("remainTime");
					return false;
				}
				
			}

		}
	}

	// error login time

	private void erroLoginTime(SujanDtoLogin login) {
		SujanLoginEntity dataEntry = new SujanLoginEntity();
		// after 30 minute unlock login
		Date date =  new Date();
		login.setLoginLockTime(date);
		dataEntry.setLoginLockTime(login.getLoginLockTime());
	}
	
	
	
	//last login time 
	private void lastLoginTime(SujanDtoLogin login) {
		SujanLoginEntity dataEntry = new SujanLoginEntity();
		// after 30 minute unlock login
		Date date =  new Date();
		login.setLastLoginTime(date);
		dataEntry.setLastLoginTime(login.getLastLoginTime());
	}

	// login table
	private SujanLoginEntity insertLogin(SujanDto sujanDto) {
		Date now = new Date();
		SujanLoginEntity dataEntry = new SujanLoginEntity();
		modelMapper.map(sujanDto, dataEntry);
		dataEntry.setCreateDate(now);
		dataEntry.setUpdateDate(now);
		return dataEntry;

	}

	// all list
	public List<SujanEntity> findAllListCustomer() {
		return sujanRepository.findAll();
	}

	// ポイント②
	public void update(SujanDto sujanDto) {
		sujanRepository.save(sujanDto);
	}

	// ポイント③
	public void delete(Long id) {
		sujanRepository.deleteById(id);
	}

	public SujanEntity findById(Long id) {
		return sujanRepository.findById(id).get();
	}

}
