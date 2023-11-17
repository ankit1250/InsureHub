package com.entity;

import java.util.List;

import com.model.UserDetailsModel;

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
public class PolicyAddOn
{
	private Long policyId;
//	private List<String> addOn;
	private Long price;
	
}
