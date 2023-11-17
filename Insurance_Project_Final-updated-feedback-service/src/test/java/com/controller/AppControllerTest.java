package com.controller;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.dao.AdminDao;
import com.dao.PolicyBuyerDao;
import com.entity.AdminFeedback;
import com.entity.PolicyBuyerFeedback;
import com.example.FeedbackService.FeedbackServiceApplication;
import com.model.AdminResponse;
import com.model.PolicyBuyerResponse;
import com.repo.PolicyBuyerRepo;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppController.class)
@ContextConfiguration(classes=FeedbackServiceApplication.class)
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PolicyBuyerDao policyBuyerDao;

    @MockBean
    private AdminDao adminDao;

    @Test
    void testAddFeedback() throws Exception {
        PolicyBuyerFeedback feedback = new PolicyBuyerFeedback();
        when(policyBuyerDao.addFeedBack(any(PolicyBuyerFeedback.class))).thenReturn(new PolicyBuyerFeedback());


        mockMvc.perform(post("/feedback/pbfeedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Feedback added successfully by the PolicyBuyer"));

        verify(policyBuyerDao, times(1)).addFeedBack(feedback);
    }

    @Test
    void testAddAdminFeedback() throws Exception {
        AdminFeedback adminFeedback = new AdminFeedback();
        when(adminDao.addAdminFeedBack(any(AdminFeedback.class))).thenReturn(new AdminFeedback());;


        mockMvc.perform(post("/feedback/adminfeedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin's Feedback Added Successfully"));

        verify(adminDao, times(1)).addAdminFeedBack(adminFeedback);
    }

    @Test
    void testGetPolicyBuyerFeedBack() throws Exception {
        Long userId = 1L;

        List<PolicyBuyerFeedback> feedbackList = new ArrayList<>();
        feedbackList.add(new PolicyBuyerFeedback(1L, userId, "Title1", "Description1", LocalDate.now()));
        feedbackList.add(new PolicyBuyerFeedback(2L, userId, "Title2", "Description2", LocalDate.now()));

        when(policyBuyerDao.getAllFeedback()).thenReturn(feedbackList);

        mockMvc.perform(get("/feedback/policybuyerfeedback/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].feedback_id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Title1"));
                // Add more assertions as needed

        verify(policyBuyerDao, times(1)).getAllFeedback();
    }

    @Test
    void testGetAdminFeedBacks() throws Exception {
        Long adminId = 1L;

        List<AdminFeedback> feedbackList = new ArrayList<>();
        feedbackList.add(new AdminFeedback(1L, adminId, "Title1", "Description1", LocalDate.now()));
        feedbackList.add(new AdminFeedback(2L, adminId, "Title2", "Description2", LocalDate.now()));

        when(adminDao.getAllFeedBack()).thenReturn(feedbackList);

        mockMvc.perform(get("/feedback/adminfeedback/{adminId}", adminId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].feedback_id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Title1"));
                // Add more assertions as needed

        verify(adminDao, times(1)).getAllFeedBack();
    }
}

