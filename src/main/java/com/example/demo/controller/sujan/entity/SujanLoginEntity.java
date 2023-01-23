package com.example.demo.controller.sujan.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "login_table")
public class SujanLoginEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id" ,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private String userId;
	/**
	 * パスワード
	 */
	@Column(name = "pwd")
	private String pwd;
	
    private boolean isAdmin;
    private String email;
	
	
	private Date loginLockTime;
	private Date LastLoginTime;
	private int countError;
	
	
	@Column(name = "update_date")
	private Date updateDate;
	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;
	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;
}
