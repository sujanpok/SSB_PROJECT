package com.example.demo.bishnu.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class LoginForm3 {
  
  private String zipCode;
  private String address1;
  private String address2;
  private String address3;
  private String livingSituation;
  private String mortageLoan;
  private String drivingLicense;
  private String licenseNumber;

  public static Map<String, String>getLivingCondition(){
    Map<String, String>living = new HashMap<>();
    living.put("Self/Family Owned", "Self/Family Owned");
    living.put("Company housing", "Company housing");
    living.put("Rent", "Rent");
    living.put("Dormitory/boarding house", "Dormitory/boarding house");
    living.put("Others", "Others");
    return living;
  }
  
}
