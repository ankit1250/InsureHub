package com.service;

import java.util.List;

import com.entity.CartRequest;
import com.model.CartRequestPrice;
import com.model.CartResponse;

public interface CartDAO {
	String addToCart(Long policyId, CartRequestPrice req,Long userId);

	List<CartResponse> getAllItems(Long userId);

	void deleteFromCart(Long policyId);

}
