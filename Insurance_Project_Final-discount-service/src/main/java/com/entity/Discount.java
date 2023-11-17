package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long discountId;
	private Long policyId;
	private Double percentage;
	private Double maxDiscount;
	private Double minPurchase;
	private LocalDate expiryDate;
}
