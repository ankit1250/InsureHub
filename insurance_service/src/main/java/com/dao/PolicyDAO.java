package com.dao;

import java.util.List;

import com.entity.Policy;

public interface PolicyDAO {

	public List<Policy> findAllBypolicyTypeId(Long policyId);
	
	public List<Policy> findAllBypolicyIds(List<Long> policyIds);
	
	public String updatePolicy(Policy policy);

	public String deletePolicy(Long policyId);
	
	public Policy loadPolicy(Long insuranceId);
	
	
}
