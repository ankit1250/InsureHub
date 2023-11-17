package com.dao;

import com.entity.OrderDetails;
import com.entity.PolicyAddOn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.model.OrderDetailsModel;
import com.model.OrderDetailsResponse;
import com.model.Policy;

import com.model.PolicyAddOnResponse;
import com.model.UserDetailsModel;
import com.repo.OrderDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderDetailsRepository orepo;

    @Mock
    private WebClient webClient;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testAddOrder() throws JsonProcessingException
    {
    	OrderDetails od=new OrderDetails(1L,1L,LocalDate.now(),"policies",new UserDetailsModel(),45000.80);
    	when(orepo.save(any(OrderDetails.class))).thenReturn(od);
    	
    	List<PolicyAddOn> paddon=new ArrayList<>();
    	OrderDetailsModel odm=new OrderDetailsModel(1L,LocalDate.now(),paddon,new UserDetailsModel(),45000.80);
    	

        
        OrderDetails details = orderService.addOrder(odm);
        assertEquals(od.getPurchaseDate(), details.getPurchaseDate());

    	
    }
    @Test
    void testLoadAllOrders() throws IOException {
    
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(1L);
        orderDetails.setUserId(2L);
        orderDetails.setPurchaseDate(LocalDate.now());
        orderDetails.setPolicyAddOn("[]");
        orderDetails.setUdm(new UserDetailsModel());
        orderDetails.setOrderPrice(100.0);

        when(orepo.findAll()).thenReturn(Collections.singletonList(orderDetails));

      
        PolicyAddOnResponse mockPolicyAddOnResponse = PolicyAddOnResponse.builder()
                .policyId(1L)
                .price(50L)
                .policy(new Policy())  
                .build();
    

     
        List<OrderDetailsResponse> result = orderService.loadAllOrders();

        
        assertEquals(1, result.size());
        OrderDetailsResponse resultOrderDetailsResponse = result.get(0);
        assertEquals(orderDetails.getOrderId(), resultOrderDetailsResponse.getOrderId());
        assertEquals(orderDetails.getUserId(), resultOrderDetailsResponse.getUserId());
        assertEquals(orderDetails.getPurchaseDate(), resultOrderDetailsResponse.getPurchaseDate());
        assertEquals(orderDetails.getUdm(), resultOrderDetailsResponse.getUdm());
        assertEquals(orderDetails.getOrderPrice(), resultOrderDetailsResponse.getOrderPrice());

        Mockito.verify(orepo, times(1)).findAll();

    }
    
    @Test
    void testLoadOrdersByUserId() throws JsonProcessingException, JsonMappingException 
    {
  
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(1L);
        orderDetails.setUserId(2L);
        orderDetails.setPurchaseDate(LocalDate.now()); 
        orderDetails.setPolicyAddOn("[]");
        orderDetails.setUdm(new UserDetailsModel());
        orderDetails.setOrderPrice(100.0);

        when(orepo.findByuserId(2L)).thenReturn(List.of(orderDetails));

        
        PolicyAddOnResponse mockPolicyAddOnResponse = PolicyAddOnResponse.builder()
                .policyId(1L)
                .price(500L)
                .policy(new Policy())  
                .build();
       

       
        List<OrderDetailsResponse> result = orderService.loadOrdersByUserId(2L);

  
        assertEquals(1, result.size());
        OrderDetailsResponse resultOrderDetailsResponse = result.get(0);
        assertEquals(orderDetails.getOrderId(), resultOrderDetailsResponse.getOrderId());
        assertEquals(orderDetails.getUserId(), resultOrderDetailsResponse.getUserId());
        assertEquals(orderDetails.getPurchaseDate(), resultOrderDetailsResponse.getPurchaseDate());
        assertEquals(orderDetails.getUdm(), resultOrderDetailsResponse.getUdm());
        assertEquals(orderDetails.getOrderPrice(), resultOrderDetailsResponse.getOrderPrice());
    }
}
