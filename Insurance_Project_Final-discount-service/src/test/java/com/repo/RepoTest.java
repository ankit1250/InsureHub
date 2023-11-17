package com.repo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.dao.DiscountDao;
import com.dao.DiscountDaoImpl;
import com.entity.Discount;
import com.example.DiscountService.DiscountServiceApplication;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ContextConfiguration(classes = DiscountServiceApplication.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {

    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountDaoImpl service; 
    @Test
    public void testFindDiscountByPolicyId() {
        // Mock data
        Long policyId = 123L;
        Discount mockDiscount = new Discount();
        mockDiscount.setDiscountId(1L);
        mockDiscount.setPolicyId(policyId);
        mockDiscount.setPercentage(10.0);
        mockDiscount.setMaxDiscount(50.0);
        mockDiscount.setMinPurchase(100.0);
        mockDiscount.setExpiryDate(LocalDate.now().plusDays(30));

        // Mock the repository method
        when(discountRepository.findBypolicyId(policyId)).thenReturn(mockDiscount);

        // Call the service method that uses the repository
        Discount resultDiscount = service.getPolicyId(policyId);

        // Verify the result
        assertEquals(mockDiscount, resultDiscount);
    }
}
