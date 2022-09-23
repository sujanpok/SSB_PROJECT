package com.example.demo.controller.sujan.form;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;



@Data
public class SujanForm1{
    private String name; 
	
    private String gender;
	
    private boolean nationality;
	
    private String merriageSts;
	
    private  String dateOfYear;
	
	private  String dateOfMonth;
	
    private  String dateOfDay;
	

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
		sexMap.put("男性", "男性");
		sexMap.put("女性", "女性");
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
