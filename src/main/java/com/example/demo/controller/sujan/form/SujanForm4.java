package com.example.demo.controller.sujan.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SujanForm4 {
	@NotBlank(message = "{require_check}")
	private String userId;
	@NotBlank(message = "{require_check}")
	private String pwd;
	private String rePwd;


}
