package com.model;

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
//@Entity
public class PolicyType {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyTypeId;

    private String policyTypeValue;

}
