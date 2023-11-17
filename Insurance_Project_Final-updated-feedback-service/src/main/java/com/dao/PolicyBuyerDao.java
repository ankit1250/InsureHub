package com.dao;

import java.util.List;

import com.entity.PolicyBuyerFeedback;

public interface PolicyBuyerDao {
public PolicyBuyerFeedback addFeedBack(PolicyBuyerFeedback policybuyer);
public Iterable<PolicyBuyerFeedback> getAllFeedback();
//public List<PolicyBuyerFeedback> getAllFeedback();

}
