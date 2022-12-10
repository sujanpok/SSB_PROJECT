package com.example.demo.controller.sujan.entity;

import java.io.Serializable;
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
@Table(name = "product_table")
public class SujanProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id" ,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_Name")
	private String productName;
	
	@Column(name = "product_Prize")
	private String productPrize;
	
	@Column(name = "product_Image")
	private String productImage;
	
	@Column(name = "product_Stock")
	private int productStock;
	
}