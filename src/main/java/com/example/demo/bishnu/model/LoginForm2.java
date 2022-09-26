package com.example.demo.bishnu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginForm2 {
  
  @Email(message = "{email_check}")
  @NotBlank(message = "{require_check}")
  private String email;
  
  @NotBlank(message = "{require_check}")
  @Pattern(regexp="^[0-9]{3}$", message = "{length_check_number}") 
  private String mobile1;
  
  @NotBlank(message = "{require_check}")
  @Pattern(regexp="^[0-9]{4}$", message = "{length_check_number}") 
  private String mobile2;
  
  @NotBlank(message = "{require_check}")
  @Pattern(regexp="^[0-9]{4}$", message = "{length_check_number}") 
  private String mobile3;
  
  @Pattern(regexp="^[0-9]{2}$") 
  private String tel1;
  
  @Pattern(regexp="^[0-9]{4}$")  
  private String tel2;
  
  @Pattern(regexp="^[0-9]{4}$") 
  private String tel3;
  
  

}
