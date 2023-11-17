package com.model;

import java.time.LocalDate;
import java.util.List;

import com.entity.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderDetailsResponse
{
	private Long orderId;
	private Long userId;
	private LocalDate purchaseDate;
	private List<PolicyAddOnResponse> policyAddOn;
	private UserDetailsModel udm;
	private Double orderPrice;
}
