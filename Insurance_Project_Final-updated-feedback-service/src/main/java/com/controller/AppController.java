package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AdminDao;
import com.dao.PolicyBuyerDao;
import com.entity.AdminFeedback;
import com.entity.PolicyBuyerFeedback;
import com.model.AdminResponse;
import com.model.PolicyBuyerResponse;
import com.repo.PolicyBuyerRepo;


@RestController
@RequestMapping("/feedback")
public class AppController {

	@Autowired
	PolicyBuyerDao policybuyerdao;
	

	@Autowired
  AdminDao admindao;
	
	
	@PostMapping("/pbfeedback")
	public ResponseEntity<Object>addFeedback(@RequestBody PolicyBuyerFeedback policybuyerFeedback){
		
		policybuyerdao.addFeedBack(policybuyerFeedback);
		return ResponseEntity.ok("Feedback added successfully by the PolicyBuyer");
	}
	@PostMapping("/adminfeedback")
	public ResponseEntity<Object>addAdminFeedback(@RequestBody AdminFeedback adminFeedback){
		
		admindao.addAdminFeedBack(adminFeedback);
		return ResponseEntity.ok("Admin's Feedback Added Successfully");
	}
	

	@GetMapping("/policybuyerfeedback/{userId}")
public List<PolicyBuyerResponse> getPolicyBuyerFeedBack(@PathVariable Long userId) {
	Iterable<PolicyBuyerFeedback>pb= policybuyerdao.getAllFeedback();
	
	List<PolicyBuyerResponse> pr=new ArrayList<PolicyBuyerResponse>();
	Iterator<PolicyBuyerFeedback> itr = pb.iterator();
	while(itr.hasNext()) {
		PolicyBuyerFeedback pbf = itr.next();
		if(pbf.getUserId() == userId) {
			pr.add(PolicyBuyerResponse.builder()
					.feedback_id(pbf.getFeedbackId())
					.title(pbf.getTitle())
					.description(pbf.getDescription())
					.date(pbf.getDate())
					.user_id(pbf.getUserId())
					.build()
					);
		}
	}
	
	return pr;
	
}
	@GetMapping("/adminfeedback/{adminId}")
	
	public List<AdminResponse> getAdminFeedBacks(@PathVariable Long adminId){
		
		Iterable<AdminFeedback> af=admindao.getAllFeedBack();
		
		List<AdminResponse>ar=new ArrayList<>();
		
		Iterator<AdminFeedback>itr=af.iterator();
		while(itr.hasNext()) {
			AdminFeedback pbf = itr.next();
			if(pbf.getAdminId()==adminId) {
				ar.add(AdminResponse.builder()
						.feedback_id(pbf.getFeedbackId())
						.admin_id(pbf.getAdminId())
						.title(pbf.getTitle())
						.description(pbf.getDescription())
						.date(pbf.getDate())
						.build()
						);
			}
		}
		return ar;
	}
	
	
}



