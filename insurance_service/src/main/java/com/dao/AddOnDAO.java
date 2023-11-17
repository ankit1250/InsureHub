package com.dao;

import java.util.List;

import com.entity.AddOn;

public interface AddOnDAO {

	public List<AddOn> getAddOnsFromAddOnIds(List<Long> addOnIds);
	
	public List<AddOn> getAddOnsFromPolicyTypeId(Long policyTypeId);

	public AddOn getAddOn(Long addOn);
}
