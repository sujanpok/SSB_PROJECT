package com.example.demo.bishnu.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class LoginForm1 {
  
  private String firstName;
  private String lastName;
  private String gender;
  private String dateofyear;
  private String dateofmonth;
  private String dateofday;
  private String marriedStatus;
  private String countryStatus;
 
  
  //date
  public static Map<String, String> getDay() {
    Map<String, String> day = new LinkedHashMap<>();
    for (int i = 1; i <= 31; i++) {
      day.put(String.valueOf(i), String.valueOf(i));
    }
    return day;
  }
  
  //month
  public static Map<String, String>getMonth(){
    Map<String, String>month = new LinkedHashMap<>();
    for(int i= 1; i<=12; i++) {
      month.put(String.valueOf(i), String.valueOf(i));
    }
    return month;
  }
  
  //year
  public static Map<String, String>yearMap(){
    Map<String, String>year = new LinkedHashMap<>();
    LocalDate date= LocalDate.now();
    int currentYear= date.getYear()-20;
   
    for(int i= 1970; i<=currentYear; i++) {
      year.put(String.valueOf(i), String.valueOf(i));
    }
    return year;
  }
  
  //gender
   public static Map<String, String>getByGender(){
     Map<String, String>sex = new HashMap<>();
     sex.put("Male", "Male");
     sex.put("Female", "Female");
    return sex;
   }
}