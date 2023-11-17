package com.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.dao.DiscountDao;
import com.entity.Discount;
import com.example.DiscountService.DiscountServiceApplication;
import com.repo.DiscountRepository;

@WebMvcTest(AppController.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes=DiscountServiceApplication.class)
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DiscountRepository discountRepository;

    @Mock
    private DiscountDao discountDao;

    @InjectMocks
    private AppController appController;

    @Test
    void testAddDiscount() throws Exception {
        mockMvc.perform(post("/discount/adddiscount")
                .contentType("application/json")
                .content("{\"policyId\": 123, \"percentage\": 10.0, \"maxDiscount\": 50.0, \"minPurchase\": 100.0, \"expiryDate\": \"2023-12-31\"}"))
                .andExpect(status().isOk());
                
    }

   
}

