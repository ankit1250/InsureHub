package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.entity.CartRequest;
import com.model.CartRequestPrice;
import com.model.CartResponse;
import com.model.Policy;
import com.repo.CartRequestRepo;

import reactor.core.publisher.Mono;

@Service
public class CartDAOImpl implements CartDAO {

	@Autowired
	@Qualifier("webclient")
	private WebClient.Builder builder;

	@Autowired
	private CartRequestRepo crepo;

	public String fallBackMethod() {
		return "";
	}

	@Override
	public String addToCart(Long policyId, CartRequestPrice req, Long userId) {
		crepo.save(CartRequest.builder().policyId(policyId).price(req.getPrice()).userId(userId).build());
		return "added to cart";
	}

	public void deleteCart() {
		crepo.deleteAll();
	}

	@Override
	public void deleteFromCart(Long policyId) {
		crepo.deleteById(policyId);
	}

	@Override
	public List<CartResponse> getAllItems(Long userId) {
		List<CartRequest> cartRequests = (List<CartRequest>) crepo.findByuserId(userId);
		
		List<CartResponse> response=new ArrayList<>();
		WebClient client = WebClient.create();
		for (CartRequest request : cartRequests) 
		{	
			String getPolicyURL="http://localhost:8090/app/PolicyByPolicyId/"+request.getPolicyId();
			Mono<Policy> mono= client
					.get()
					.uri(getPolicyURL)
					.retrieve()
					.bodyToMono(Policy.class);
			response.add(CartResponse.builder().userId(userId).cartRequestId(request.getCartRequestId()).policy(mono.block())
					.price(request.getPrice()).build());
			
			
		}
		return response;
		

	
	}

}
