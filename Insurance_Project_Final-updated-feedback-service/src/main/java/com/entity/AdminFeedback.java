package com.entity;

import java.time.LocalDate;

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

public class AdminFeedback 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long feedbackId;
private Long adminId;
private String title;
private String description;
private LocalDate date;


}
