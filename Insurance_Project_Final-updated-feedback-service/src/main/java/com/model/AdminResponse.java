package com.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AdminResponse {
		private Long feedback_id;
		private Long admin_id;
		private String title;
		private String description;
		private LocalDate date;
}
