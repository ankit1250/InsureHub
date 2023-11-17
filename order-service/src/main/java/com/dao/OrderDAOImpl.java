package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.OrderDetails;
import com.repo.OrderDetailsRepository;

@Service
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	OrderDetailsRepository orderRepo;

	@Override
	public List<OrderDetails> loadAllOrders() 
	{
		return orderRepo.findAll();
	}
	

}
