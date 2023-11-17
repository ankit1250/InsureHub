package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.entity.OrderDetails;
import com.entity.PolicyAddOn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


import com.model.OrderDetailsModel;
import com.model.OrderDetailsResponse;
import com.model.Policy;
import com.model.PolicyAddOnResponse;

import com.repo.OrderDetailsRepository;
import com.repo.UserDetailsRepo;

import reactor.core.publisher.Mono;


@Service
public class OrderService 
{
	@Autowired
	OrderDetailsRepository orepo;
	
	@Autowired
	UserDetailsRepo urepo;
	
	@Autowired
	@Qualifier("webclient")
	private WebClient.Builder builder;
	
	public OrderDetails addOrder(OrderDetailsModel odm) throws JsonProcessingException
	{
		ObjectMapper mapper=new ObjectMapper();
		OrderDetails od=null;
//		
//		for(PolicyAddOn pdm:odm.getPolicyAddOn())
//		{
//			UserDetails ud=null;
//			ud=ud.builder().userId(pdm.getUdm().getUserId())
//					.policyId(pdm.getUdm().getPolicyId())
//					.age(pdm.getUdm().getAge())
//					.isTobaccoConsumer(pdm.getUdm().getIsTobaccoConsumer())
//					.doesUserDrink(pdm.getUdm().getDoesUserDrink())
//					.nominee(mapper.writeValueAsString(pdm.getUdm().getNominee())).build();
//			urepo.save(ud);
//			
//		}
		
		od=od.builder().userId(odm.getUserId())
				.purchaseDate(odm.getPurchaseDate())
				.policyAddOn(mapper.writeValueAsString(odm.getPolicyAddOn())).udm(odm.getUdm()).orderPrice(odm.getOrderPrice()).build();
		orepo.save(od);
		
		return od;
		
				
	}
	
	public List<OrderDetailsResponse> loadOrdersByUserId(Long userId) throws JsonMappingException, JsonProcessingException
	{
		List<OrderDetails> odl=orepo.findByuserId(userId);
		List<OrderDetailsResponse> odres=new ArrayList<>();
		
		
		for(OrderDetails o:odl)
		{
			
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			
			List<PolicyAddOn> response = objectMapper.readValue(o.getPolicyAddOn(), typeFactory.constructCollectionType(List.class, PolicyAddOn.class));
			
			List<PolicyAddOnResponse> finalres=new ArrayList<>();
			for(PolicyAddOn paddon:response)
			{
				Long policyId=paddon.getPolicyId();
				String getPolicyURL="http://localhost:8090/app/PolicyByPolicyId/"+policyId;
//				System.out.println(policyId);
//				Policy policy=builder.build().get().uri(getPolicyURL).retrieve().bodyToMono(Policy.class).block();
//				System.out.println(policy);
				
				WebClient client = WebClient.create();
				Mono<Policy> mono= client
						.get()
						.uri(getPolicyURL)
						.retrieve()
						.bodyToMono(Policy.class);
				
//				System.out.println(mono.block());
			    
			    finalres.add(PolicyAddOnResponse.builder().policyId(paddon.getPolicyId())
			    		.price(paddon.getPrice())
			    		.policy(mono.block())
			    		.build()
			    		);
			    
				
			}
			System.out.println(response);
			odres.add(OrderDetailsResponse.builder()
					.orderId(o.getOrderId())
					.userId(o.getUserId())
					.purchaseDate(o.getPurchaseDate())
					.policyAddOn(finalres)
					.udm(o.getUdm())
					.orderPrice(o.getOrderPrice())
					.build());
			
		}
		return odres;
	
	
	}
	public List<OrderDetailsResponse> loadAllOrders() throws IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		List<OrderDetails> odl=orepo.findAll();
		List<OrderDetailsResponse> odres=new ArrayList<>();
		
	
		for(OrderDetails o:odl)
		{
			
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			
			List<PolicyAddOn> response = objectMapper.readValue(o.getPolicyAddOn(), typeFactory.constructCollectionType(List.class, PolicyAddOn.class));
			
			List<PolicyAddOnResponse> finalres=new ArrayList<>();
			for(PolicyAddOn paddon:response)
			{
				Long policyId=paddon.getPolicyId();
				String getPolicyURL="http://localhost:8090/app/PolicyByPolicyId/"+policyId;
//				
//				Policy policy=builder.build().get().uri(getPolicyURL).retrieve().bodyToMono(Policy.class).block();
//			    
				WebClient client = WebClient.create();
				Mono<Policy> mono= client
						.get()
						.uri(getPolicyURL)
						.retrieve()
						.bodyToMono(Policy.class);
			    
			    finalres.add(PolicyAddOnResponse.builder().policyId(paddon.getPolicyId())
			    		.price(paddon.getPrice())
			    		.policy(mono.block())
			    		.build()
			    		);
			    
				
			}
			System.out.println(response);
			odres.add(OrderDetailsResponse.builder()
					.orderId(o.getOrderId())
					.userId(o.getUserId())
					.purchaseDate(o.getPurchaseDate())
					.policyAddOn(finalres)
					.udm(o.getUdm())
					.orderPrice(o.getOrderPrice())
					.build());
			
		}
		return odres;
	}
	

}
