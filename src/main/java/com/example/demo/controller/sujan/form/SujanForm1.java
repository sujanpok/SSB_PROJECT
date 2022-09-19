package com.example.demo.controller.sujan.form;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;



@Data

public class SujanForm1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100桁以内で入力してください")
    private String name; 
	
    private String gender;
	
    private boolean nationality;
	
    private String merriageSts;
	
    private  String dateOfYear;
	
	private  String dateOfMonth;
	
    private  String dateOfDay;
	
	
	
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isNationality() {
		return nationality;
	}

	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}

	public String getMerriageSts() {
		return merriageSts;
	}

	public void setMerriageSts(String merriageSts) {
		this.merriageSts = merriageSts;
	}

	public String getDateOfYear() {
		return dateOfYear;
	}

	public void setDateOfYear(String dateOfYear) {
		this.dateOfYear = dateOfYear;
	}

	public String getDateOfMonth() {
		return dateOfMonth;
	}

	public void setDateOfMonth(String dateOfMonth) {
		this.dateOfMonth = dateOfMonth;
	}

	public String getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(String dateOfDay) {
		this.dateOfDay = dateOfDay;
	}

	
	// gender

	public static Map<String,String> getGenderItem() {
		Map<String, String> sexMap = new LinkedHashMap<>();
		sexMap.put("1", "男性");
		sexMap.put("2", "女性");
		return sexMap;
	}

	
	public static Map<String,String>getMerriageItems(){
		Map<String,String>merriageSts = new LinkedHashMap<String,String>();
		merriageSts.put("結婚", "結婚");
		merriageSts.put("独身", "独身");
		merriageSts.put("離婚", "離婚");
		return merriageSts;
	}
	
	public static Map<String,String>getYearItems(){
		Map<String,String>yearMap = new LinkedHashMap<String,String>();
		LocalDate year = LocalDate.now();
		int currentYear = year.getYear()-20;
		for (int i = 1985; i <= currentYear; i++) {
			yearMap.put(String.valueOf(i), String.valueOf(i));
		}
		return yearMap;
	}

	public static Map<String,String>getMonthItems(){
		Map<String,String>monthMap = new LinkedHashMap<String,String>();
		for (int i = 1; i <= 12; i++) {
			monthMap.put(String.valueOf(i), String.valueOf(i));
		}
		return monthMap;
	}

	// day
	
	public static Map<String,String>getDayItems(){
		Map<String,String>dayMap = new LinkedHashMap<String,String>();
		for (int i = 1; i <= 30; i++) {
			dayMap.put(String.valueOf(i), String.valueOf(i));
		}
		return dayMap;
	}


   
	
}
