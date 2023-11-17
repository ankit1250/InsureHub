package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CartRequest;
import com.model.CartRequestPrice;
import com.model.CartResponse;
import com.repo.CartRequestRepo;
import com.service.CartDAO;

@RestController
@RequestMapping("/shoppingcart")
@RefreshScope
@CrossOrigin(origins = { "*" })
public class AppController {
	@Autowired
	private CartDAO service;
	
	@Autowired
	CartRequestRepo repo;

	@GetMapping("/{userId}/buyCart")
	public ResponseEntity<List<CartResponse>> addAllRequests(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(service.getAllItems(userId), HttpStatus.CREATED);
	}

	@PostMapping("/{userId}/addToCart/{policyid}")
	public ResponseEntity<String> addToCart(@PathVariable("userId") Long userId,
			@PathVariable("policyid") Long policyid, @RequestBody CartRequestPrice req) {
		service.addToCart(policyid, req,userId);
		return new ResponseEntity<>("added to cart", HttpStatus.OK);
	}

	@DeleteMapping("/{userId}/deleteItemFromCart/{policyid}")
	public ResponseEntity<String> deleteFromCart(@PathVariable("userId") Long userId,
			@PathVariable("policyid") Long policyid) {
		service.deleteFromCart(policyid);
		return new ResponseEntity<>("deleted from cart", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteItemFromCart/{cartId}")
	public String deleteFromCartById(@PathVariable("cartId") Long cartId)
	{
		repo.deleteById(cartId);
		return "Item deleted successfully...";
	}
	
	@DeleteMapping("/deleteByUserId/{userId}")
	@Transactional
	public String deleteByUserId(@PathVariable("userId") Long userId)
	{
		repo.deleteAllByuserId(userId);
		return "Cart empty";
	}
	
	@GetMapping("/getTotalPrice/{userId}")
	public Long calculateTotalPrice(@PathVariable("userId") Long userId)
	{
		List<CartResponse> response=service.getAllItems(userId);
		Long total=0L;
		for(CartResponse r:response)
		{
			total+=r.getPrice();
		}
		return total;
		
	}
}
