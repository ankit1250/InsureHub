package com.controller;

import com.dao.OrderService;
import com.entity.OrderDetails;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.model.OrderDetailsModel;
import com.model.OrderDetailsResponse;
import com.model.PolicyAddOnResponse;

import com.model.UserDetailsModel;


import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import java.util.List;


//@ExtendWith(SpringExtension.class)
//@WebMvcTest(OrderController.class)
//@ContextConfiguration(classes = OrderServiceApplication.class)
class OrderControllerTest {


    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;
    
    @Autowired
	MockMvc mvc;

    public OrderControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testAddOrderWithUserDetails() throws Exception 
    {
       
        when(orderService.addOrder(any(OrderDetailsModel.class))).thenReturn(createMockOrder());

        
        OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
     
        mockMvc.perform(post("/order/addOrderWithUserDetails")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(orderDetailsModel)))
                .andExpect(status().isCreated());
    }

    private OrderDetails createMockOrder() {
        OrderDetails orderDetails = new OrderDetails();
     
        return orderDetails;
    }
    
    @Test
    void testLoadAllOrders() throws Exception {
       
        List<OrderDetailsResponse> mockOrderDetailsResponses = createMockOrderDetailsResponses();
        when(orderService.loadAllOrders()).thenReturn(mockOrderDetailsResponses);

        mockMvc.perform(MockMvcRequestBuilders.get("/order/loadAllOrders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2)) 
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].orderId").value(1)) 
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].orderId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userId").value(102));
    }

    private List<OrderDetailsResponse> createMockOrderDetailsResponses() 
    {
        
        return List.of(
                new OrderDetailsResponse(1L, 101L, LocalDate.now(),List.of(new PolicyAddOnResponse()),new UserDetailsModel(),23000.90 ),
                new OrderDetailsResponse(2L, 102L, LocalDate.now(),List.of(new PolicyAddOnResponse()),new UserDetailsModel(),560008.90 )
               
        );
    }
    
    @Test
    void testGetOrderByUserId() throws Exception {
       
        List<OrderDetailsResponse> mockOrderDetailsResponses = createMockOrderDetailsResponsesId();
        when(orderService.loadOrdersByUserId(101L)).thenReturn(mockOrderDetailsResponses);

       
        mockMvc.perform(MockMvcRequestBuilders.get("/order/getOrderByUserId/{userId}", 101)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2)) 
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].orderId").value(1)) 
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].orderId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userId").value(101));
    }

     List<OrderDetailsResponse> createMockOrderDetailsResponsesId() {
        
        return List.of(
                new OrderDetailsResponse(1L, 101L,  LocalDate.now(),List.of(new PolicyAddOnResponse()),new UserDetailsModel(),23000.90),
                new OrderDetailsResponse(2L, 101L,  LocalDate.now(),List.of(new PolicyAddOnResponse()),new UserDetailsModel(),67000.90)
                
        );
    }

    

    
   
}
