package com.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountResponse {
	@Id
	private Long discountId;
	private Long policyId;
	private Double percentage;
	private Double maxDiscount;
	private Double minPurchase;
	private LocalDate expiryDate;
}
