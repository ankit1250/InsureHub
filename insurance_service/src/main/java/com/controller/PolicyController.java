package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PolicyDAO;
import com.entity.Policy;

@RestController
@RequestMapping("/insurance-service")
@RefreshScope
public class PolicyController {

	@Autowired
	private PolicyDAO dao;

	@GetMapping("/policiesByPolicyTypeId/{policyTypeId}")
	@ResponseBody
	public List<Policy> getPoliciesByPolicyTypeId(@PathVariable Long policyTypeId) {
		return dao.findAllBypolicyTypeId(policyTypeId);
	}

	@PutMapping("/updatePolicy")
	@ResponseBody
	public String updatePolicy(@RequestBody Policy pol) {
		return dao.updatePolicy(pol);
	}

	@GetMapping("/deletePolicy")
	@ResponseBody
	public String deletePolicy(@PathVariable Long policyId) {
		return dao.deletePolicy(policyId);
	}

	@GetMapping("/PolicyByPolicyId/{policyId}")
	@ResponseBody
	public Policy getPolicyByPolicyId(@PathVariable Long policyId) {
		return dao.loadPolicy(policyId);
	}

	@GetMapping("/PoliciesByPolicyIds/{policyIds}")
	@ResponseBody
	public List<Policy> getPolicyByPolicyIds(@PathVariable List<Long> policyIds) {
		return dao.findAllBypolicyIds(policyIds);
	}
}
