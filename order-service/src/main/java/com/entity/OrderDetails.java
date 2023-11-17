package com.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.model.UserDetailsModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderDetails 
{
	@Id
	@GeneratedValue
	private Long orderId;
	private Long userId;
	private LocalDate purchaseDate;
	@Column(columnDefinition = "longtext")
	private String policyAddOn;
	@OneToOne(cascade=CascadeType.ALL)
	private UserDetailsModel udm;
	private Double orderPrice;

}
