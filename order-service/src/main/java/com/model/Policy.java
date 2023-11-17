package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Policy 
{
	private Long policyId;
	private String policyName;
	private PolicyType policyType;
	private String policyCompany;
	private Integer tenure;
	private Double policyPrice;
	private Long coverage;
	private Benefits benefit;
}
