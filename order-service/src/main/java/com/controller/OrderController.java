package com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dao.OrderService;
import com.entity.OrderDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.model.OrderDetailsModel;
import com.model.OrderDetailsResponse;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = { "*" })
public class OrderController 
{
	
	
	@Autowired
	OrderService service;
	@PostMapping("/addOrderWithUserDetails")
	public ResponseEntity addOrderWithUserDetails(@RequestBody OrderDetailsModel orderDetailsModel) throws JsonProcessingException
	{
		OrderDetails od=service.addOrder(orderDetailsModel);
		
		return new ResponseEntity("Order Added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/loadAllOrders")
	public ResponseEntity loadAllOrders() throws IOException
	{
		List<OrderDetailsResponse> odl=service.loadAllOrders();
		return new ResponseEntity(odl,HttpStatus.OK);
	}
	@GetMapping("/getOrderByUserId/{userId}")
	public ResponseEntity getOrderByUserId(@PathVariable Long userId) throws JsonMappingException, JsonProcessingException
	{
		List<OrderDetailsResponse> odl=service.loadOrdersByUserId(userId);
		return new ResponseEntity(odl,HttpStatus.OK); 
	}
}
