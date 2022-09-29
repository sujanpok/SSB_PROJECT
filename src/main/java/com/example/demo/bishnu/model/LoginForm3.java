package com.example.demo.bishnu.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm3 {
  
  @NotBlank(message="{require_check}")
  @Size(max = 7, min = 7, message="{length_post_check}")
  private String zipCode;
  
  @NotNull(message="{require_check}")
  @NotBlank(message="{require_check}")
  private String address1;
  
  @NotNull(message="{require_check}")
  @NotBlank(message="{require_check}")
  private String address2;
  
  @NotNull(message="{require_check}")
  @NotBlank(message="{require_check}")
  private String address3;
  
  @NotNull(message="{select_check}")
  @NotBlank(message="{require_check}")
  private String livingSituation;
  
  @NotNull(message="{select_check}")
  @NotBlank(message="{require_check}")
  private String mortageLoan;
  
  @NotNull(message="{select_check}")
  @NotBlank(message="{require_check}")
  private String drivingLicense;
  /*
  @NotNull(message="{require_check}")
  @NotBlank(message="{require_check}")
  */
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
