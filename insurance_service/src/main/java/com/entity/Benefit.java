package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Benefit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long benefitId;
	@Column(columnDefinition = "TEXT") // Use TEXT data type for JSON string
	private String benefitValue;

}
