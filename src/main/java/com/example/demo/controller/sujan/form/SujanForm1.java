package com.example.demo.controller.sujan.form;

import lombok.Data;

@Data

public class SujanForm1 {
    private Integer id;
    private String name; 
    private String gender;
    private boolean nationality;
    private String merriageSts;
    private  String dateOfYear;
	private  String dateOfMonth;
    private  String dateOfDay;
   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNationality() {
		return nationality;
	}
	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getMerriageSts() {
		return merriageSts;
	}
	public void setMerriageSts(String merriageSts) {
		this.merriageSts = merriageSts;
	}
}
