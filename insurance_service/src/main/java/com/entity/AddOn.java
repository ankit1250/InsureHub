package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AddOn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addOnId;

    @OneToOne
    @JoinColumn(name = "policyTypeId")
    private PolicyType policyType; // Reference the PolicyType entity, not Long

    private String addOnValue;

}