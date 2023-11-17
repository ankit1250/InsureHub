package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.PolicyBuyerFeedback;

@Repository
public interface PolicyBuyerRepo extends CrudRepository<PolicyBuyerFeedback,Long>{

}
