package com.example.demo.controller.sujan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="entry_table")
public class EntryTable{
	@Id
	private Long id;
	private String name;
	private String email;
	private Integer total_money;
	private String user_id;
}