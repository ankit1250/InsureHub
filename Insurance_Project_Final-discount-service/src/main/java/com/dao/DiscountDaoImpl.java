package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Discount;
import com.repo.DiscountRepository;

@Service
public class DiscountDaoImpl implements DiscountDao {

	@Autowired
	DiscountRepository repo;
	@Override
	public Discount addDiscount(Discount discount) {
		// TODO Auto-generated method stub
		return repo.save(discount);
	}

	@Override
	public List<Discount> getAllDiscount() {
		// TODO Auto-generated method stub
		return (List<Discount>) repo.findAll();
	}

	@Override
	public Discount getPolicyId(Long policyId) {
		// TODO Auto-generated method stub
		return repo.findBypolicyId(policyId);
	}

	@Override
	public void deleteById(Long discountId) {
		// TODO Auto-generated method stub
		 repo.deleteById(discountId);
	}

}
