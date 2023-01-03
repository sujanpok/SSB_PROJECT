package com.example.demo.controller.sujan.form;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

import com.example.demo.ValidationSeqInterface.First;

import lombok.Data;

@Data
public class SujanForm2 {

	
	@NotBlank(message = "{require_check}",groups = First.class)
	@Email(message = "{email_check}")
	private String email;
	
	@NotBlank(message = "{require_check}",groups = First.class)
	@Size(max = 3, min = 3, message = "{length_check_number}")
	private String mobileNo1;
	
	@NotBlank(message = "{require_check}",groups = First.class)
	@Size(max = 4, min = 4, message = "{length_check_number}")
	private String mobileNo2;
	
	@NotBlank(message = "{require_check}",groups = First.class)
	@Size(max = 4, min = 4, message = "{length_check_number}")
	private String mobileNo3;
	
	//money add 
	//@NotBlank(message = "{require_check}",groups = First.class)
	//@NotNull(message = "{require_check}")
	private Integer totalMoney;

	
	
	
	
	
	public static Map<Integer, String> getAvaliableList() {
		Map<Integer, String> totalMoneyMap = new LinkedHashMap<>();
		totalMoneyMap.put(50000, "５万");
		totalMoneyMap.put(100000, "１０万");
		totalMoneyMap.put(200000, "２０万");
		return totalMoneyMap;
	}
}
