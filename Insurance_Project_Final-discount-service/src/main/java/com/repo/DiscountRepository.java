package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {

	public Discount findBypolicyId(Long policyId);
}
