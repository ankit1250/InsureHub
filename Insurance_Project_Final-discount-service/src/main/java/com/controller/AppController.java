package com.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.DiscountDao;
import com.entity.Discount;
import com.model.DiscountResponse;
import com.repo.DiscountRepository;

@RestController
@RequestMapping("/discount")
public class AppController {

	@Autowired
	DiscountRepository repo;
	@Autowired
	DiscountDao dao;
	@PostMapping("/adddiscount")
	public ResponseEntity<Object>addDiscount(@RequestBody Discount discount){
		dao.addDiscount(discount);
		return ResponseEntity.ok("Discount is added succesfully by the Application owner");
	}
	
	@GetMapping("/getdiscountbypolicyid/{policyId}")
	public Discount getDiscount(@PathVariable Long policyId){
		//return repo.findBypolicyId(policyId);
		LocalDate date = LocalDate.now();
		Discount discount=dao.getPolicyId(policyId);
		
		if(date.compareTo(discount.getExpiryDate())>0)
		    return null;
		    		//new ResponseEntity(null,HttpStatus.BAD_GATEWAY);
		else
			return discount;
					//new ResponseEntity(discount,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getalldiscounts")
	public List<Discount> getAllDiscounts(){
		return dao.getAllDiscount();
	}
	
	 @DeleteMapping("/deleteid/{discountId}")
	    public ResponseEntity<String> deletePolicyId(@PathVariable Long discountId){
	         dao.deleteById(discountId);
	        return ResponseEntity.ok("DiscountId deleted successfully from the database!.");
	    }
	
}









//List<Discount>discount=dao.getDiscount();
//Iterator<Discount>it=discount.iterator();
//DiscountResponse res=null;
//while(it.hasNext()) {
//	Discount d=it.next();
//	if(d.getPolicyId()==policyId) {
//		res= DiscountResponse.builder()
//				.discountId(d.getDiscountId())
//				.policyId(d.getPolicyId())
//				.percentage(d.getPercentage())
//				.maxDiscount(d.getMaxDiscount())
//				.minPurchase(d.getMinPurchase())
//				.build();
//				
//				
//	}
//}
//return res;
