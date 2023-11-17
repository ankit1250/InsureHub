package com.model;

import java.util.List;



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
public class PolicyAddOnResponse
{
	private Long policyId;
//	private List<String> addOn;
	private Long price;
	private Policy policy;
}
