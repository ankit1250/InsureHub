package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {

	List<Policy> findAllByPolicyTypePolicyTypeId(Long policyTypeId);
}
