package com.example.demo.bishnu.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bishnu.dto.BishnuDto;
import com.example.demo.bishnu.entity.BishnuEntity;
import com.example.demo.bishnu.repo.BishnuRepository;
import com.example.demo.bishnu.service.CreatService;

@Service
public class CreatServiceImpl implements CreatService {

  @Autowired
  private BishnuRepository bishnuRepository;
  
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void insert(BishnuDto bishnuDto) {
    
    BishnuEntity bishnuEntity= new BishnuEntity();
    modelMapper.map(bishnuDto, bishnuEntity);
    
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    String now = date.format(format);
    bishnuEntity.setCreatTime(now);
    bishnuRepository.save(bishnuEntity);
  }
  
}
