package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {
	private String username;
	private String securityQuestion;
	private String securityAnswer;
	private String newPassword;

}
