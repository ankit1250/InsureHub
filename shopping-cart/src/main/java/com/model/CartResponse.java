package com.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponse {

	private Long userId;
	private Long cartRequestId;
	private Policy policy;
	private Long price;
}
