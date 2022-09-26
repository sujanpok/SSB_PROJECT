package com.example.demo.bishnu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginForm4 {
  
  private String userId;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
  private String password;
  
  @NotBlank(message="{require_check}")
  @NotNull(message="{require_check}")
  private String re_password;

}
