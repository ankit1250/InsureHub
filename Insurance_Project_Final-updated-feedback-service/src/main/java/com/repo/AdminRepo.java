package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.AdminFeedback;

@Repository
public interface AdminRepo extends CrudRepository<AdminFeedback, Long>{

}
