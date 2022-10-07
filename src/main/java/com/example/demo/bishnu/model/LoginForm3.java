package com.example.demo.bishnu.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.bishnu.validation.SeqValiInterface.Advance;
import com.example.demo.bishnu.validation.SeqValiInterface.Basic;

import lombok.Data;

@Data
public class LoginForm3 {
  
  @NotBlank(message="{require_check}", groups = Basic.class)
  @Size(max = 7, min = 7, message="{length_post_check}", groups = Advance.class)
  private String zipCode;
  
  @NotNull(message="{require_check}", groups = Basic.class)
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String address1;
  
  @NotNull(message="{require_check}", groups = Basic.class)
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String address2;
  
  @NotNull(message="{require_check}", groups = Basic.class)
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String address3;
  
  @NotNull(message="{select_check}", groups = Basic.class)
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String livingSituation;
  
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String mortageLoan;
  
  @NotBlank(message="{require_check}", groups = Basic.class)
  private String drivingLicense;

 // @NotBlank(message="{require_check}", groups = Basic.class)
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
