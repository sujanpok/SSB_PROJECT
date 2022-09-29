package com.example.demo.bishnu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm2 {
  
  @Email(message = "{email_check}")
  @Pattern(regexp="^([\\w\\-\\.]+)@((\\[([0-9]{1,3}\\.){3}[0-9]{1,3}\\])|(([\\w\\-]+\\.)+)([a-zA-Z]{2,4}))$", message = "{email_check}")
  @NotBlank(message = "{require_check}")
  private String email;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}")
  @Size(max = 3, min = 3, message = "{length_check_number}")
  private String mobile1;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}")
  @Size(max = 4, min = 4, message = "{length_check_number}")
  private String mobile2;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}")
  @Size(max = 4, min = 4, message = "{length_check_number}")
  private String mobile3;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}")
  @Size(max = 2, min = 2, message = "{length_check_number}")
  private String tel1;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}") 
  @Size(max = 4, min = 4, message = "{length_check_number}")
  private String tel2;
  
  @NotNull(message="{require_check}")
  @NotBlank(message = "{require_check}")
  @Size(max = 4, min = 4, message = "{length_check_number}")
  private String tel3;
  
  

}
