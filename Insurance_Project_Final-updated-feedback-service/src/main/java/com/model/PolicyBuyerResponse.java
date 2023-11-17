package com.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PolicyBuyerResponse {
private Long feedback_id;
private Long user_id;
private String title;
private String description;
private LocalDate date;

}
