package com.example.demo.controller.sujan.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SujanForm4 {
	@NotBlank(message = "{require_check}")
	private String userId;
	@NotBlank(message = "{require_check}")
	private String pwd;
	@NotBlank(message = "{require_check}")
	private String rePwd;
	
	@AssertTrue(message = "パスワードは一致していません")
	public boolean isPasswordValid() {
		if (pwd.equals(rePwd) ) {
			return true;
		}
		return false;

	}

}
