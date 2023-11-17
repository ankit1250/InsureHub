package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AddOnDAO;
import com.entity.AddOn;

@RestController
@RequestMapping("/app")
@RefreshScope
public class AddOnController {

	@Autowired
	private AddOnDAO dao;

	@GetMapping("/getAddOnByPolicyTypeId/{policyTypeId}")
	@ResponseBody
	public List<AddOn> create(@PathVariable Long policyTypeId) {
		return dao.getAddOnsFromPolicyTypeId(policyTypeId);
	}

	@GetMapping("/getAddOn/{addOnId}")
	@ResponseBody
	public AddOn get(@PathVariable Long addOnId) {
		return dao.getAddOn(addOnId);
	}

	@GetMapping("/getAddOnByAddOnIds/{addOnIdList}")
	@ResponseBody
	public List<AddOn> getAddOns(@PathVariable List<Long> addOnIdList) {
		return dao.getAddOnsFromAddOnIds(addOnIdList);
	}
}
