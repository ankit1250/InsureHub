package com.dao;

import java.util.List;

import com.entity.OrderDetails;

public interface OrderDAO 
{
	public List<OrderDetails> loadAllOrders();
}
