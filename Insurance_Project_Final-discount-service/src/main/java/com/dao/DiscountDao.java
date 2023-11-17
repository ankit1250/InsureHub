package com.dao;

import java.util.List;

import com.entity.Discount;

public interface DiscountDao {
public Discount addDiscount(Discount discount);
public List<Discount>getAllDiscount();
public Discount getPolicyId(Long policyId);
public void deleteById(Long discountId);

}
