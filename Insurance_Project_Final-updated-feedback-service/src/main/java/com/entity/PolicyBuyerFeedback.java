package com.entity;

import java.time.LocalDate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PolicyBuyerFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long feedbackId;
private Long userId;
private String title;
private String description;
private LocalDate date;
}
