package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDetails 
{
	
	private Long userDetailId;
	private Long userId;
	private Long policyId;
	private String userName;
	private Integer age;
	private Boolean isTobaccoConsumer;
	private Boolean doesUserDrink;
	private String nominee;
	
}
