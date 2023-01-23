package com.example.demo.controller.sujan.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="entry_login_info_table")
public class EntryloginInfoTable{
	/**
	 * 
	 */
	@Id
	@Column(name = "id" ,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long account_no;
	private String name;
	private String email;
	private Integer total_money;
	private Integer aval_money;
	private Integer used_money;
	private String user_id;
}
