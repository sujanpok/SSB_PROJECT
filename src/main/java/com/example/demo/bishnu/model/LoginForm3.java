package com.example.demo.bishnu.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginForm3 {
  
  @NotNull(message="{require_check}")
  @Pattern(regexp="^[0-9]{7}$", message = "{length_check_number_patter}") 
  private String zipCode;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
  private String address1;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
  private String address2;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
  private String address3;
  
  @NotBlank(message="{select_check}")
  private String livingSituation;
  
  @NotNull(message="{select_check}")
  private String mortageLoan;
  
  @NotNull(message="{select_check}")
  private String drivingLicense;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
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
