package com.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.entity.AdminFeedback;
import com.example.FeedbackService.FeedbackServiceApplication;
import com.repo.AdminRepo;


@DataJpaTest
@ContextConfiguration(classes = FeedbackServiceApplication.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {

    @Autowired
    private AdminRepo adminRepo;

    @Test
    public void testSaveAdminFeedback() {
        AdminFeedback adminFeedback = new AdminFeedback();
        adminFeedback.setAdminId(1L);
        adminFeedback.setTitle("Test Title");
        adminFeedback.setDescription("Test Description");
        adminFeedback.setDate(LocalDate.now());

        AdminFeedback savedFeedback = adminRepo.save(adminFeedback);

        assertNotNull(savedFeedback.getFeedbackId());
        assertEquals("Test Title", savedFeedback.getTitle());
        assertEquals("Test Description", savedFeedback.getDescription());
    }

    @Test
    public void testFindById() {
        AdminFeedback adminFeedback = new AdminFeedback();
        adminFeedback.setAdminId(2L);
        adminFeedback.setTitle("Another Title");
        adminFeedback.setDescription("Another Description");
        adminFeedback.setDate(LocalDate.now());

        AdminFeedback savedFeedback = adminRepo.save(adminFeedback);

        Optional<AdminFeedback> foundFeedback = adminRepo.findById(savedFeedback.getFeedbackId());

        assertTrue(foundFeedback.isPresent());
        assertEquals("Another Title", foundFeedback.get().getTitle());
        assertEquals("Another Description", foundFeedback.get().getDescription());
    }

    // Add more test cases as needed

}
