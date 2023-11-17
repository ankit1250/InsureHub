package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserDetails;
import com.model.UserDetailsModel;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsModel, Long>{

}
