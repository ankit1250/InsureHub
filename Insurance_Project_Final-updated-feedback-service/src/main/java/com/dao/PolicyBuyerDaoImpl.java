package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.PolicyBuyerFeedback;
import com.repo.PolicyBuyerRepo;
@Service
public class PolicyBuyerDaoImpl implements PolicyBuyerDao{

	@Autowired
	PolicyBuyerRepo repo;
	
	@Override
	public PolicyBuyerFeedback addFeedBack(PolicyBuyerFeedback policybuyer) {
		// TODO Auto-generated method stub
		return repo.save(policybuyer);
	}

	@Override
	public Iterable<PolicyBuyerFeedback> getAllFeedback() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
